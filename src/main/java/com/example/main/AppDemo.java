package com.example.main;

import model.equipment.*;
import model.heros.*;

import java.util.ArrayList;

import static model.equipment.ArmorType.*;
import static model.equipment.Slot.*;
import static model.equipment.WeaponType.*;

public class AppDemo {
    /*
    static ArrayList<Hero> heroes = new ArrayList<>();
    private static final Weapon weaponAxes = new Weapon("Axes", 1, Slot.WEAPON, PLATE, 10);
    private static final Weapon weaponBows = new Weapon("Bows", 1, WEAPON, BOWS, 0);
    private static final Weapon weaponDaggers = new Weapon("Dagger", 1, WEAPON, DAGGERS, 0);
    private static final Weapon weaponHammers = new Weapon("Hammers", 1, WEAPON, HAMMERS, 0);
    private static final Weapon weaponStaffs = new Weapon("Staffs", 1, WEAPON, STAFFS, 0);
    private static final Weapon weaponSwords = new Weapon("Swords", 1, WEAPON, SWORDS, 0);
    private static final Weapon weaponWands = new Weapon("Wands", 1, WEAPON, WANDS, 0);
    private static final Armor armorCloth = new Armor("Cloth", 1, LEGS, CLOTH, new HeroAttribute());
    private static final Armor armorLeather = new Armor("Leather", 1, LEGS, LEATHER, new HeroAttribute());
    private static final Armor armorMail = new Armor("Mail", 1, LEGS, MAIL, new HeroAttribute());
    private static final Armor armorPlate = new Armor("Plate", 1, LEGS, PLATE, new HeroAttribute());

     */

    public static void main(String[] args) throws InvalidWeaponException, InvalidLevelException, InvalidArmorException {

        Armor chest = new Armor("Common Plate Chest",1, Slot.BODY, ArmorType.PLATE,new HeroAttribute(1,0,0));
        System.out.println(chest.getName());

        Weapon axe = new Weapon("Common Axe",1, Slot.WEAPON, AXES,2);
        System.out.println(axe.getName());



        /*
        this.validWeaponTypes.add(WeaponType.STAFFS);
        this.validWeaponTypes.add(WeaponType.WANDS);
        this.validArmorTypes.add(ArmorType.CLOTH);
        *
        * */

        Warrior wa= new Warrior("Chiyo");
        System.out.println("Da" + 1*(1 + (5 / 100)));
        System.out.println("Damage"+ wa.damage());
        System.out.println(wa.display());



        System.out.println(wa.equipWeapon(WEAPON,axe));
        System.out.println(wa.equipArmor(BODY,chest));

        System.out.println(wa.getEquipment());




        Mage m= new Mage("Miwa");
        System.out.println(m.display());
        System.out.println(m.baseHeroAttribute.getIntelligence());
        m.levelUp();
        System.out.println("Level: "+m.getLevel());

        //System.out.println(m.equipWeapon(WEAPON,w));

        System.out.println("****************************************");
        System.out.println(m.totalHeroAttribute.getDexterity());
        System.out.println(m.totalHeroAttribute.getStrength());
        System.out.println(m.totalHeroAttribute.getIntelligence());
        System.out.println("****************************************");

        System.out.println(m.display());

        m.levelUp();
        System.out.println("Level: "+m.getLevel());
        System.out.println(m.display());

        System.out.println(" Om man skrivit om damage då det fungerar....****************************************");
        System.out.println("Damage:" +m.damage());
        System.out.println("calTotalAttribute: "+m.calTotalAttribute());


        System.out.println(m.display());



    }
}
