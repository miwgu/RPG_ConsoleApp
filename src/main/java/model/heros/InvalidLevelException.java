package model.heros;

public class InvalidLevelException extends Exception {

    public InvalidLevelException (String heroClass, int level, int requiredLevel ) {
        super ("\""+ heroClass+ "\" cannot equip any items of Armor or weapons type. Because the hero´s level is \" "+ level+ " + \"and it does not reach the requirement of the level: \" " + requiredLevel + "\"");
    }
}


