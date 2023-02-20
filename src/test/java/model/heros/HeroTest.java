package model.heros;

import model.equipment.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static model.equipment.ArmorType.PLATE;
import static model.equipment.Slot.BODY;
import static model.equipment.Slot.WEAPON;
import static model.equipment.WeaponType.*;
import static model.heros.HeroClass.*;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Mage mage;
    Ranger ranger;
    Rogue rogue;
    Warrior warrior;

    Weapon weapon;
    Armor armor;
    Map<Slot, Item> equipment;


    @BeforeEach
    void  setUp() {

        mage = new Mage("Miwa");
        ranger = new Ranger("Reiko");
        rogue = new Rogue("Mika");
        warrior = new Warrior("Chiyo");

    }


    @Test
    void heroNameTest(){
        String expected_Mage_name ="Miwa";
        String expected_Ranger_name ="Reiko";
        String expected_Rogue_name = "Mika";
        String expected_Warrior_name = "Chiyo";

        assertEquals(mage.getName(),expected_Mage_name);
        assertEquals(ranger.getName(),expected_Ranger_name);
        assertEquals(rogue.getName(),expected_Rogue_name);
        assertEquals(warrior.getName(),expected_Warrior_name);
    }
    @Test
    void initialLevelTest() {
        int expectedInitialLevel=1;
        assertEquals(mage.getLevel(),expectedInitialLevel);
        assertEquals(ranger.getLevel(),expectedInitialLevel);
        assertEquals(rogue.getLevel(),expectedInitialLevel);
        assertEquals(warrior.getLevel(),expectedInitialLevel);
    }
    @Test
    void baseHeroAttributeTest() {
        assertEquals(mage.baseHeroAttribute.getStrength(),1);
        assertEquals(mage.baseHeroAttribute.getDexterity(), 1);
        assertEquals(mage.baseHeroAttribute.getIntelligence(), 8);
        assertNotEquals(mage.baseHeroAttribute.getStrength(),2);
        assertNotEquals(mage.baseHeroAttribute.getDexterity(), 2);
        assertNotEquals(mage.baseHeroAttribute.getDexterity(), 3);

        assertEquals(ranger.baseHeroAttribute.getStrength(), 1);
        assertEquals(ranger.baseHeroAttribute.getDexterity(), 7);
        assertEquals(ranger.baseHeroAttribute.getIntelligence(), 1);
        assertNotEquals(ranger.baseHeroAttribute.getStrength(),2);
        assertNotEquals(ranger.baseHeroAttribute.getDexterity(), 6);
        assertNotEquals(ranger.baseHeroAttribute.getIntelligence(), 8);

        assertEquals(rogue.baseHeroAttribute.getStrength(), 2);
        assertEquals(rogue.baseHeroAttribute.getDexterity(), 6);
        assertEquals(rogue.baseHeroAttribute.getIntelligence(), 1);
        assertNotEquals(rogue.baseHeroAttribute.getStrength(),3);
        assertNotEquals(rogue.baseHeroAttribute.getDexterity(), 5);
        assertNotEquals(rogue.baseHeroAttribute.getIntelligence(), 2);

        assertEquals(warrior.baseHeroAttribute.getStrength(), 5);
        assertEquals(warrior.baseHeroAttribute.getDexterity(), 2);
        assertEquals(warrior.baseHeroAttribute.getIntelligence(), 1);
        assertNotEquals(warrior.baseHeroAttribute.getStrength(),3);
        assertNotEquals(warrior.baseHeroAttribute.getDexterity(), 3);
        assertNotEquals(warrior.baseHeroAttribute.getIntelligence(), 3);
    }

    @Test
    void increaseLevelTest(){
        mage.levelUp();

        int expectedStrength_Mage = mage.baseHeroAttribute.getStrength()+1;
        int expectedDexterity_Mage = mage.baseHeroAttribute.getDexterity()+1;
        int expectedIntelligence_Mage = mage.baseHeroAttribute.getIntelligence()+5;
        int expectedLevel_Mage= 2;
        HeroAttribute actualHeroMarge = mage.getTotalHeroAttribute();
        int actualLevel_Mage= mage.getLevel();
        assertEquals(expectedStrength_Mage, actualHeroMarge.getStrength() );
        assertEquals(expectedDexterity_Mage, actualHeroMarge.getDexterity() );
        assertEquals(expectedIntelligence_Mage, actualHeroMarge.getIntelligence() );
        assertEquals(expectedLevel_Mage, actualLevel_Mage);


        ranger.levelUp();

        int expectedStrength_Ranger = ranger.baseHeroAttribute.getStrength()+1;
        int expectedDexterity_Ranger = ranger.baseHeroAttribute.getDexterity()+5;
        int expectedIntelligence_Ranger = ranger.baseHeroAttribute.getIntelligence()+1;
        int expectedLevel_Ranger= 2;
        HeroAttribute actualHeroRanger = ranger.getTotalHeroAttribute();
        int actualLevel_Ranger= ranger.getLevel();
        assertEquals(expectedStrength_Ranger, actualHeroRanger.getStrength() );
        assertEquals(expectedDexterity_Ranger, actualHeroRanger.getDexterity() );
        assertEquals(expectedIntelligence_Ranger, actualHeroRanger.getIntelligence() );
        assertEquals(expectedLevel_Ranger, actualLevel_Ranger);

        rogue.levelUp();

        int expectedStrength_Rogue = rogue.baseHeroAttribute.getStrength()+1;
        int expectedDexterity_Rogue = rogue.baseHeroAttribute.getDexterity()+4;
        int expectedIntelligence_Rogue = rogue.baseHeroAttribute.getIntelligence()+1;
        int expectedLevel_Rogue= 2;
        HeroAttribute actualHeroRogue = rogue.getTotalHeroAttribute();
        int actualLevel_Rogue= rogue.getLevel();
        assertEquals(expectedStrength_Rogue, actualHeroRogue.getStrength() );
        assertEquals(expectedDexterity_Rogue, actualHeroRogue.getDexterity() );
        assertEquals(expectedIntelligence_Rogue, actualHeroRogue.getIntelligence() );
        assertEquals(expectedLevel_Rogue, actualLevel_Rogue);

        warrior.levelUp();
        warrior.levelUp();
        int expectedStrength_Warrior = warrior.baseHeroAttribute.getStrength()+3+3;
        int expectedDexterity_Warrior = warrior.baseHeroAttribute.getDexterity()+2+2;
        int expectedIntelligence_Warrior = warrior.baseHeroAttribute.getIntelligence()+1+1;
        int expectedLevel_Warrior= 3;
        HeroAttribute actualHeroWarrior = warrior.getTotalHeroAttribute();
        int actualLevel_Warrior= warrior.getLevel();
        assertEquals(expectedStrength_Warrior, actualHeroWarrior.getStrength() );
        assertEquals(expectedDexterity_Warrior, actualHeroWarrior.getDexterity() );
        assertEquals(expectedIntelligence_Warrior, actualHeroWarrior.getIntelligence() );
        assertEquals(expectedLevel_Warrior, actualLevel_Warrior);

    }

    @Test
    void createWeaponTest(){
        Weapon test_axe = new Weapon("TestCommonAxe",1,WEAPON, AXES,2);
        assertEquals("TestCommonAxe",test_axe.getName());
        assertEquals(WEAPON,test_axe.getSlot());
        assertEquals(AXES,test_axe.getWeaponType());
        assertEquals(2,test_axe.getWeaponDamage());
    }

    @Test
    void createArmorTest(){
        Armor test_plateChest = new Armor("TestCommonPlateChest",1,BODY, PLATE, new HeroAttribute(1,1,0));
        assertEquals("TestCommonPlateChest",test_plateChest.getName());
        assertEquals(BODY,test_plateChest.getSlot());
        assertEquals(PLATE,test_plateChest.getArmorType());
        assertEquals(1,test_plateChest.getRequiredLevel());
        assertEquals(1,test_plateChest.getArmorAttribute().getStrength());
        assertEquals(1,test_plateChest.getArmorAttribute().getDexterity());
        assertEquals(0,test_plateChest.getArmorAttribute().getIntelligence());
    }



    @Test
    void validEquipWeapon() throws InvalidWeaponException, InvalidLevelException {
        Weapon test_staff = new Weapon("TestStaff",1, WEAPON, STAFFS,10);
        String expected=test_staff.getName();
        mage.equipWeapon(test_staff);
        String actual =mage.getEquipment().get(Slot.WEAPON).getName();

        assertEquals(expected, actual);}

    @Test
    void invalidEquipWeaponType()  {
        Weapon test_sword = new Weapon("TestSword", 1, WEAPON, WeaponType.SWORDS, 10);
        Exception weaponException = assertThrows(InvalidWeaponException.class, () -> mage.equipWeapon(test_sword));
        String actual = weaponException.getMessage();    String expected = "\""+ mage.getHeroClass()+ "\" cannot equip this weapon type: \""+ test_sword.getWeaponType() + "\"";
        assertEquals(expected, actual);
    }
    @Test
    void invalidEquipArmorType() {
        Armor test_PlateChest = new Armor("TestPlateChest", 1, BODY, PLATE, new HeroAttribute(1,0,0));
        Exception armorException = assertThrows(InvalidArmorException.class, () -> mage.equipArmor(test_PlateChest));
        String actual = armorException.getMessage();    String expected ="\""+ mage.getHeroClass()+ "\" cannot equip this armor type: \"" + test_PlateChest.getArmorType() + "\"";
        assertEquals(expected, actual);
    }

    @Test
    void invalidLevelEquipWeapon() {
        Weapon test_staff = new Weapon("TestStaff",2, WEAPON, STAFFS,10);
        Exception levelException = assertThrows(InvalidLevelException.class, () -> mage.equipWeapon(test_staff));
        String actual = levelException.getMessage();    String expected = "\""+ mage.getHeroClass()+ "\" cannot equip any items of Armor or weapons type. Because the hero´s level is \" "+ mage.getLevel()+ " + \"and it does not reach the requirement of the level: \" " + test_staff.getRequiredLevel() + "\"";
        assertNotEquals(test_staff.getRequiredLevel(),mage.getLevel());
        assertEquals(expected, actual);
    }
    @Test
    void invalidLevelEquipArmor() {
        Armor test_PlateChest = new Armor("TestPlateChest", 3, BODY, PLATE, new HeroAttribute(1,0,0));
        Exception levelException = assertThrows(InvalidLevelException.class, () -> warrior.equipArmor(test_PlateChest));
        String actual = levelException.getMessage();    String expected = "\""+ warrior.getHeroClass()+ "\" cannot equip any items of Armor or weapons type. Because the hero´s level is \" "+ warrior.getLevel()+ " + \"and it does not reach the requirement of the level: \" " + test_PlateChest.getRequiredLevel() + "\"";
        assertNotEquals(test_PlateChest.getRequiredLevel(),warrior.getLevel());
        assertEquals(expected, actual);}


    @Test
    void totalAttributeTest()  {
        int expected_noEquipment=1+1+8;
        int actual_mage_total=mage.calTotalAttribute();
        assertEquals(expected_noEquipment, actual_mage_total);

        /*
        Armor test_PlateChest = new Armor("TestPlateChest", 1, BODY, PLATE, new HeroAttribute(1,0,0));
        int expected_oneArmor=5+2+1 +1+0+0;
        warrior.equipArmor(test_PlateChest);
        int actual_warrior_total=warrior.calTotalAttribute();
        assertEquals(expected_oneArmor, actual_warrior_total);*/
    }

    @Test
    void damageTest() throws InvalidWeaponException, InvalidLevelException, InvalidArmorException {
        double expected_noWeapon= 1*(1 + (5 / 100));
        double actual_noWeapon=warrior.damage();
        assertEquals(expected_noWeapon, actual_noWeapon);

        Weapon test_axe = new Weapon("TestCommonAxe",1,WEAPON, AXES,2);
        warrior.equipWeapon(test_axe);
        double expected_equipAxe=2*(1 + (5 / 100));
        double actual_equipAxe=warrior.damage();
        assertEquals(expected_equipAxe, actual_equipAxe);

        Weapon test_axe2 = new Weapon("TestCommonAxe2",1,WEAPON, AXES,2);
        warrior.equipWeapon(test_axe2);
        double expected_equipAxe2=2*(1 + (5 / 100));
        double actual_equipAxe2=warrior.damage();
        assertEquals(expected_equipAxe2, actual_equipAxe2);

        Armor test_PlateChest = new Armor("TestPlateChest", 1, BODY, PLATE, new HeroAttribute(1,0,0));
        warrior.equipArmor(test_PlateChest);
        double expected_equipWeapon_Armor=2*(1 + (5 / 100));
        double actual_equipWeapon_Armor=warrior.damage();
        assertEquals(expected_equipWeapon_Armor, actual_equipWeapon_Armor);
    }

    @Test
     void displayTest() throws InvalidWeaponException, InvalidLevelException {

        Weapon test_staff = new Weapon("TestStaff",1, WEAPON, STAFFS,10);
        mage.equipWeapon(test_staff);
        double expected_damage =10*(1+(8/100));
        assertEquals("Miwa",mage.getName());
        assertEquals(MAGE,mage.getHeroClass());
        assertEquals(1,mage.getLevel());
        assertEquals(1,mage.totalHeroAttribute.getStrength());
        assertEquals(1,mage.totalHeroAttribute.getDexterity());
        assertEquals(8,mage.totalHeroAttribute.getIntelligence());
        assertEquals(expected_damage,mage.damage());

        assertEquals("Reiko",ranger.getName());
        assertEquals(RANGER,ranger.getHeroClass());
        assertEquals(1,ranger.getLevel());
        assertEquals(1,ranger.totalHeroAttribute.getStrength());
        assertEquals(7,ranger.totalHeroAttribute.getDexterity());
        assertEquals(1,ranger.totalHeroAttribute.getIntelligence());
        assertEquals(1.0,ranger.damage());

        assertEquals("Mika",rogue.getName());
        assertEquals(ROGUE,rogue.getHeroClass());
        assertEquals(1,rogue.getLevel());
        assertEquals(2,rogue.totalHeroAttribute.getStrength());
        assertEquals(6,rogue.totalHeroAttribute.getDexterity());
        assertEquals(1,rogue.totalHeroAttribute.getIntelligence());
        assertEquals(1.0,rogue.damage());

        warrior.levelUp();
        assertEquals("Chiyo",warrior.getName());
        assertEquals(WARRIOR,warrior.getHeroClass());
        assertEquals(2,warrior.getLevel());
        assertEquals(5+3,warrior.totalHeroAttribute.getStrength());
        assertEquals(2+2,warrior.totalHeroAttribute.getDexterity());
        assertEquals(1+1,warrior.totalHeroAttribute.getIntelligence());
        assertEquals(1.0,warrior.damage());



    }
}