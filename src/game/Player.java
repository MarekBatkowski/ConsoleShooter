package game;

import java.util.ArrayList;

public class Player implements Human
{
	static int max_hp = 100;
	String name;
	int HP;
	
	Weapon currWeapon;
	private Human currEnemy;
	private Inventory Backpack = new Inventory();
   
	public Player(String name, int HP) 
	{
		this.name = name;
		if(HP<=max_hp)
			this.HP=HP;
		else
			this.HP=100;
		this.currWeapon = new Desert_Eagle();
		Backpack.add_weapon(new M4());
		Backpack.add_weapon(new MP7());
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

	// functions specific to player
	
	public void swap_weapons(int slot) 
	{
		setCurrWeapon(Backpack.swap_weapons(getCurrWeapon(), slot));
	}
	
	public ArrayList<String> getBackpackList() 
	{		
		return Backpack.get_compact_list();
	}
	
	public ArrayList <String> getContent()
	{
		return Backpack.get_content();
	} 
}
