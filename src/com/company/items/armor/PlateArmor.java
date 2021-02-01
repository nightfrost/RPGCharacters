package com.company.items.armor;

import com.company.items.ItemsType;
import com.company.utils.BodyPart;
import com.company.utils.Stats;

//subclass of a Armor and a grandchild of items
public class PlateArmor extends Armor {
    // the values of the incremental stats
    private final Stats scaleStats = new Stats(12, 2, 1, 0);

    //constructor sets the basic stats of the PlateArmor as well as the name, the type of the armor and the BodyPart
    public PlateArmor(String name, BodyPart slot) {
        super(name, ItemsType.Plate,new Stats(30, 3, 1, 0),slot);
    }

    //update the stats of an armor according to the level
    @Override
    public void scaleUp() {
        baseStats.setHealth(baseStats.getHealth() + (scaleStats.getHealth() * level));
        baseStats.setStrength(baseStats.getStrength() + (scaleStats.getStrength() * level));
        baseStats.setDexterity(baseStats.getDexterity() + (scaleStats.getDexterity() * level));
        baseStats.setIntelligence(baseStats.getIntelligence() + (scaleStats.getIntelligence() * level));
    }

}
