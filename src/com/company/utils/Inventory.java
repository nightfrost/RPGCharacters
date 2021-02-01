package com.company.utils;

import com.company.items.Item;
import com.company.items.ItemsType;

import java.util.HashMap;

//Class for storing equipped items
public class Inventory {
    //Hashmap is used to make sure you can only equip one type of armor at a time.
    //It takes in ItemsType as key, and the item as the value.
    HashMap<ItemsType, Item> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    //add an item to the map
    public boolean addItem(ItemsType itemsType, Item item) {
        if (!inventory.containsKey(itemsType)&& inventory.size() <= 4) {
            inventory.put(itemsType, item);
            return true;
        } else
            return false;
    }

    //remove an item from the map
    public void removeItem(ItemsType itemsType) {
        inventory.remove(itemsType);
    }

    //get a specific item
    public Item getSpecificItem(ItemsType itemsType){
        return inventory.get(itemsType);
    }

    //get the whole map
    public HashMap<ItemsType, Item> getInventory() {
        return inventory;
    }
}
