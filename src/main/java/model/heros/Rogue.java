package model.heros;

import model.equipment.*;

import java.util.HashMap;
import java.util.Map;

public class Rogue extends Hero {

    private Map<Slot, Item> equipment = new HashMap<>();
    public Rogue(String name) {
        super(2, 6, 1, name, HeroClass.ROGUE);
        this.validWeaponTypes.add(WeaponType.DAGGERS);
        this.validWeaponTypes.add(WeaponType.SWORDS);
        this.validArmorTypes.add(ArmorType.LEATHER);
        this.validArmorTypes.add(ArmorType.MAIL);

    }


    @Override
    public HeroAttribute levelUp() {
        this.gainLevel();
        this.baseHeroAttribute.levelAttributes( new HeroAttribute(1,4,1));
        this.calTotalAttribute();
        return this.totalHeroAttribute;
    }

    @Override
    protected int getDamagingAttribute() {
        return this.totalHeroAttribute.getDexterity();
    }

   /* public double damage() {

        double weaponDamage =1;
        Weapon weapon = (Weapon) super.getEquipment().get(Slot.WEAPON);
        if (weapon != null)
        {
            weaponDamage = weapon.getWeaponDamage();
        }

        return weaponDamage * (1+ this.totalHeroAttribute.getDexterity()/100);
    }*/

}
