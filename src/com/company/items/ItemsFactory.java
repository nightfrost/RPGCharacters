package com.company.items;

import com.company.items.armor.ClothArmor;
import com.company.items.armor.LeatherArmor;
import com.company.items.armor.PlateArmor;
import com.company.items.weapon.Magic;
import com.company.items.weapon.Melee;
import com.company.items.weapon.Ranged;
import com.company.utils.BodyPart;

public class ItemsFactory {

    public Item createItem(ItemsType type, String name, BodyPart bodyPart) {
        return switch (type) {
            case Cloth -> new ClothArmor(name, bodyPart);
            case Leather -> new LeatherArmor(name, bodyPart);
            case Plate -> new PlateArmor(name, bodyPart);
            case Melee -> new Melee(name);
            case Ranged -> new Ranged(name);
            case Magic -> new Magic(name);
            default -> null;
        };

    }
}
