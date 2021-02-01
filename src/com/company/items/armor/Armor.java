package com.company.items.armor;

import com.company.items.Item;
import com.company.items.ItemsType;
import com.company.utils.BodyPart;
import com.company.utils.PrintFormatter;
import com.company.utils.Stats;

//Armor a subclass of items
public abstract class Armor extends Item {

    //the stats of an armor
    protected Stats baseStats;
    // where it sets, torso,head and legs
    protected BodyPart slot;

    public Armor(String name, ItemsType itemsType, Stats baseStats, BodyPart slot) {
        super(name, 1, itemsType, slot);
        this.baseStats = baseStats;
        this.slot = slot;

    }

    @Override
    public abstract void scaleUp();

     //sets the percentage and then update the extra bonus, according which part of the body the items sits at
    private void percentageScaling() {
        switch (slot) {
            case Torso -> updateBonusStats(1);
            case Head -> updateBonusStats(0.8);
            case Legs -> updateBonusStats(0.6);
        }
    }

     //takes the percentage and updates the stats.
    private void updateBonusStats(double percentage) {
        baseStats.setHealth((int) (baseStats.getHealth() * percentage));
        baseStats.setStrength((int) (baseStats.getStrength() * percentage));
        baseStats.setDexterity((int) (baseStats.getDexterity() * percentage));
        baseStats.setIntelligence((int) (baseStats.getIntelligence() * percentage));
    }

     //sets the level of an item, then it scales it up, and then the bonus is set
    @Override
    public void setLevel(int level) {
        if (level > 1) {
            this.level = level;
            scaleUp();
            percentageScaling();
        }
    }

    //prints the details of specific armor
    public void printDetails() {
        PrintFormatter pf = new PrintFormatter();

        String first = "############# Armor Details #############";
        System.out.println(first);
        pf.formatText(first.length(), "# Items stats for: " + name);
        pf.formatText(first.length(), "# Armor Type: " + itemsType);
        pf.formatText(first.length(), "# Slot: " + slot);
        pf.formatText(first.length(), "# Armor level: " + level);

        if (baseStats.getHealth() > 0)
            pf.formatText(first.length(), "# Bonus HP: " + baseStats.getHealth());

        if (baseStats.getStrength() > 0)
            pf.formatText(first.length(), "# Bonus Str: " + baseStats.getStrength());

        if (baseStats.getDexterity() > 0)
            pf.formatText(first.length(), "# Bonus Dex: " + baseStats.getDexterity());

        if (baseStats.getIntelligence() > 0)
            pf.formatText(first.length(), "# Bonus Int: " + baseStats.getIntelligence());

        System.out.println("########################################");

    }

    //Return the stats of armor
    public Stats getBaseStats() {
        return baseStats;
    }
}
