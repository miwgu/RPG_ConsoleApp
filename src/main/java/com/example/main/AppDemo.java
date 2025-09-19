package com.example.main;

import model.equipment.*;
import model.heros.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static model.equipment.ArmorType.*;
import static model.equipment.Slot.*;
import static model.equipment.WeaponType.*;

public class AppDemo {

    public static void main(String[] args) throws InvalidWeaponException, InvalidLevelException {

        Scanner sc = new Scanner(System.in);
        Random random  = new Random();

        System.out.println("----------Welcome to Java RPG----------");

        // input your name
        System.out.println("Enter your Hero´s name: ");
        String name = sc.nextLine();

        Hero hero = null;
        while (hero== null) {
            System.out.println("Choose your hero");
            System.out.println(
                    "1. Mage" + "\n" +
                    "2. Ranger" + "\n" +
                    "3. Rogue" + "\n" +
                    "4. Warrior");

            String input = sc.nextLine();// it is best to get input with text
            try {
                int heroChoice = Integer.parseInt(input);

                if (heroChoice == 1) {
                    hero = new Mage(name);
                } else if (heroChoice == 2) {
                    hero = new Ranger(name);
                } else if (heroChoice == 3) {
                    hero = new Rogue(name);
                } else if (heroChoice == 4) {
                    hero = new Warrior(name);
                } else {
                    System.out.println("You need to choose 1-4");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a number 1-4 !");
            }
        }

        System.out.println("\nHero Created!");
        System.out.println(hero.display());

        // -- start to choose action!------
        boolean playing = true;
        while (playing) {
            System.out.println("Choose action");
            System.out.println(
                    "1. Level up" + "\n" +
                            "2. Equip Random Weapon" + "\n" +
                            "3. Equip Random Armor" + "\n" +
                            "4. Show Stats" + "\n" +
                            "5. Exit");

            String input = sc.nextLine();

            try {
                int action = Integer.parseInt(input);

                switch (action) {
                    case 1:
                        hero.levelUp();
                        System.out.println("You leveled up!");
                        break;
                    case 2:
                        Weapon randomWeapon = randomWeapon(random, hero);
                        try{
                            hero.equipWeapon(randomWeapon);
                            System.out.println("Equipped weapon: " + randomWeapon.getName());

                        }catch(Exception e){
                            System.out.println("Cannot equip: " + e.getMessage());
                        }
                        break;
                    case 3:
                        Armor randomArmor = randomArmor(random, hero);
                        try{
                            hero.equipArmor(randomArmor);
                            System.out.println("Equipped armor: " + randomArmor.getName());

                        }catch(Exception e){
                            System.out.println("Cannot equip: " + e.getMessage());
                        }
                        break;
                    case 4:
                        hero.calTotalAttribute();
                        System.out.println(hero.display());
                        break;
                    case 5:
                        playing = false;
                        System.out.println("Exiting game! Bye👋");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number 1-4 !");
            }

        }

    }


    private static Weapon randomWeapon(Random random, Hero hero) {
        WeaponType type = hero.validWeaponTypes.get(random.nextInt(hero.validWeaponTypes.size()));
        String[] names;

        switch (type) {
            case AXES -> names = new String[]{"Battle Axe", "Executioner's Axe", "War Axe"};
            case BOWS -> names = new String[]{"Short Bow", "Long Bow", "Composite Bow"};
            case DAGGERS -> names = new String[]{"Stiletto", "Shadow Dagger", "Ceremonial Dagger"};
            case HAMMERS -> names = new String[]{"War Hammer", "Light Hammer", "Thunder Hammer"};
            case STAFFS -> names = new String[]{"Apprentice Staff", "Wizard's Staff", "Elder Staff"};
            case SWORDS -> names = new String[]{"Iron Sword", "Steel Sword", "Flame Sword"};
            case WANDS -> names = new String[]{"Oak Wand", "Crystal Wand", "Arcane Wand"};
            default -> names = new String[]{"Common Weapon"};
        }
        // level based damage
        int baseDmg = hero.getLevel();
        int bonus = random.nextInt(3);
        int dmg = baseDmg + bonus;
        return new Weapon(names[random.nextInt(names.length)], 1, Slot.WEAPON, type, dmg);
    }


    private static Armor randomArmor(Random random, Hero hero) {
        ArmorType type = hero.validArmorTypes.get(random.nextInt(hero.validArmorTypes.size()));
        String[] names;

        switch (type) {
            case CLOTH -> names = new String[]{"Cloth Hat", "Cloth Robe", "Cloth Pants"};
            case LEATHER -> names = new String[]{"Leather Hood", "Leather Vest", "Leather Pants"};
            case MAIL -> names = new String[]{"Mail Coif", "Mail Hauberk", "Mail Leggings"};
            case PLATE -> names = new String[]{"Plate Helmet", "Plate Chestplate", "Plate Leggings"};
            default -> names = new String[]{"Common Armor"};
        }

        // level based status
        int str = hero.getLevel()/2 + random.nextInt(3);
        int dex = hero.getLevel()/2 + random.nextInt(3);
        int intl = hero.getLevel()/2 + random.nextInt(3);
        return new Armor(names[random.nextInt(names.length)], 1, Slot.BODY, type, new HeroAttribute(str, dex, intl));
    }
}
