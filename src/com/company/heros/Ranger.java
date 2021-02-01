package com.company.heros;

import com.company.utils.Stats;

//a hero subclass
public class Ranger extends Hero{

    // the added stats upon leveling up
    protected final Stats INCREMENTAL_STATS = new Stats(20,2,5,1);

    //constructor that sets up the starting stats
    public Ranger(String name) {
        super(name, new Stats(120, 5, 10, 2));
    }

    @Override
    public void levelUp(int increasedLvls) {
        stats.setHealth(stats.getHealth() + (INCREMENTAL_STATS.getHealth() * increasedLvls));
        stats.setStrength(stats.getStrength() + (INCREMENTAL_STATS.getStrength() * increasedLvls));
        stats.setDexterity(stats.getDexterity() + (INCREMENTAL_STATS.getDexterity() * increasedLvls));
        stats.setIntelligence(stats.getIntelligence() + (INCREMENTAL_STATS.getIntelligence() * increasedLvls));

    }


}
