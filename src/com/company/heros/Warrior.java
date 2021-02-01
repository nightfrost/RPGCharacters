package com.company.heros;

import com.company.utils.Stats;

//Hero subclass
public class Warrior extends Hero{

    // the added stats upon leveling up
    protected final Stats INCREMENTAL_STATS = new Stats(30,5,2,1);

    //constructor that sets up the starting stats
    public Warrior(String name) {
        super(name, new Stats(150, 10, 3, 1));
    }


    @Override
    public void levelUp(int increasedLvls) {
        stats.setHealth(stats.getHealth() + (INCREMENTAL_STATS.getHealth() * increasedLvls));
        stats.setStrength(stats.getStrength() + (INCREMENTAL_STATS.getStrength() * increasedLvls));
        stats.setDexterity(stats.getDexterity() + (INCREMENTAL_STATS.getDexterity() * increasedLvls));
        stats.setIntelligence(stats.getIntelligence() + (INCREMENTAL_STATS.getIntelligence() * increasedLvls));
    }


}
