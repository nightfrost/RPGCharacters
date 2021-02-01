package com.company.equipment;

import com.company.items.ItemsType;
import com.company.utils.Inventory;
import com.company.items.Item;

public interface Equipable {

    boolean equip(Item item, Inventory inventory);
    void unequip(ItemsType itemsType, Inventory inventory);
}
