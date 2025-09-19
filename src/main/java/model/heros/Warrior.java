package model.heros;

import model.equipment.*;

import java.util.HashMap;
import java.util.Map;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(5, 2, 1 ,name, HeroClass.WARRIOR);
        this.validWeaponTypes.add(WeaponType.AXES);
        this.validWeaponTypes.add(WeaponType.HAMMERS);
        this.validWeaponTypes.add(WeaponType.SWORDS);
        this.validArmorTypes.add(ArmorType.MAIL);
        this.validArmorTypes.add(ArmorType.PLATE);


    }


    @Override
    public HeroAttribute levelUp() {
        this.gainLevel();
        this.baseHeroAttribute.levelAttributes( new HeroAttribute(3,2,1));
        this.calTotalAttribute();
        return this.totalHeroAttribute;
    }

    @Override
    protected int getDamagingAttribute(){
        return this.totalHeroAttribute.getStrength();
    }
   /* public double damage() {

        double weaponDamage =1;
        Weapon weapon = (Weapon) super.getEquipment().get(Slot.WEAPON);
        if (weapon != null)
        {
            weaponDamage = weapon.getWeaponDamage();
        }

        return weaponDamage * (1+ this.totalHeroAttribute.getStrength()/100);
    }*/

}
