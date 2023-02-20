package model.equipment;

import model.heros.HeroAttribute;

public abstract class Item  {

     private String name;
     //public HeroAttribute armorAttribute;
     private final int requiredLevel;
     private Slot slot;

     public Item(String name, int requiredLevel,Slot slot) {
          this.name = name;
          this.requiredLevel = requiredLevel;
          this.slot = slot;
     }

     public Item() {
          requiredLevel = 0;
     };

     public String getName() {
          return name;
     }


     public int getRequiredLevel() {
          return requiredLevel;
     }

     public Slot getSlot() {
          return slot;
     }

}
