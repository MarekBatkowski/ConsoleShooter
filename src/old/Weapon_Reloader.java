package old;
public class Weapon_Reloader implements Command
{
	Player player;
	public Weapon_Reloader(Player player) 
	{
		this.player = player;
	}
	
	public void perform()
	{
		player.getCurrentWeapon().reload();
	}
}
