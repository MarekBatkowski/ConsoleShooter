package game;

import java.util.Random;

public class Desert_Eagle implements Weapon
{
    private String name = "Desert_Eagle";
    private String type = "Semiautomatic";
    private int ammo;
    private String shoot_sound = "pow!";
    
    private int accuracy = 90;
    private int shots_per_turn = 1;
    private int damage = 30;
    private int ammo_capacity = 9;
    
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
            ammo -= 1;
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

    public Desert_Eagle()
    {
        ammo = ammo_capacity;
    }
}