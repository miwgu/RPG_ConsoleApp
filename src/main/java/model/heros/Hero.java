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
   // public double damage;



    public Hero(int strength, int dexterity, int intelligence, String name, HeroClass heroClass) {

        this.heroClass= heroClass;
        this.name = name;
        this.level = 1;
        baseHeroAttribute = new HeroAttribute(strength, dexterity, intelligence);
        totalHeroAttribute = new HeroAttribute(strength, dexterity, intelligence);

        this.equipment= new HashMap<>();
        this.validWeaponTypes = new ArrayList<WeaponType>();
        this.validArmorTypes = new ArrayList<ArmorType>();

        damage();
    }
/*
    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

 */



    public Map<Slot, Item> getEquipment() {
        //Map<Slot,Item> equipment = new HashMap<Slot,Item>();
        equipment.put(Slot.WEAPON,null);
        equipment.put(Slot.HEAD,null);
        equipment.put(Slot.BODY,null);
        equipment.put(Slot.LEGS,null);
        return equipment;
    }




/*

    public HeroAttribute getHeroAttribute(String name) {

        return switch (name) {
                    case "Mage" -> new HeroAttribute(1, 1, 8);

                    case "Ranger" -> new HeroAttribute(1, 7, 1);

                    case "Rogue" -> new HeroAttribute(2, 6, 1);

                    case "Warrior" -> new HeroAttribute(5, 2, 1);

                    default->
                        throw new IllegalStateException("Invalid name: " + name);

                };
    }

 */

/*
    public HeroAttribute levelUp (String name) {
        this.level++;

        return switch (name) {
            case "Mage" -> heroAttribute.heroAttributeUpdated(1, 1, 5);

            case "Ranger" -> heroAttribute.heroAttributeUpdated(1, 5, 1);

            case "Rogue"-> heroAttribute.heroAttributeUpdated(1, 4, 1);

            case "Warrior"-> heroAttribute.heroAttributeUpdated(3, 2, 1);

                default -> throw new IllegalStateException("Invalid name: " + name);

        };
    }
*/

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setValidWeaponTypes(List<WeaponType> validWeaponTypes) {
        this.validWeaponTypes = validWeaponTypes;
    }

    public void setValidArmorTypes(List<ArmorType> validArmorTypes) {
        this.validArmorTypes = validArmorTypes;
    }

    public void setBaseHeroAttribute(HeroAttribute baseHeroAttribute) {
        this.baseHeroAttribute = baseHeroAttribute;
    }

    public void setTotalHeroAttribute(HeroAttribute totalHeroAttribute) {
        this.totalHeroAttribute = totalHeroAttribute;
    }

    public void setEquipment(Map<Slot, Item> equipment) {
        this.equipment = equipment;
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public HeroAttribute getBaseHeroAttribute() {
        return baseHeroAttribute;
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

  /*  public List<ArmorType> getValidWeaponTypes() {
        List <WeaponType> validWeaponType= new ArrayList<WeaponType>();
        validWeaponType.add(WeaponType.AXES);
        validWeaponType.add(WeaponType.BOWS);
        validWeaponType.add(WeaponType.DAGGERS);
        validWeaponType.add(WeaponType.HAMMERS);
        validWeaponType.add(WeaponType.STAFFS);
        validWeaponType.add(WeaponType.WANDS);

        return validWeaponTypes;
    }

   */



    public List<ArmorType> getValidArmorTypes() {
        List <ArmorType> validArmorType= new ArrayList<ArmorType>();
        validArmorType.add(ArmorType.CLOTH);
        validArmorType.add(ArmorType.LEATHER);
        validArmorType.add(ArmorType.MAIL);
        validArmorType.add(ArmorType.PLATE);

        return validArmorTypes;
    }


    public abstract HeroAttribute levelUp();


     public int gainLevel() {
       return this.level++;
     };

    /*public double getDamage() {
        return damage;
    }*/

    //public abstract void equip(Slot slot,Weapon weapon);
    //public abstract void equip(Slot slot,Armor armor);


    /*
    public boolean equipArmour(Armor armor) throws InvalidArmorException, InvalidLevelException {
        boolean underRequiredLevel = this.level < armor.getRequiredLevel();
        boolean invalidArmourType = !validArmorTypes.contains(armor.getArmorType());


        if (invalidArmourType){
            throw new InvalidArmourException(heroClass.toString(), armor.getArmorType().toString());
        }else if (underRequiredLevel) {
            throw new InvalidLevelException(this.getLevel(), armor.getRequiredLevel());
        }


        equipment.put(armor.getSlot(), armor);

        return true;
    }


     */
/*
    public boolean equipWeapon(Weapon weapon) throws InvalidArmorException, InvalidLevelException {
        boolean underRequiredLevel = this.level < weapon.getRequiredLevel();
        // boolean invalidArmourType = Arrays.stream(validArmorTypes).noneMatch( type-> type.equals(armor.getArmorType());
        boolean invalidArmourType = !validWeaponTypes.contains(weapon.getWeaponType());


        if (invalidArmourType){
            throw new InvalidArmourException(heroClass.toString(), armor.getArmorType().toString());
        }else if (underRequiredLevel) {
            throw new InvalidLevelException(this.getLevel(), armor.getRequiredLevel());
        }


        equipment.put(weapon.getSlot(), weapon);

        return true;
    }

 */



    public boolean equipWeapon(Slot slot, Weapon weapon) throws InvalidWeaponException, InvalidLevelException {

        boolean underRequiredLevel=this.level < weapon.getRequiredLevel();
        boolean invalidArmourType = !validWeaponTypes.contains(weapon.getWeaponType());

        if (invalidArmourType){
            throw new InvalidWeaponException(heroClass.toString(), weapon.getWeaponType().toString());
        }else if (underRequiredLevel) {
            throw new InvalidLevelException(heroClass.toString(),this.getLevel(), weapon.getRequiredLevel());
        }

        else {
            equipment.put(slot, weapon);
            setEquipment(equipment);
            return true;
        }

    }


    public boolean equipArmor(Slot slot, Armor armor) throws InvalidArmorException, InvalidLevelException{

        boolean underRequiredLevel=this.level < armor.getRequiredLevel();
        boolean invalidArmourType = !validArmorTypes.contains(armor.getArmorType());

        if (invalidArmourType){
            throw new InvalidArmorException(heroClass.toString(), armor.getArmorType().toString());
        }else if (underRequiredLevel) {
            throw new InvalidLevelException(heroClass.toString(),this.getLevel(), armor.getRequiredLevel());
        }

        else  {
            equipment.put(slot, armor);
            setEquipment(equipment);
            return true;
        }
    }


    public abstract double damage();


    public int calTotalAttribute () { // Total = LevelAttributes + (Sum of ArmorAttribute for all Armor in Equipment)
         this.totalHeroAttribute = new HeroAttribute(0,0,0);
         int sum_totalLevelAttributes=totalHeroAttribute.totalLevelAttributes(new HeroAttribute(baseHeroAttribute.getDexterity(), baseHeroAttribute.getStrength(), baseHeroAttribute.getIntelligence()));

         // need to add Sum of ArmorAttribute for all Armor in Equipment
        final int[] armorAttribute = {0};
        this.equipment.forEach((slot, item) -> {
            if (item == null) {
                if(slot== Slot.WEAPON){
                    return;// Not ARMOR (HEAD,LEGS,BODY) The rest of the code won't be executed
                }
                return;
            }
            Armor armor = (Armor) item;
            armorAttribute[0] = armor.getArmorAttribute().getTotalAttributes();
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

