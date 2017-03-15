package woz.model.character;

import woz.model.Inventory;
import woz.model.item.BaseItem;

public class Hero extends Character {
    private Inventory inventory;
    private Integer XP;

    public Hero(String name, Integer hp) {
        super(name, hp, 1);
        this.XP = 0;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Boolean addItemToInventory(BaseItem baseItem) {
        return this.inventory.addItem(baseItem);
    }

    public Boolean removeItemFromInventory(BaseItem baseItem) {
        return this.inventory.removeItem(baseItem);
    }

    public Integer getXP() {
        return XP;
    }

    public void setXP(Integer XP) {
        this.XP = XP;
    }

    public void showInventory() {
        this.getInventory().show();
    }

    public BaseItem searchInventory(String name) {
        return this.inventory.getItem(name);
    }
}
