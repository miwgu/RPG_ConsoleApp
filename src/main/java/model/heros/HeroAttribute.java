package model.heros;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public HeroAttribute() {

    }

    // Need to think about how to use........
    public HeroAttribute heroAttributeUpdated(int addStrength, int addDexterity, int addIntelligence) {
        int strength = this.strength = getStrength() + addStrength;
        int dexterity = this.dexterity = getDexterity() + addDexterity;
        int intelligence = this.intelligence = getIntelligence() + addIntelligence;

        return new HeroAttribute(strength, dexterity, intelligence);
    }


/*    // Need to think about how to use.......
    public int LevelAttributes (int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;

        return this.strength+ this.dexterity+ this.intelligence;
    }

 */
/*
    public void levelAttributes(int strength, int dexterity, int intelligence) {
        this.setStrength(this.getStrength() + strength);
        this.setDexterity(this.getDexterity() + dexterity);
        this.setIntelligence(this.getIntelligence() + intelligence);
    }

 */
    public HeroAttribute levelAttributes(HeroAttribute heroAttribute) {
        this.strength += heroAttribute.getStrength();
        this.dexterity += heroAttribute.getDexterity();
        this.intelligence += heroAttribute.getIntelligence();
        return new HeroAttribute(this.strength,this.dexterity,this.intelligence);
    }

    public int totalLevelAttributes(HeroAttribute heroAttribute) {
        this.strength += heroAttribute.getStrength();
        this.dexterity += heroAttribute.getDexterity();
        this.intelligence += heroAttribute.getIntelligence();
        return this.strength+this.dexterity+this.intelligence;
    }


    public int getTotalAttributes() {
        return getStrength() + getDexterity() + getIntelligence();
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


}
