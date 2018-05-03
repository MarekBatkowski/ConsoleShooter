package game;
import java.util.ArrayList;

public class Inventory_Shower implements Command
{
	Player player;
	public Inventory_Shower(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public String perform()
	{
		String output = "Current:\n"+player.getCurrWeapon().get_weapon_info()+"\nBackpack:";
	    ArrayList<String> content = player.getContent();
	    for(int i = 0; i < content.size(); i++)
	    {
	    	output += "\n"+ content.get(i);    
	    }
	    return output;
	}
}
