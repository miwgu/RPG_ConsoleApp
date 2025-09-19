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

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
        return "[str=" + strength + ", dex=" + dexterity + ", int=" + intelligence + "]";
    }

}
