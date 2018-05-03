package game;
public class Weapon_Reloader implements Command
{
	Player player;
	public Weapon_Reloader(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public String perform()
	{
		player.getCurrWeapon().reload();
		return "Weapon reloaded";
	}
}
