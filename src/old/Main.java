package old;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int option = 0;
        Scanner player_input = new Scanner(System.in);
        Player player = new Player();
        //Desert_Eagle sidearm = new Desert_Eagle();
        //M4 Em4 = new M4();
        //MP7 Smg  = new MP7();

        //Bron curr_weapon = sidearm;
        // WeaponChanger Swapper = new WeaponChanger();
        //Inventory Backpack = new Inventory();
        //Backpack.add_weapon(Em4);
        //Backpack.add_weapon(Smg);

        Command weaponinfo = new Weapon_Info(player);
        Command useweapon = new Use_Weapon(player);
        Command weaponreloader = new Weapon_Reloader(player);
        Command weaponchanger = new Weapon_Changer(player);
        Command inventoryshower = new Inventory_Shower(player);
        Command exiter = new Exiter();
        
        ArrayList<Command> CommandList = new ArrayList<>();
        CommandList.add(weaponinfo);
        CommandList.add(useweapon);
        CommandList.add(weaponreloader);
        CommandList.add(weaponchanger);
        CommandList.add(inventoryshower);
        CommandList.add(exiter);
        
        while(option!=6)
        {
            System.out.println("1 - display weapon info");
            System.out.println("2 - shoot");
            System.out.println("3 - reload");
            System.out.println("4 - change weapon");
            System.out.println("5 - show inventory");
            System.out.println("6 - exit");

            option = player_input.nextInt();
            
            CommandList.get(option-1).perform();
/*
            switch(option)
            {
                case 1:
                	weaponinfo.perform();
                    //System.out.print(curr_weapon.get_weapon_info());
                    System.out.println("");
                    break;

                case 2:
                	useweapon.perform();
                    //curr_weapon.use();
                    break;

                case 3:
                	weaponreloader.perform();
                    //curr_weapon.reload();
                    break;

                case 4:
                	weaponchanger.perform();
                	
                    ArrayList<String> compact_list = Backpack.get_compact_list();
                    for(int i = 0; i < compact_list.size(); i++)
                        System.out.println(i + " - " + compact_list.get(i));

                    curr_weapon = Backpack.swap_weapons(curr_weapon, player_input.nextInt());
                    break;

                case 5:
                	//inventoryshower.Show_Inventory(Backpack);
                	
                    ArrayList<String> content = Backpack.get_content();
                    for(int i = 0; i < content.size(); i++)
                    {
                        System.out.print(content.get(i));
                        System.out.println("");
                    }
                    break;

                case 6:
                	//option = exiter.gameexit();
                	
                    System.out.println("Exit The game? (1/0)");
                    if(player_input.nextInt() != 1)
                        option = 0;
                    break;

                default:
                    System.out.println("Wrong option!");
                    break;
            }
        */
        }
        player_input.close();
    }
}