package model.equipment;

import model.heros.HeroAttribute;

public class Armor extends Item {

    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    public Armor(String name, int requiredLevel,  Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public Armor() {
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    @Override
    public String toString() {
        return "Armor{name='" + getName() +
                "', slot=" + getSlot() +
                ", type=" + armorType +
                ", attributes=" + armorAttribute + "}";
    }

}
