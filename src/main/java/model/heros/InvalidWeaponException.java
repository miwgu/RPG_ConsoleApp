package model.heros;

public class InvalidWeaponException extends Exception {

    public InvalidWeaponException (String heroClass, String weaponType ) {
        super ("\""+ heroClass+ "\" cannot equip this weapon type: \"" + weaponType + "\"");
    }
}

