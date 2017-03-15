package woz.model.character;

import woz.model.Inventory;
import woz.model.item.BaseItem;
import woz.model.item.Food;
import woz.model.item.Potion;

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

    public void useItem(String itemName) {
            if (itemName.length() == 0) {
                System.out.println("Use what?");
                return;
            }

            BaseItem item = this.getInventory().getItem(itemName);
            if (item == null) {
                System.out.println("You don't have this item!");
                return;
            }

            int increase;

            switch (item.getType()) {
                case BaseItem.DEFENSE:
                    System.out.println("This is a defense item");
                    break;
                case BaseItem.FOOD:
                    increase = ((Food) item).getLifeIncrease();
                    this.increaseHp(increase);
                    this.getInventory().removeItem(item);
                    break;
                case BaseItem.POTION:
                    increase = ((Potion) item).getLifeIncrease();
                    this.increaseHp(increase);
                    break;
                case BaseItem.WEAPON:
                    System.out.println("This is a weapon item");
                    break;
                default:
                    System.out.println("Item type not recognized");
                    break;
            }
    }
}
