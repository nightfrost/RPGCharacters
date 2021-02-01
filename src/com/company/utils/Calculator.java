package com.company.utils;

//Class for calculating effectiveStats when equipping and un-equipping items
public class Calculator {

    public Stats getEffectiveStats(Stats itemStats, Stats heroStats) {
        return new Stats(
                (heroStats.getHealth() + itemStats.getHealth()),
                (heroStats.getStrength() + itemStats.getStrength()),
                (heroStats.getDexterity() + itemStats.getDexterity()),
                (heroStats.getIntelligence() + itemStats.getIntelligence())
        );
    }

    public Stats removeEffectiveStats(Stats itemStats, Stats heroStats) {
        return new Stats(
                (heroStats.getHealth() - itemStats.getHealth()),
                (heroStats.getStrength() - itemStats.getStrength()),
                (heroStats.getDexterity() - itemStats.getDexterity()),
                (heroStats.getIntelligence() - itemStats.getIntelligence())
        );
    }

}
