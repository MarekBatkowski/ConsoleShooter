package old;
import java.util.ArrayList;
import java.util.Scanner;

public class Weapon_Changer implements Command
{
	Player player;
	public Weapon_Changer(Player player) 
	{
		this.player = player;
	}
	
	public void perform()
	{
		Scanner player_input = new Scanner(System.in);
		ArrayList<String> compact_list = player.getBackpackList();
	    for(int i = 0; i < compact_list.size(); i++)
	        System.out.println(i + " - " + compact_list.get(i));
	
	    player.swap_weapons(player_input.nextInt());
	    player_input.close();
	}
}
