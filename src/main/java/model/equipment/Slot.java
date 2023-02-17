package model.equipment;

/*

Recall, Heroes have equipment, which is a collection of items. The data structure for this should meet the requirement
of: <Slot, Item> as a key value pair. When a new Hero is created, the equipment is initialized to have each slot as an
entry with null values to represent empty slots.
This should result in 4 entries with keys for each Slot and null values
*
* */
public enum Slot {

    WEAPON,
    HEAD,
    BODY,
    LEGS,
}
