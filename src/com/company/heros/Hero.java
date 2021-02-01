package com.company.heros;

import com.company.equipment.EquipArmor;
import com.company.equipment.EquipWeapon;
import com.company.equipment.Equipable;
import com.company.items.ItemsType;
import com.company.items.armor.Armor;
import com.company.items.Item;
import com.company.items.weapon.Weapon;
import com.company.utils.*;

import java.util.HashMap;

//an abstract super class of the heros,
public abstract class Hero {
    protected Stats stats;
    protected Level level;
    private Inventory inventory;
    private final String name;
    private Equipable equipable;

    public Hero(String name, Stats stats) {
        this.stats = stats;
        this.name = name;
        level = new Level();
        inventory = new Inventory();
    }

    public void gainXp(int exp) {
        if (exp > 0)
            levelUp(level.gainXp(exp));
    }

    //An abstract class for updating stats when leveling up. Different for each hero
    public abstract void levelUp(int increasedLvls);

    //returns an instance of the inventory
    public HashMap<ItemsType, Item> getInventory() {
        return inventory.getInventory();
    }

    //prints the hero details along with the dealt damage, that is added when a weapon is equipped
    public void attack() {
        int damage = 0;
        PrintFormatter pf = new PrintFormatter();

        String first = "----------------------------------------";
        System.out.println(first);

        printDetails();

        // checks if the user already equipped a weapon, if yes, then it gets the damage of that weapon and print it as the dealt damage of the hero
        // otherwise, it prints it 0
        if (inventory.getInventory().containsKey(ItemsType.Weapon)) {
            damage = ((Weapon) inventory.getSpecificItem(ItemsType.Weapon)).getDamage();
            pf.formatText(first.length(), "# Attacking for: " + damage);
        } else
            pf.formatText(first.length(), "# Attacking for: "+damage);

        System.out.println(first);
    }

    public void equip(Item item) {
        //it checks if the to be equipped item is the same level or lower as the hero.
        // heroes cannot equip higher level items.
        if (item.getLevel() <= level.level) {
            // then if the item is one of the weapon sub classes
            // it calls an instance of the equipweapon
            if (item instanceof Weapon) {
                equipable = new EquipWeapon();

                // then if the item is successfully equipped, it updates the damage of the weapon by passing the stats of the hero
                if (equipable.equip(item, inventory)) {
                    ((Weapon) item).updateDamageWhenEquipped(stats);
                } else {
                    // otherwise, if the user already has another weapon equipped,
                    //then this weapon is unequipped and it try to call itself again passing the same weapon to be equipped
                    System.out.println("The item has been replaced!");
                    unequip(inventory.getSpecificItem(ItemsType.Weapon));
                    equip(item);
                }
            }

            //similarly to the weapon, it checks if the item is a sub class of armor
            if (item instanceof Armor) {
                // in that case it calls the equip armor class
                equipable = new EquipArmor();
                // if the armor is successfully equipped, it updates the stats of the hero,
                // by calling the geteffectivestats which calculates the new stats and set it as the current stats
                if (equipable.equip(item, inventory)) {
                    stats = new Calculator().getEffectiveStats(((Armor) item).getBaseStats(), stats);
                } else {
                    // otherwise, if the user already has the same type or armor equipped, meaning the user is trying to wear a plate armor, and s/he already wearing a plate armor
                    //then this already equipped plate is unequipped and it try to call itself again passing the same plate(new plate) to be equipped
                    System.out.println("The item has been replaced!");
                    unequip(inventory.getSpecificItem(item.getItemsType()));
                    equip(item);
                }
            }
        } else
            System.out.println("You cannot equip higher level items.");
    }


    public void unequip(Item item) {
        // check if the inventory bigger than 0, meaning it has items in it
        if (inventory.getInventory().size() > 0) {
            // checks if the item is a sub class of weapon
            if (item instanceof Weapon) {
                // checks if the inventory has an item of a weapon type
                if (inventory.getInventory().containsKey(ItemsType.Weapon)) {
                    equipable = new EquipWeapon();
                    //if yes then it will remove the item and remove the added damage
                    ((Weapon) item).updateDamageWhenUnEquipped(stats);
                    equipable.unequip(item.getItemsType(), inventory);
                }
            }

            // checks if the item is a sub class of weapon
            if (item instanceof Armor) {
                equipable = new EquipArmor();
                // checks if the inventory has an item of the type of the to be removed item
                if (inventory.getInventory().containsKey(item.getItemsType())) {
                    //if yes, it will then remove the added stats, and then remove the item
                    stats = new Calculator().removeEffectiveStats(((Armor) item).getBaseStats(), stats);
                    equipable.unequip(item.getItemsType(), inventory);
                }
            }
        }
    }
    //print the details of the hero
    public void printDetails() {
        String[] parts = this.getClass().getName().split("\\.");
        String className = parts[parts.length - 1];

        PrintFormatter pf = new PrintFormatter();

        String first = "############# Hero Details #############";
        System.out.println(first);
        pf.formatText(first.length(), "# " + className + " Details: " + name);
        pf.formatText(first.length(), "# HP: " + stats.getHealth());
        pf.formatText(first.length(), "# Str: " + stats.getStrength());
        pf.formatText(first.length(), "# Dex: " + stats.getDexterity());
        pf.formatText(first.length(), "# Int: " + stats.getIntelligence());
        pf.formatText(first.length(), "# Lvl: " + level.level);
        pf.formatText(first.length(), "# XP to next: " + (level.targetXp - level.xp));
        System.out.println("########################################");
    }
}
