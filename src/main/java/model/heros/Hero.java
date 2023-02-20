package model.heros;

import model.equipment.*;

import java.util.*;

public abstract class Hero {

    private HeroClass heroClass;
    private String name;
    public int level;
    public List<WeaponType> validWeaponTypes;
    public List<ArmorType>  validArmorTypes;
    public HeroAttribute baseHeroAttribute; // Each hero has level 1 attributes
    public HeroAttribute totalHeroAttribute;
    private   Map<Slot, Item> equipment;




    public Hero(int strength, int dexterity, int intelligence, String name, HeroClass heroClass) {

        this.heroClass= heroClass;
        this.name = name;
        this.level = 1;
        baseHeroAttribute = new HeroAttribute(strength, dexterity, intelligence);
        totalHeroAttribute = new HeroAttribute(strength, dexterity, intelligence);

        this.equipment= getInitialEquipment();
        this.validWeaponTypes = new ArrayList<WeaponType>();
        this.validArmorTypes = new ArrayList<ArmorType>();

        damage();
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }


    public Map<Slot, Item> getInitialEquipment() {
        Map<Slot,Item> createEquipment = new HashMap<Slot,Item>();
        createEquipment.put(Slot.WEAPON,null);
        createEquipment.put(Slot.HEAD,null);
        createEquipment.put(Slot.BODY,null);
        createEquipment.put(Slot.LEGS,null);
        return createEquipment;
    }

    public void setEquipment(Map<Slot, Item> equipment) {
        this.equipment = equipment;
    }

    public HeroAttribute getTotalHeroAttribute() {
        return totalHeroAttribute;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }


    public abstract HeroAttribute levelUp();


     public int gainLevel() {
       return this.level++;
     };


    public boolean equipWeapon(Weapon weapon) throws InvalidWeaponException, InvalidLevelException {

        boolean underRequiredLevel=this.level < weapon.getRequiredLevel();
        boolean invalidArmourType = !validWeaponTypes.contains(weapon.getWeaponType());

        if (invalidArmourType){
            throw new InvalidWeaponException(heroClass.toString(), weapon.getWeaponType().toString());
        }else if (underRequiredLevel) {
            throw new InvalidLevelException(heroClass.toString(),this.getLevel(), weapon.getRequiredLevel());
        }

        else {
            equipment.put(weapon.getSlot(), weapon);
            setEquipment(this.equipment);
            return true;
        }

    }


    public boolean equipArmor(Armor armor) throws InvalidArmorException, InvalidLevelException{

        boolean underRequiredLevel=this.level < armor.getRequiredLevel();
        boolean invalidArmourType = !validArmorTypes.contains(armor.getArmorType());

        if (invalidArmourType){
            throw new InvalidArmorException(heroClass.toString(), armor.getArmorType().toString());
        }else if (underRequiredLevel) {
            throw new InvalidLevelException(heroClass.toString(),this.getLevel(), armor.getRequiredLevel());
        }

        else  {
            equipment.put(armor.getSlot(), armor);
            setEquipment(this.equipment);
            return true;
        }
    }


    public abstract double damage();


    public int calTotalAttribute () { // Total = LevelAttributes + (Sum of ArmorAttribute for all Armor in Equipment)
         this.totalHeroAttribute = new HeroAttribute(0,0,0);
         int sum_totalLevelAttributes=this.totalHeroAttribute.totalLevelAttributes(new HeroAttribute(baseHeroAttribute.getDexterity(), baseHeroAttribute.getStrength(), baseHeroAttribute.getIntelligence()));

         // need to add Sum of ArmorAttribute for all Armor in Equipment
        final int[] armorAttribute = {0};
        this.equipment.forEach((slot, item) -> {
            Item i = new Armor();

            Armor armor = (Armor) i;
            //Armor armor = (Armor) item;
            //Weapon weapon = (Weapon) item;
            //Item armor =(Item)item;
            //HeroAttribute attribute = (Armor) item.getArmorAttribute();
            //HeroAttribute itemattribute = item.getArmorAttribute();
            /*if (item == null) {
                if(slot== Slot.WEAPON){
                    armorAttribute[0]=0;//return;// Not ARMOR (HEAD,LEGS,BODY) The rest of the code won't be executed
                }
                armorAttribute[0]=0;//return;
            }

             */
            if(slot== Slot.WEAPON || item == null){
                return;
            } ;

            armorAttribute[0]=armor.getArmorAttribute().getTotalAttributes();
        });

        return sum_totalLevelAttributes + armorAttribute[0];
    }

    public StringBuilder display() {
        StringBuilder sb = new StringBuilder();
        return sb.append("----------------------------------------\n")
                .append("Name: " + this.getName()+"\n")
                .append("Class: " + this.getHeroClass()+"\n")
                .append("Level:" + this.getLevel()+"\n")
                .append("Total strength:" + this.totalHeroAttribute.getStrength()+"\n")
                .append("Total dexterity:" + this.totalHeroAttribute.getDexterity()+ "\n")
                .append("Total intelligence:" + this.totalHeroAttribute.getIntelligence()+ "\n")
                .append("Damage:" + this.damage()+ "\n")
                .append("----------------------------------------\n");
    }


}

