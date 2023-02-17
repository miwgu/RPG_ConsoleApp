package model.equipment;

import model.equipment.Item;

public class Weapon extends Item {

    private WeaponType weaponType;

    public double weaponDamage;


    public Weapon(String name, int requiredLevel, Slot slot, WeaponType weaponType, double weaponDamage) {
        super(name, requiredLevel, slot);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }


    public double getWeaponDamage() {
        return weaponDamage;
    }

}
