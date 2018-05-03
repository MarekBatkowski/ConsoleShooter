package old;


public class M4 implements Weapon
{
    private String name = "M4";
    private String type = "Automatic";
    private int damage = 15;
    private int ammo_capacity = 30;
    private int ammo;
    private String shoot_sound = "pew pew pew";

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
            ammo -= 3;
            System.out.println(shoot_sound);
        }
        else    System.out.println("no ammo!");
    }

    public void reload()
    {
        ammo = ammo_capacity;
    }

    public M4()
    {
        ammo = ammo_capacity;
    }
}