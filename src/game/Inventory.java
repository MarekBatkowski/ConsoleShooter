package game;

import java.util.ArrayList;

public class Inventory
{
    private ArrayList <Weapon> weapon_list = new ArrayList<>();

    Weapon sidearm = new Desert_Eagle();
    Weapon sidearm2 = new Desert_Eagle();
    Weapon Em4  = new M4();

    public void add_weapon(Weapon weapon)
    {
        weapon_list.add(weapon);
    }

    private void remove_weapon(int slot)
    {
        weapon_list.remove(slot);
    }

    public ArrayList <String> get_content()
    {
        ArrayList <String> content = new ArrayList<>();

        for(int i = 0; i < weapon_list.size(); i++)
            content.add(weapon_list.get(i).get_weapon_info());

        return content;
    }

    public ArrayList <String> get_compact_list()
    {
        ArrayList <String> compact_list = new ArrayList<>();

        for(int i = 0; i < weapon_list.size(); i++)
            compact_list.add(weapon_list.get(i).getShortInfo());

        return compact_list;
    }

    public Weapon swap_weapons(Weapon curr_weapon, int slot)
    {
        if(slot < 0 || slot > weapon_list.size())
            throw new ArrayIndexOutOfBoundsException("Niepoprawny numer broni");
        weapon_list.add(curr_weapon);
        Weapon new_curr_weapon = weapon_list.get(slot);
        weapon_list.remove(new_curr_weapon);
        return new_curr_weapon;
    }
}
