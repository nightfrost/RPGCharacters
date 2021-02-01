package com.company.equipment;

import com.company.items.ItemsType;
import com.company.utils.Inventory;
import com.company.items.Item;


public class EquipArmor implements Equipable {
    @Override
    public boolean equip(Item item, Inventory inventory) {
        return inventory.addItem(item.getItemsType(),item);

    }

    @Override
    public void unequip(ItemsType itemsType, Inventory inventory) {
        inventory.removeItem(itemsType);
    }
}
