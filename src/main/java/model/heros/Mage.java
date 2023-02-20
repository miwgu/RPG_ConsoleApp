package model.heros;

import model.equipment.*;

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
        return this.totalHeroAttribute.levelAttributes(new HeroAttribute(1,1,5));
    }

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
