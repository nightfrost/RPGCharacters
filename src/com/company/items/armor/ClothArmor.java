package com.company.items.armor;

import com.company.items.ItemsType;
import com.company.utils.BodyPart;
import com.company.utils.Stats;

//subclass of a Armor and a grandchild of items
public class ClothArmor extends Armor {

    // the values of the incremental stats
    private final Stats scaleStats = new Stats(5, 0, 1, 2);

     //constructor sets the basic stats of the ClothArmor as well as the name, the type of the armor and the BodyPart
    public ClothArmor(String name, BodyPart slot) {
        super(name, ItemsType.Cloth, new Stats(10, 0, 1, 3),slot);
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
