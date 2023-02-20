## -Assigment 1_Java -Build a console application in Java-

Create a Maven application in Java

## -requirement-

• Install at least IntelliJ Ultimate with JDK 17

• Use plain Java to create a console application
```
 -Various hero classes having attributes which increase at different rates as the character gains levels.
 -Equipment, such as armor and weapons, that characters can equip. The equipped items will alter the power of 
  the hero, causing it to deal more damage and be able to survive longer. Certain heroes can equip certain item 
  types.
 -Custom exceptions. There are two custom exceptions you are required to write
 -Testing of the main functionality
```


## Description
### Hero Class
1) Overview

In the game there are currently four classes that a hero can be:
``` 
• Mage • Ranger • Rogue • Warrior
```
Each hero has the following shared fields:
```
• Name
• Level - all heroes start at level 1
• LevelAttribtues - total from all levels
• Equipment - holds currently equipped items
• ValidWeaponTypes – a list of weapon types a hero can equip based on their subclass
• ValidArmorTypes - a list of armor types a hero can equip based on their subclass
```
Heroes have the following public facing methods:
```
• Constructor – each hero is created by passing just a name.
• LevelUp – increases the level of a character by 1 and increases their LevelAttributes
• Equip – two variants, for equipping armor and weapons
• Damage – damage is calculated on the fly and not stored
• TotalAttributes – calculated on the fly and not stored
• Display – details of Hero to be displayed
```

2) Hero attributes

```
• Strength – determines the physical strength of the character.
• Dexterity – determines the characters ability to attack with speed and nimbleness.
• Intelligence – determines the characters affinity with magic.
```
3) Levelling attributes

```
There should be a base abstract Hero class to encapsulate all the shared functionality (fields and methods)
Each sub class will start at different attributes and increase at different rates when levelling up.
```

###  Items and equipment
1) Overview
   
   Heroes can equip various items. The two types of items are: Weapon and Armor.
   
   There should be a parent Item abstract class which is inherited by the above-mentioned types.

   They cannot equip the item if a hero is below the RequiredLevel,

```
• Name
• RequiredLevel
• Slot
```
   Each item is equipped in a specific Slot.

```
• Weapon
• Head
• Body
• Legs
```

2)  Weapons
    Encapsulate these types in a WeaponType enumerator and compose that into the weapon class. In addition
    to a weapon type, weapons deal damage. This is represented as a WeaponDamage field.
```
• Axes
• Bows
• Daggers
• Hammers
• Staffs
• Swords
• Wands
```

3)  Armor
    Encapsulate these types in a ArmorType enumerator and compose that into the armor class. In addition to
    an armor type, armor has attributes which provide bonuses to a heroes attributes when equipped. This field is of type
    HeroAttribute and should be called ArmorAttribute.
```
• Cloth
• Leather
• Mail
• Plate
```

4)  Equipment
    Recall, Heroes have equipment, which is a collection of items. The data structure for this should meet the requirement
    of: <Slot, Item> as a key value pair. When a new Hero is created, the equipment is initialized to have each slot as an
    entry with null values to represent empty slots. This should result in 4 entries with keys for each Slot and null values.
```
 InvalidWeapon for each Heros (Need to throw a custom InvalidWeaponException)
• Mages – Staff, Wand
• Rangers – Bow
• Rogues – Dagger, Sword
• Warriors – Axe, Hammer, Sword
```
```
InvalidArmor for each Heros (Need to throw a custom InvalidArmorException)
• Mages – Cloth
• Rangers – Leather, Mail
• Rogues – Leather, Mail
• Warriors – Mail, Plate
```


5) Calculations and display
   Recall, there are several methods dedicated to calculations for a Hero. These are: Total Attributes and Damage. A hero
   should also be able to Display themselves.
```
 Calculating total attributes
 
A heroes total attributes is simply the sum of their levelling attributes and all the armor attributes from their equipment. 
This is represented by the calculation:
* Total = LevelAttributes + (Sum of ArmorAttribute for all Armor in Equipment)
```

```
 Calculating a heroes damage
 
• Warrior – damage increased by total strength
• Mage – damage increased by total intelligence
• Ranger – damage increased by total dexterity
• Rogue – damage increased by total dexterity
A heroes total damage is equal to the equipped weapon damage increased by 1% for every point in their damaging 
attribute. It can be represented by the formula:
* Hero damage = WeaponDamage * (1 + DamagingAttribute/100)

```

```
 Hero display
 A hero has a public method which returns a string to display their state. 
 
• Name
• Class
• Level
• Total strength
• Total dexterity
• Total intelligence
• Damage
A good option for this is to use a string builder.
```

### Unit Testing

Unit testing is to verify the behavior of Heroes. This is how the assignment is “run”. No code needs to be in a main
method, only a test suite needs to be run. The tests should cover all the public facing methods of the Heroes as well as
any functionality used in those processes.

