package game;

import java.util.Random;

public class MP7 implements Weapon
{
    private String name = "M7";
    private String type = "Automatic";
    private int ammo;
    private String shoot_sound = "ta ta ta ta";
    
    private int accuracy = 60;
    private int shots_per_turn = 4;
    private int damage = 10;
    private int ammo_capacity = 40;

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
            ammo -= 4;
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

    public MP7()
    {
        ammo = ammo_capacity;
    }

}
