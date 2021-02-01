package com.company.items.weapon;

import com.company.items.ItemsType;
import com.company.utils.Stats;

//subclass of a weapon and a grandchild of items
public class Magic extends Weapon {
    //constructor sets the basic damage of the weapon as well as the name, and the type of the weapon
    public Magic(String name) {
        super(name, ItemsType.Magic);
        damage = 25;
    }

    //update the damage of the weapon when equipped
    @Override
    public void updateDamageWhenEquipped(Stats stat) {
        damage = damage + (3*stat.getIntelligence());
    }

    //set the damage back to normal when unequipped
    @Override
    public void updateDamageWhenUnEquipped(Stats stat) {
        damage = damage - (3*stat.getIntelligence());
    }

    //update the damage when the level is updated
    @Override
    public void scaleUp() {
        damage = damage + (2 * level);
    }
}
