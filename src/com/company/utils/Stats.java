package com.company.utils;

//Class that represents stats for armor and heroes
public class Stats {
    private int health;
    private int dexterity;
    private int strength;
    private int intelligence;

    public Stats(int health, int strength, int dexterity, int intelligence) {
        this.health = health;
        this.dexterity = dexterity;
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
