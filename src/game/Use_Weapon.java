package game;

public class Use_Weapon implements Command
{
	Player player;
	public Use_Weapon(Player player) 
	{
		this.player = player;
	}
	
	@Override
	public String perform()
	{	
		
		String info = player.getCurrWeapon().use();
		if(info!="no ammo!")
		{
			if(player.getCurrEnemy().isDead())
				info += "\nThis guy is already dead";
			else
			{
				int damage = player.currWeapon.calculate_damage();
				
				if(damage>0)
					info += "\nhit for "+ damage;
				else
					info +="\nmissed!";
				
				player.getCurrEnemy().hit(damage);
				if(player.getCurrEnemy().isDead())
					info += "\nEnemy is killed";
			}
		}
		
		return info;
	}
}
