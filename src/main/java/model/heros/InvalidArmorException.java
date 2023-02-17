package model.heros;

public class InvalidArmorException extends Exception {

    public InvalidArmorException(String heroClass, String armourType ) {
        super ("\""+ heroClass+ "\" cannot equip this armour type \"" + armourType + "\"");
    }
}
