package game;

public interface Human 
{
	String getName();
	String getState();
	Weapon getCurrWeapon();
	void setCurrEnemy(Human Enemy);
	Human getCurrEnemy();
	
	void setCurrWeapon(Weapon weapon);
	void hit(int damage);
	boolean isDead();
	void heal(int HP);
}
