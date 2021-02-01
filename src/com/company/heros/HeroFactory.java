package com.company.heros;


public class HeroFactory {

    public Hero createHero(HeroTypes type, String name) {
        return switch (type) {
            case Mage -> new Mage(name);
            case Ranger -> new Ranger(name);
            case Warrior -> new Warrior(name);
            default -> null;
        };

    }



}
