package game;

import java.util.Random;

public class Enemy implements Human
{
	static int max_hp = 100;
	private int HP;
	String name;
	
	private Weapon currWeapon;
	private Human currEnemy;

	public Enemy(String name, int HP)
	{
		this.currWeapon = new M4();
		this.name = name;
		if(HP<=max_hp)
			this.HP=HP;
		else
			this.HP=100;
		this.name = name;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String getState()
	{
		String output = this.name;
		if(this.isDead())
			output += " is dead";
		else
			output += "HP: "+this.HP;
		return output;
	}
	
	@Override
	public Weapon getCurrWeapon() 
	{
		return currWeapon;
	}
	
	@Override
	public void setCurrWeapon(Weapon weapon) 
	{
		currWeapon = weapon;
	}
	
	@Override
	public void hit(int damage)
	{
		this.HP-=damage;
	}
	
	@Override
	public boolean isDead()
	{
		return this.HP<=0;
	}
	
	@Override
	public void heal(int HP)
	{
		this.HP+=HP;
		if(this.HP>max_hp) this.HP=100;
	}

	@Override
	public void setCurrEnemy(Human Enemy) 
	{
		this.currEnemy = Enemy;
	}

	@Override
	public Human getCurrEnemy() 
	{
		return this.currEnemy;
	}
	
	
	public String Action()
	{
		String output = "";
    	Random rn = new Random();
    	
    	if(this.HP<100 && Math.abs(rn.nextInt()%3)==0)	// heal if wounded
    	{
    		int HPgain = 15+rn.nextInt()%5;
    		this.heal(HPgain);
    		output+=this.name+" healed himself for "+HPgain+"\n";
    	}
    	else
    	{
    		if(!this.currEnemy.isDead() && Math.abs(rn.nextInt()%5)==0)	// attack player
    		{
    			output+=this.name+" shoots "+this.currEnemy.getName();
    			int damage = this.currWeapon.calculate_damage();
    			if(damage>0)
    			{
    				currEnemy.hit(damage);
    				output+= " and hits for "+damage;
    				if(this.currEnemy.isDead())
    				output+= " "+this.currEnemy.getName()+" dies!";
    			}
    			else
    				output+= " but misses "+damage;
    			output+="\n";
    		}
    	} 	  
		return output;
	}
}
