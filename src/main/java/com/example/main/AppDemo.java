package com.example.main;

import model.equipment.*;
import model.heros.*;

import java.util.ArrayList;

import static model.equipment.ArmorType.*;
import static model.equipment.Slot.*;
import static model.equipment.WeaponType.*;

public class AppDemo {

    public static void main(String[] args) throws InvalidWeaponException, InvalidLevelException {

        Armor chest = new Armor("Common Plate Chest",1, BODY, PLATE,new HeroAttribute(1,0,0));
        System.out.println(chest.getName());

        Weapon axe = new Weapon("Common Axe",1, WEAPON, AXES,2);
        System.out.println(axe.getName());

        Weapon staff = new Weapon("Common Staff", 1, WEAPON, STAFFS, 1);
        System.out.println(staff.getName());





        Mage m= new Mage("Miwa");
        System.out.println(m.getEquipment().get(WEAPON));
        System.out.println(m.equipWeapon(staff));
        System.out.println(chest.getSlot());
        System.out.println(chest.getArmorType());
        System.out.println(m.calTotalAttribute());

        System.out.println(m.display());
        System.out.println(m.baseHeroAttribute.getIntelligence());
        m.levelUp();
        System.out.println("Level: "+m.getLevel());
        System.out.println(m.display());



    }
}
