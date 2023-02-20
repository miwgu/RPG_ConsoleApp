package model.heros;

import model.equipment.*;

import java.util.HashMap;
import java.util.Map;

public class Ranger extends Hero {

    public Ranger(String name) {
        super(1, 7, 1, name, HeroClass.RANGER);
        this.validWeaponTypes.add(WeaponType.BOWS);
        this.validArmorTypes.add(ArmorType.LEATHER);
        this.validArmorTypes.add(ArmorType.MAIL);

    }


    @Override
    public HeroAttribute levelUp() {
        this.level++;
        this.totalHeroAttribute.levelAttributes( new HeroAttribute(1,5,1));
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

    @Override
    public String toString() {
        return super.toString();
    }

}
