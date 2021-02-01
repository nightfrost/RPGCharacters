package com.company.items;

import com.company.utils.BodyPart;

//abstract super class that is responsible for items
public abstract class Item {

    protected String name;
    protected int level;
    protected ItemsType itemsType;
    protected BodyPart bodyPart;

    public Item(String name, int level, ItemsType itemsType, BodyPart bodyPart) {
        this.name = name;
        this.level = level;
        this.itemsType = itemsType;
        this.bodyPart = bodyPart;
    }

    //set the level of an item, passing level in the parameter
    public abstract void setLevel(int level);

    //update the stats of an item
    public abstract void scaleUp();

    //print the details of a chosen item
    public abstract void printDetails();

    //get the name of an item
    public String getName() {
        return name;
    }

    //get the level of an item
    public int getLevel() {
        return level;
    }

    //get the type of an item (Leather, cloth, plate)
    public ItemsType getItemsType() {
        return itemsType;
    }
}
