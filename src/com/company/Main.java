package com.company;

import com.company.heros.Hero;
import com.company.heros.HeroFactory;
import com.company.heros.HeroTypes;
import com.company.items.Item;
import com.company.items.ItemsFactory;
import com.company.items.ItemsType;
import com.company.utils.BodyPart;

public class Main {

    public static void main(String[] args) {
        // creating three armors, one of each.
        Item cloth = new ItemsFactory().createItem(ItemsType.Cloth, "Robe of the Grand Wizard", BodyPart.Torso);
        Item plate = new ItemsFactory().createItem(ItemsType.Plate, "Ringhelm of Death", BodyPart.Head);
        Item leather = new ItemsFactory().createItem(ItemsType.Leather, "Snakeskin leggings", BodyPart.Legs);
        Item cloth2 = new ItemsFactory().createItem(ItemsType.Cloth, "Robe of the Grand Wizard2", BodyPart.Head);

        // creating three weapons, one of each.
        Item ranged = new ItemsFactory().createItem(ItemsType.Ranged, "Bow of death", BodyPart.Hand);
        Item melee = new ItemsFactory().createItem(ItemsType.Melee, "Blade of torment", BodyPart.Hand);
        Item magic = new ItemsFactory().createItem(ItemsType.Magic, "Wizards Staff", BodyPart.Hand);

        // creating three characters, one of each.
        Hero mage = new HeroFactory().createHero(HeroTypes.Mage, "Gandalf");
        Hero warrior = new HeroFactory().createHero(HeroTypes.Warrior, "Aragorn");
        Hero ranger = new HeroFactory().createHero(HeroTypes.Ranger, "Legolas");

        System.out.println("Print heroes before and after gaining experience");
        mage.printDetails();
        mage.gainXp(500);
        mage.printDetails();
        System.out.println("########################################");
        warrior.printDetails();
        warrior.gainXp(222);
        warrior.printDetails();
        System.out.println("########################################");
        ranger.printDetails();
        ranger.gainXp(340);
        ranger.printDetails();
        System.out.println("########################################");


        System.out.println("Printing Weapons before and after level change");
        magic.printDetails();
        magic.setLevel(2);
        magic.printDetails();
        System.out.println("########################################");
        melee.printDetails();
        melee.setLevel(3);
        melee.printDetails();
        System.out.println("########################################");
        ranged.printDetails();
        ranged.setLevel(4);
        ranged.printDetails();
        System.out.println("########################################");

        System.out.println("Printing armor before and after level change");
        cloth.printDetails();
        cloth.setLevel(2);
        cloth.printDetails();
        System.out.println("########################################");
        plate.printDetails();
        plate.setLevel(3);
        plate.printDetails();
        System.out.println("########################################");
        leather.printDetails();
        leather.setLevel(4);
        leather.printDetails();
        System.out.println("########################################");

        System.out.println("Printing mage before and after equipping item.");
        System.out.println("Nothing equipped yet");
        mage.printDetails();

        System.out.println("Info with cloth Level 2 on torso");
        mage.equip(cloth);
        mage.printDetails();

        System.out.println("Equipping more gear");
        mage.printDetails();
        mage.equip(plate);
        mage.equip(magic);
        mage.equip(leather);
        mage.printDetails();

        System.out.println("Replacing a cloth with another cloth");
        mage.equip(cloth2);
        mage.printDetails();

        System.out.println("attacking details");
        mage.attack();

    }
}
