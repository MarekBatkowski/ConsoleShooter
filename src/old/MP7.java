package old;


public class MP7 implements Weapon
{
    private String name = "M7";
    private String type = "Automatic";
    private int damage = 10;
    private int ammo_capacity = 40;
    private int ammo;
    private String shoot_sound = "ta ta ta ta";

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
            ammo -= 4;
            System.out.println(shoot_sound);
        }
        else    System.out.println("no ammo!");
    }

    public void reload()
    {
        ammo = ammo_capacity;
    }

    public MP7()
    {
        ammo = ammo_capacity;
    }
}
