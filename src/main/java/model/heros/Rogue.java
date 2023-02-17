package model.heros;

import model.equipment.*;

import java.util.HashMap;
import java.util.Map;

public class Rogue extends Hero {

    private Map<Slot, Item> equipment = new HashMap<>();
    public Rogue(String name) {
        super(1, 1, 8, name, HeroClass.ROGUE);
        this.validWeaponTypes.add(WeaponType.DAGGERS);
        this.validWeaponTypes.add(WeaponType.SWORDS);
        this.validArmorTypes.add(ArmorType.LEATHER);
        this.validArmorTypes.add(ArmorType.MAIL);
    }


    @Override
    public HeroAttribute levelUp() {
        this.level++;
        this.baseHeroAttribute.levelAttributes( new HeroAttribute(1,1,5));
        return null;
    }
    /*

    @Override
    public void equip(Slot slot, Weapon weapon) {
        if (getLevel() >= weapon.getRequiredLevel() && getValidWeaponTypes().contains(weapon.getWeaponType())) {
            equipment.put(slot, weapon);
            setEquipment(equipment);    }

    }

    @Override
    public boolean equip(Slot slot, Armor armor) {
        if (getLevel() >= armor.getRequiredLevel() && getValidArmorTypes().contains(armor.getArmorType())) {
            equipment.put(slot, armor);
            setEquipment(equipment);        }
        return false;
    }

     */


    @Override
    public double damage() {

        double weaponDamage =1;
        Weapon weapon = (Weapon) super.getEquipment().get(Slot.WEAPON);
        if (weapon != null)
        {
            weaponDamage = weapon.getWeaponDamage();
        }

        return weaponDamage * (1+ this.totalHeroAttribute.getDexterity()/100);
    }

}
