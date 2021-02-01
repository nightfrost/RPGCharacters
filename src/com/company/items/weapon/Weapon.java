package com.company.items.weapon;

import com.company.items.Item;
import com.company.items.ItemsType;
import com.company.utils.BodyPart;
import com.company.utils.PrintFormatter;
import com.company.utils.Stats;

//Weapon a subclass of items
public abstract class Weapon extends Item {

    // the weapon damage
    protected int damage;

    //weapons are created level 1 by default and set on hands
    public Weapon(String name, ItemsType itemsType) {
        super(name, 1, itemsType, BodyPart.Hand);
    }

    //update the damage of the weapon when equipped
    public abstract void updateDamageWhenEquipped(Stats stat);

    //update the damage of the weapon when unequipped
    public abstract void updateDamageWhenUnEquipped(Stats stat);

    //to set the level, and once the level is set, it updates the damage
    @Override
    public void setLevel(int level) {
        this.level = level;
        if (level > 1)
            scaleUp();
    }

    //update the damage accordingly to the increased levels
    @Override
    public abstract void scaleUp();

    //return the weapon damage
    public int getDamage() {
        return damage;
    }

    //print the details of specific weapon item
    public void printDetails() {
        PrintFormatter pf = new PrintFormatter();

        String first = "############# Weapon Details #############";
        System.out.println(first);
        pf.formatText(first.length(), "# Item stats for: " + this.getName());
        pf.formatText(first.length(), "# Weapon type: " + itemsType);
        pf.formatText(first.length(), "# Weapon level: " + this.getLevel());
        pf.formatText(first.length(), "# Damage: " + this.getDamage());
        System.out.println("########################################");

    }


}
