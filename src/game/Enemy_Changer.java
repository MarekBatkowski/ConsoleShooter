package game;

public class Enemy_Changer implements Command 
{
	Player player;
	Game game;
	public Enemy_Changer(Player player, Game game) 
	{
		this.player = player;
		this.game = game;
	}
	
	@Override 
	public String perform() 
	{
		// get index
		for(int i = 0; i < game.EnemiesList.size(); i++)
		{
			if(game.EnemiesList.get(i)==player.getCurrEnemy())
			{
				if(i==game.EnemiesList.size()-1)
					player.setCurrEnemy(game.EnemiesList.get(0));
				else
					player.setCurrEnemy(game.EnemiesList.get(i+1));
				break;
			}
		}
		return player.getName() +" now aims for "+player.getCurrEnemy().getName();
	}
}
  