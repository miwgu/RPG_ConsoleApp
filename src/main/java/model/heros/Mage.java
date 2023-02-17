package model.heros;

import model.equipment.*;

import java.util.HashMap;
import java.util.Map;

public class Mage extends Hero{


    public Mage(String name) {
        super(1, 1, 8, name, HeroClass.MAGE);
        this.validWeaponTypes.add(WeaponType.STAFFS);
        this.validWeaponTypes.add(WeaponType.WANDS);
        this.validArmorTypes.add(ArmorType.CLOTH);
    }

    @Override
    public HeroAttribute levelUp() {
        this.gainLevel();
        return this.baseHeroAttribute.levelAttributes(new HeroAttribute(1,1,5));
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


    //Hero damage = WeaponDamage * (1 + DamagingAttribute/100)
    @Override
    public double damage() {

        double weaponDamage =1;
        Weapon weapon = (Weapon) super.getEquipment().get(Slot.WEAPON);
        if (weapon != null)
        {
            weaponDamage = weapon.getWeaponDamage();
        }

        return  weaponDamage * (1+ this.totalHeroAttribute.getIntelligence()/100);
    }

}
