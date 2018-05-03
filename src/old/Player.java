package old;
import java.util.ArrayList;

public class Player 
{
   Desert_Eagle sidearm = new Desert_Eagle();
   M4 Em4 = new M4();
   MP7 Smg  = new MP7();
   Weapon curr_weapon = sidearm;
   Inventory Backpack = new Inventory();
   public Player() 
   {
	   Backpack.add_weapon(Em4);
	   Backpack.add_weapon(Smg);
   }
   
   public Weapon getCurrentWeapon() {
	   return curr_weapon;
   }
   public void setCurrentWeapon(Weapon weapon) {
	   curr_weapon = weapon;
   }
   public void swap_weapons(int slot) {
	   setCurrentWeapon(Backpack.swap_weapons(getCurrentWeapon(), slot));
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
