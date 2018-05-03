package game;
public class Weapon_Info implements Command
{
	Player player;
	public Weapon_Info(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public String perform()
	{
        return player.getCurrWeapon().get_weapon_info() + "\n";
	}
}
