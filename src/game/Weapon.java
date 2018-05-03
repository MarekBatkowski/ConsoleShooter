package game;

public interface Weapon
{
    String getShortInfo();
    String get_weapon_info();
    String use();
    void reload();
    int calculate_damage();
}
