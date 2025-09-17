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
                        Weapon randomWeapon = randomWeapon(random);
                        try{
                            hero.equipWeapon(randomWeapon);
                            System.out.println("Equipped weapon: " + randomWeapon.getName());

                        }catch(Exception e){
                            System.out.println("Cannot equip: " + e.getMessage());
                        }
                        break;
                    case 3:
                        Armor randomArmor = randomArmor(random);
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



        /*
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
*/


    }

    //for Mage--random weapon
    private static Weapon randomWeapon(Random random) {
        String[] names = {"Common Staff", "Apprentice Wand", "Mage's Rod"};
        int dmg = 1 + random.nextInt(5);
        return new Weapon(names[random.nextInt(names.length)], 1, WEAPON, STAFFS, dmg);
    }

    //for Mage--random Armor
    private static Armor randomArmor(Random random) {
        String[] names = {"Cloth Hat", "Cloth Robe", "Cloth Pants"};
        int str = random.nextInt(3);
        int dex = random.nextInt(3);
        int intl = random.nextInt(5);
        return new Armor(names[random.nextInt(names.length)], 1, BODY, CLOTH, new HeroAttribute(str, dex, intl));
    }
}
