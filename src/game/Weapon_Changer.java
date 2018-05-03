package game;
//import java.util.ArrayList;
//import java.util.Scanner;

public class Weapon_Changer implements Command
{
	Player player;
	public Weapon_Changer(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public String perform()
	{
		player.swap_weapons(0);		
		return "Weapon changed to "+player.currWeapon.getShortInfo();
	}
}
