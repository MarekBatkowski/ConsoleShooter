package game;

import java.util.Random;

public class M4 implements Weapon
{
    private String name = "M4";
    private String type = "Automatic";
    private int ammo;
    private String shoot_sound = "pew pew pew";
    
    private int accuracy = 75;
    private int shots_per_turn = 3;
    private int damage = 15;
    private int ammo_capacity = 30;

    @Override
    public String getShortInfo()
    {
        return this.name + " ("+this.ammo+"/"+this.ammo_capacity+")";
    }

    @Override
    public String get_weapon_info()
    {
        String info = "name: " + name + "\ttype: " + type +
                "\ndamage: " + damage + "\tammo: " + ammo + "/" + ammo_capacity +
                "\naccuracy: " + accuracy + "\tshots per turn: " + shots_per_turn +
                "\n";
        return info;
    }

    @Override
    public String use()
    {
        if(ammo>0)
        {
            ammo -= 3;
            return shoot_sound;
        }
        else    return "no ammo!";
    }

    @Override
    public int calculate_damage()
    {
        int damage = 0;
        for(int i=0; i<shots_per_turn; i++)
        {
        	Random rn = new Random();
        	if(Math.abs(rn.nextInt()%100)<this.accuracy)
        		damage+=this.damage;	
        }
        return damage;
    }
    
    @Override
    public void reload()
    {
        ammo = ammo_capacity;
    }

    public M4()
    {
        ammo = ammo_capacity;
    }
}
