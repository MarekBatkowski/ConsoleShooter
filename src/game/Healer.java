package game;

import java.util.Random;

public class Healer implements Command
{
	Player player;
	public Healer(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public String perform()
	{
		Random rn = new Random();
		int HPgain = 30+Math.abs(rn.nextInt()%15);
		player.heal(HPgain);	
		return "Used medpack. Regained "+HPgain+" HP.";
	}
}
