package old;

public class Use_Weapon implements Command
{
	Player player;
	public Use_Weapon(Player player) 
	{
		this.player = player;
	}
	
	public void perform()
	{
		player.getCurrentWeapon().use();
	}
}
