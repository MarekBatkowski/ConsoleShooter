package old;
public class Weapon_Info implements Command
{
	Player player;
	public Weapon_Info(Player player) 
	{
		this.player = player;
	}
	
	public void perform()
	{
        System.out.print(player.getCurrentWeapon().get_weapon_info());
        System.out.println("");
	}
	
	
	private Weapon setcurrentweapon(Weapon curr_weapon)
	{
		return curr_weapon;
	}
}
