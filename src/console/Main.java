package console;

import game.Enemy;
import game.Game;
import game.Human;
import game.Player;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		Game game = new Game();
		ConsoleView consoleview = new ConsoleView();
			
		ArrayList<Enemy> EnemiesList = new ArrayList<>();
		EnemiesList.add(new Enemy("Terrorist 1", 100));
		EnemiesList.add(new Enemy("Terrorist 2", 35));
		EnemiesList.add(new Enemy("Terrorist 3", 100));	
		
		ArrayList<Player> PlayersList = new ArrayList<>();
		PlayersList.add(new Player("Player", 100));
		
		game.setPlayersList(PlayersList);
		game.setEnemiesList(EnemiesList);
		game.setView(consoleview);
		game.run();
		
		consoleview.setGame(game);
		consoleview.init();
	}
}
