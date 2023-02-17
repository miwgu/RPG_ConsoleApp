package model;

import model.heros.HeroAttribute;
import model.heros.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {


    @Test
    void getHeroAttributeTest() {
        Mage ma = new Mage("m");
        HeroAttribute m = new HeroAttribute(1, 1, 8);
        assertEquals(m.getStrength(), 1);
        assertEquals(m.getDexterity(), 1);
        assertEquals(m.getIntelligence(), 8);
        assertNotEquals(m.getStrength(),2);
        assertNotEquals(m.getDexterity(), 2);
        assertNotEquals(m.getIntelligence(), 3);

        //assertEquals(new HeroAttribute(1, 1, 8), );

    }
}