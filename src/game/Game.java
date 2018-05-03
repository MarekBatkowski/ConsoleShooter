package game;

import java.util.ArrayList;

public class Game // observed
{
	View view;	// console or gui
	ArrayList<Command> CommandList; 
	ArrayList<Enemy> EnemiesList;
	ArrayList<Player> PlayersList;
	
	//int CurrEnemyIndex;
	public int gameState;	// 0 - not finished, 1 - player won, 2 - player lost;
	
	public void setPlayersList(ArrayList<Player> PlayersList)
	{
		this.PlayersList = PlayersList;
	}
	
	public void setEnemiesList(ArrayList<Enemy> EnemiesList)
	{
		this.EnemiesList = EnemiesList;
	}
	
	public void setView(View view)
	{
		this.view = view;
	}
	
	String Status()
	{
		String Status = PlayersList.get(0).getState()+"\n"
				  	  + PlayersList.get(0).currWeapon.getShortInfo()+"\n\n";
	
		for(int i = 0; i < EnemiesList.size(); i++)
		{
			Status+=EnemiesList.get(i).getState();
			if(PlayersList.get(0).getCurrEnemy()==EnemiesList.get(i)) 
				Status+=" <--";
			Status+="\n";
		}
		return Status;
	}
	
	public void run()
	{	
		gameState=0;
	
		for(int i = 0; i < PlayersList.size(); i++)
			PlayersList.get(i).setCurrEnemy(EnemiesList.get(0));
		
		for(int i = 0; i < EnemiesList.size(); i++)
			EnemiesList.get(i).setCurrEnemy(PlayersList.get(0));
		
        CommandList = new ArrayList<>();
        CommandList.add(new Use_Weapon(PlayersList.get(0)));
        //CommandList.add(new Weapon_Info(PlayersList.get(0)));
        CommandList.add(new Weapon_Reloader(PlayersList.get(0)));
        CommandList.add(new Weapon_Changer(PlayersList.get(0)));
        CommandList.add(new Enemy_Changer(PlayersList.get(0), this));
        CommandList.add(new Inventory_Shower(PlayersList.get(0)));
        CommandList.add(new Healer(PlayersList.get(0)));
        CommandList.add(new Exiter());
        
        printstatus(Status());
	}
	
	public void execute_command(int ID)
	{
		String TurnResult = "";
		if(gameState==0)
		{	
			TurnResult+=CommandList.get(ID).perform()+"\n\n";
			
			int killed = 0;	
			for(int i = 0; i < EnemiesList.size(); i++)
			{
				if(!EnemiesList.get(i).isDead())
					TurnResult+=EnemiesList.get(i).Action();
				else
					killed+=1;
			}
			
			if(killed==EnemiesList.size())	gameState=1;	// all enemies killed, game is won
			if(PlayersList.get(0).isDead())	gameState=2;	// player is dead, game lost;
		}	
		else
		{
			if(gameState==1)
				TurnResult=PlayersList.get(0).getName()+" won!";	
			else
				TurnResult="Game Over";
		}
						
		printstatus(Status());
		output(TurnResult);
	}
	
	public void printstatus(String status)
	{
		view.printstatus(status);
	}
	
	public void output(String content)
	{
		view.output(content);
	}
}
