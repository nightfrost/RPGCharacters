package com.company.heros;

import com.company.utils.Stats;

//a hero subclass
public class Mage extends Hero {

    // the added stats upon leveling up
    protected final Stats INCREMENTAL_STATS = new Stats(15, 1, 2, 5);

    //constructor that sets up the starting stats
    public Mage(String name) {
        super(name, new Stats(100, 2, 3, 10));
    }

    @Override
    public void levelUp(int increasedLvls) {
        stats.setHealth(stats.getHealth() + (INCREMENTAL_STATS.getHealth() * increasedLvls));
        stats.setStrength(stats.getStrength() + (INCREMENTAL_STATS.getStrength() * increasedLvls));
        stats.setDexterity(stats.getDexterity() + (INCREMENTAL_STATS.getDexterity() * increasedLvls));
        stats.setIntelligence(stats.getIntelligence() + (INCREMENTAL_STATS.getIntelligence() * increasedLvls));
    }

}
