package old;


public class Desert_Eagle implements Weapon
{
    private String name = "Desert_Eagle";
    private String type = "Semiautomatic";
    private int damage = 40;
    private int ammo_capacity = 9;
    private int ammo;
    private String shoot_sound = "pow!";

    public String getName()
    {
        return name;
    }

    public String get_weapon_info()
    {
        String info = "name: " + name +
                "\ntype: " + type +
                "\ndamage: " + damage +
                "\nammo: " + ammo + "/" + ammo_capacity +
                "\n";
        return info;
    }

    public void use()
    {
        if(ammo>0)
        {
            ammo -= 1;
            System.out.println(shoot_sound);
        }
        else    System.out.println("no ammo!");
    }

    public void reload()
    {
        ammo = ammo_capacity;
    }

    public Desert_Eagle()
    {
        ammo = ammo_capacity;
    }
}