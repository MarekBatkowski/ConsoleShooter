package old;
import java.util.ArrayList;

public class Inventory_Shower implements Command
{
	Player player;
	public Inventory_Shower(Player player) 
	{
		this.player = player;
	}
	
	public void perform()
	{
	    ArrayList<String> content = player.getContent();
	    for(int i = 0; i < content.size(); i++)
	    {
	        System.out.print(content.get(i));
	        System.out.println("");
	    }
	}
}
