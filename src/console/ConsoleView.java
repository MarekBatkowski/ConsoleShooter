package console;

import java.io.IOException;
import java.util.Scanner;

import game.View;
import game.Game;

public class ConsoleView implements View
{
	Game game;
	Scanner player_input;
	public void setGame(Game game) 
	{
		this.game = game;
	}
	
	@Override
	public void init()
	{
        int option = 0;
		player_input = new Scanner(System.in);
        while(option!=7)
        {
    		if(game.gameState==0)
    		{
    			option = this.input();  
	            game.execute_command(option-1); 
    		}
    		else 
    		{
    			game.execute_command(1);	// won't do anything anyway 
    			break;
    		}
        }
        player_input.close();
	} 
	
	public int input() 
	{
        System.out.println("1 - shoot");
        System.out.println("2 - reload");
        System.out.println("3 - change weapon");
        System.out.println("4 - change enemy");
        System.out.println("5 - show inventory");
        System.out.println("6 - take medkit");
        System.out.println("7 - exit");
		return player_input.nextInt();
	}
	
	@Override
	public void output(String content) 
	{
		System.out.println(content);
	}
	
	@Override
	public void printstatus(String status) 
	{ 
		System.out.println(status);
	}
}
