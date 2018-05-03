package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

import game.Game;
import game.View;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;

public class GuiView implements View 
{
	Game game;
	
	public void setGame(Game game) 
	{
		this.game = game;
	}
	
	private JFrame frame;
	JTextArea OutputBox;
	JTextArea Infobox;

	public void init() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					//GuiView window = new GuiView();
					//window.frame.setVisible(true);
					GuiView.this.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public GuiView() 
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnShoot = new JButton("Shoot");
		btnShoot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				game.execute_command(0);
			}
		});
		panel.add(btnShoot);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				game.execute_command(1);
			}
		});
		panel.add(btnReload);
		
		JButton btnChangeWeapon = new JButton("Change weapon");
		btnChangeWeapon.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				game.execute_command(2);
			}
		});
		panel.add(btnChangeWeapon);
		
		JButton btnChangeEnemy = new JButton("Change Enemy");
		btnChangeEnemy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				game.execute_command(3);
			}
		});
		panel.add(btnChangeEnemy);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				game.execute_command(4);
			}
		});
		panel.add(btnInventory);
		
		JButton btnMedkit = new JButton("Medkit");
		btnMedkit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				game.execute_command(5);
			}
		});
		panel.add(btnMedkit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		OutputBox = new JTextArea(0, 0);
		OutputBox.setForeground(new Color(255, 255, 255));
		OutputBox.setBackground(new Color(0, 0, 0));
		OutputBox.setPreferredSize(new Dimension(450, 320));
		OutputBox.setMinimumSize(new Dimension(450, 320));
		OutputBox.setBounds(0, 0, 400, 400);
		panel_1.add(OutputBox);
		//JScrollPane sp = new JScrollPane(OutputBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		
		Infobox = new JTextArea(0, 0);
		Infobox.setForeground(new Color(255, 255, 255));
		Infobox.setBackground(new Color(0, 0, 0));
		Infobox.setPreferredSize(new Dimension(220, 320));
		Infobox.setMinimumSize(new Dimension(220, 320));
		panel_2.add(Infobox);

	}

	@Override
	public void output(String content) 
	{
		OutputBox.setText(content);
	}
	
	@Override
	public void printstatus(String status) 
	{
		Infobox.setText(status);
	}
}
