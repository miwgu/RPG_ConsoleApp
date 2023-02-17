package model.heros;

import model.equipment.*;
import model.heros.Warrior;
import model.heros.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static model.equipment.Slot.WEAPON;
import static model.equipment.WeaponType.AXES;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Hero hero;
    HeroAttribute heroAttribute;
    Mage mage;
    Ranger ranger;
    Rogue rogue;
    Warrior warrior;

    Weapon weapon;
    Armor armor;
    Map<Slot, Item> equipment;


    @BeforeEach
    void  setUp() {

        mage = new Mage("Mage");
        ranger = new Ranger("Ranger");
        rogue = new Rogue("Rogue");
        warrior = new Warrior("Warrior");


    }
    
    @Test
    void heroAttributeTest() {
        HeroAttribute m = new HeroAttribute(1, 1, 8);

        assertEquals(m.getStrength(), 1);
        assertEquals(m.getDexterity(), 1);
        assertEquals(m.getIntelligence(), 8);
        assertNotEquals(m.getStrength(),2);
        assertNotEquals(m.getDexterity(), 2);
        assertNotEquals(m.getIntelligence(), 3);

        HeroAttribute ra = new HeroAttribute(1, 7, 1);
        assertEquals(ra.getStrength(), 1);
        assertEquals(ra.getDexterity(), 7);
        assertEquals(ra.getIntelligence(), 1);
        assertNotEquals(ra.getStrength(),2);
        assertNotEquals(ra.getDexterity(), 6);
        assertNotEquals(ra.getIntelligence(), 8);

        HeroAttribute ro = new HeroAttribute(2,6,1);
        assertEquals(ro.getStrength(), 2);
        assertEquals(ro.getDexterity(), 6);
        assertEquals(ro.getIntelligence(), 1);
        assertNotEquals(ro.getStrength(),3);
        assertNotEquals(ro.getDexterity(), 5);
        assertNotEquals(ro.getIntelligence(), 2);

        HeroAttribute wa = new HeroAttribute(5,2,1);
        assertEquals(wa.getStrength(), 5);
        assertEquals(wa.getDexterity(), 2);
        assertEquals(wa.getIntelligence(), 1);
        assertNotEquals(wa.getStrength(),3);
        assertNotEquals(wa.getDexterity(), 3);
        assertNotEquals(wa.getIntelligence(), 3);

    }


    @Test
    void ValidEquipWeapon() throws InvalidWeaponException, InvalidLevelException {
       // Weapon staff = new Weapon("Staff fo Testing", 1, slot.WEAPON, WeaponType.STAFFS, 10);
        Weapon test_staff = new Weapon("TestStaff",1, Slot.WEAPON, WeaponType.STAFFS,10);
        mage.equipWeapon(WEAPON, test_staff);
        //equipment.put(WEAPON, test_staff);
        //System.out.println(equipment.get(WEAPON));

        assertEquals(test_staff.getWeaponType(), mage.getEquipment().get(WEAPON));}

    @Test
    void InvalidEquipWeapon() {
        Weapon sword = new Weapon("Sword fo Testing", 1, WEAPON, WeaponType.SWORDS, 10);
        Exception weaponException = assertThrows(InvalidWeaponException.class, () -> mage.equipWeapon(WEAPON, sword));
        String actual = weaponException.getMessage();    String expected = "Weapon type is not allowed for this character";
        assertEquals(expected, actual);}

/*
    @Test
    void getHeroAttributeTest() {

        assertEquals(mage.getHeroAttribute("Mage").getStrength(),1 );
        assertEquals(mage.getHeroAttribute("Mage").getDexterity(),1 );
        assertEquals(mage.getHeroAttribute("Mage").getIntelligence(),8 );
        assertNotEquals(mage.getHeroAttribute("Mage").getStrength(),2 );
        assertNotEquals(mage.getHeroAttribute("Mage").getDexterity(),2 );
        assertNotEquals(mage.getHeroAttribute("Mage").getIntelligence(),3 );


        assertEquals(ranger.getHeroAttribute("Ranger").getStrength(),1 );
        assertEquals(ranger.getHeroAttribute("Ranger").getDexterity(),7 );
        assertEquals(ranger.getHeroAttribute("Ranger").getIntelligence(),1 );
        assertNotEquals(ranger.getHeroAttribute("Ranger").getStrength(),2 );
        assertNotEquals(ranger.getHeroAttribute("Ranger").getDexterity(),6 );
        assertNotEquals(ranger.getHeroAttribute("Ranger").getIntelligence(),2 );


        assertEquals(rogue.getHeroAttribute("Rogue").getStrength(),2 );
        assertEquals(rogue.getHeroAttribute("Rogue").getDexterity(),6 );
        assertEquals(rogue.getHeroAttribute("Rogue").getIntelligence(),1 );
        assertNotEquals(rogue.getHeroAttribute("Rogue").getStrength(),3 );
        assertNotEquals(rogue.getHeroAttribute("Rogue").getDexterity(),7 );
        assertNotEquals(rogue.getHeroAttribute("Rogue").getIntelligence(),2 );



        assertEquals(warrior.getHeroAttribute("Warrior").getStrength(),5 );
        assertEquals(warrior.getHeroAttribute("Warrior").getDexterity(),2 );
        assertEquals(warrior.getHeroAttribute("Warrior").getIntelligence(),1 );
        assertNotEquals(warrior.getHeroAttribute("Warrior").getStrength(),4 );
        assertNotEquals(warrior.getHeroAttribute("Warrior").getDexterity(),3 );
        assertNotEquals(warrior.getHeroAttribute("Warrior").getIntelligence(),3 );

        //assertEquals(warrior.getDefaultHeroAttribute("AAAA").,"The name AAAA is not Hero name. You need to write Mage, Range, Rouge or Warrior" );


    }

 */

/*
    @Test
    void heroAttributeUpdatedTest (){
        HeroAttribute m = new HeroAttribute(1, 1, 8);

        int expectedStrength_Mage = m.getStrength()+1;
        int expectedDexterity_Mage = m.getDexterity()+1;
        int expectedIntelligence_Mage = m.getIntelligence()+5;
        int expectedLevel_Mage= 2;

        mage.levelUp("Mage");// added levelupp value 1,1,5
        HeroAttribute actualHeroMarge = mage.getHeroAttribute();//2,2,13
        int actualLevel_Mage= mage.getLevel();
        assertEquals(expectedStrength_Mage, actualHeroMarge.getStrength() );
        assertEquals(expectedDexterity_Mage, actualHeroMarge.getDexterity() );
        assertEquals(expectedIntelligence_Mage, actualHeroMarge.getIntelligence() );
        assertEquals(expectedLevel_Mage, actualLevel_Mage);



        HeroAttribute ra = new HeroAttribute(1,7,1);

        int expectedStrength_Ranger = ra.getStrength()+1;
        int expectedDexterity_Ranger = ra.getDexterity()+5;
        int expectedIntelligence_Ranger = ra.getIntelligence()+1;
        int expectedLevel_Ranger= 2;

        ranger.levelUp("Ranger");// added levelupp value 1,1,5
        HeroAttribute actualHero_Ranger = ranger.getHeroAttribute();//2,2,13
        int actualLevel_Ranger= ranger.getLevel();
        assertEquals(expectedStrength_Ranger, actualHero_Ranger.getStrength() );
        assertEquals(expectedDexterity_Ranger, actualHero_Ranger.getDexterity() );
        assertEquals(expectedIntelligence_Ranger, actualHero_Ranger.getIntelligence() );
        assertEquals(expectedLevel_Ranger, actualLevel_Ranger);


        HeroAttribute ro = new HeroAttribute(2,6,1);

        int expectedStrength_Rogue = ro.getStrength()+1+1;
        int expectedDexterity_Rogue = ro.getDexterity()+4+4;
        int expectedIntelligence_Rogue = ro.getIntelligence()+1+1;
        int expectedLevel_Rogue= 3;

        rogue.levelUp("Rogue");//first added levelupp value (1, 4, 1)
        rogue.levelUp("Rogue");//second added levelupp value (1, 4, 1)
        HeroAttribute actualHero_Rogue = rogue.getHeroAttribute();//2,2,13
        int actualLevel_Rogue= rogue.getLevel();
        assertEquals(expectedStrength_Rogue, actualHero_Rogue.getStrength() );
        assertEquals(expectedDexterity_Rogue, actualHero_Rogue.getDexterity() );
        assertEquals(expectedIntelligence_Rogue, actualHero_Rogue.getIntelligence() );
        assertEquals(expectedLevel_Rogue, actualLevel_Rogue);

 */



        /*
        assertEquals(m.getStrength(), 2 );
        assertEquals(m.getDexterity(),2 );
        assertEquals(m.getIntelligence(),13 );
        assertNotEquals(m.getStrength(),3 );
        assertNotEquals(m.getDexterity(),5 );
        assertNotEquals(m.getIntelligence(),3 );

        HeroAttribute ra = new HeroAttribute(1,7,1);
        ra.heroAttributeUpdated(1,5,1);
        assertEquals(ra.getStrength(),2 );
        assertEquals(ra.getDexterity(),12 );
        assertEquals(ra.getIntelligence(),2 );
        assertNotEquals(ra.getStrength(),1 );
        assertNotEquals(ra.getDexterity(),6 );
        assertNotEquals(ra.getIntelligence(),3 );


        HeroAttribute ro = new HeroAttribute(2,6,1);
        ro.heroAttributeUpdated(1,4,1);
        assertEquals(ro.getStrength(),3 );
        assertEquals(ro.getDexterity(),10 );
        assertEquals(ro.getIntelligence(),2 );
        assertNotEquals(ro.getStrength(),1 );
        assertNotEquals(ro.getDexterity(),11 );
        assertNotEquals(ro.getIntelligence(),3 );


        HeroAttribute wa = new HeroAttribute(5,2,1);
        wa.heroAttributeUpdated(3,2,1);

        assertEquals(wa.getStrength(),8 );
        assertEquals(wa.getDexterity(),4 );
        assertEquals(wa.getIntelligence(),2 );
        assertNotEquals(wa.getStrength(),7 );
        assertNotEquals(wa.getDexterity(),3 );
        assertNotEquals(wa.getIntelligence(),5 );



    }

         */

    /*
    @Test
    void levelUpTest() {

        assertEquals(mage.levelUp("Mage").getStrength(),1 );
        assertEquals(mage.levelUp("Mage").getDexterity(),1 );
        assertEquals(mage.levelUp("Mage").getIntelligence(),5 );
        assertNotEquals(mage.levelUp("Mage").getStrength(),3 );
        assertNotEquals(mage.levelUp("Mage").getDexterity(),5 );
        assertNotEquals(mage.levelUp("Mage").getIntelligence(),3 );




        assertEquals(ranger.levelUp("Ranger").getStrength(),1 );
        assertEquals(ranger.levelUp("Ranger").getDexterity(),5 );
        assertEquals(ranger.levelUp("Ranger").getIntelligence(),1 );
        assertNotEquals(ranger.levelUp("Ranger").getStrength(),2 );
        assertNotEquals(ranger.levelUp("Ranger").getDexterity(),6 );
        assertNotEquals(ranger.levelUp("Ranger").getIntelligence(),3 );


        assertEquals(rogue.levelUp("Rogue").getStrength(),1 );
        assertEquals(rogue.levelUp("Rogue").getDexterity(),4 );
        assertEquals(rogue.levelUp("Rogue").getIntelligence(),1 );
        assertNotEquals(rogue.levelUp("Rogue").getStrength(),2 );
        assertNotEquals(rogue.levelUp("Rogue").getDexterity(),11 );
        assertNotEquals(rogue.levelUp("Rogue").getIntelligence(),3 );


        assertEquals(warrior.levelUp("Warrior").getStrength(),3 );
        assertEquals(warrior.levelUp("Warrior").getDexterity(),2 );
        assertEquals(warrior.levelUp("Warrior").getIntelligence(),1 );
        assertNotEquals(warrior.levelUp("Warrior").getStrength(),7 );
        assertNotEquals(warrior.levelUp("Warrior").getDexterity(),3 );
        assertNotEquals(warrior.levelUp("Warrior").getIntelligence(),5 );
    }

     */

    @Test
    void totalAttribute() {
    }
}