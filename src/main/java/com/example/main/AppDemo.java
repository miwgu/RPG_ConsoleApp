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
}
