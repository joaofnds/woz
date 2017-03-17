package woz.model.character;

import woz.model.Inventory;
import woz.model.item.*;

public class Hero extends Character {
    private Inventory inventory;
    private Integer XP;
    private Weapon weapon;
    private Defense shield;

    public Hero(String name, Integer hp) {
        super(name, hp, 1);
        this.XP = 0;
        this.inventory = new Inventory();
        this.weapon = null;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getXP() {
        return XP;
    }

    public void setXP(Integer XP) {
        this.XP = XP;
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

    public void showStatus() {
        System.out.printf("- %s:\n", this.getName());
        System.out.println("\tHP: " + this.getHp());
        System.out.println("\tXP: " + this.getXP());
        System.out.println("\tLevel: " + this.getLevel());

        if (this.hasWeapon())
            this.getWeapon().showStatus();
        else
            System.out.println("\tWeapon: None");

        if (this.hasShield())
            this.getShield().showStatus();
        else
            System.out.println("\tShield: None");
    }

    public void show(String command) {
        if (command == null) {
            System.out.println("Show what?");
            return;
        }

        switch (command) {
            case "inventory":
                this.inventory.show();
                break;
            case "status":
                this.showStatus();
                break;
            default:
                boolean found = false;
                for (BaseItem i : this.getInventory().getItems()) {
                    if (i.getName().equals(command)) {
                        System.out.println(i.toString());
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("You don't have this item in your inventory");
                break;
        }
    }

    public void equipItem(BaseItem item) {
        if (!this.getInventory().contains(item)) {
            System.out.println("You don't have this item in your inventory!");
            return;
        }

        switch (item.getType()) {
            case BaseItem.WEAPON:
                if (this.hasWeapon()) {
                    if (!this.getInventory().addItem(this.weapon))
                        return;

                }
                this.getInventory().removeItem(item);
                this.weapon = (Weapon) item;
                break;

            case BaseItem.DEFENSE:
                if (this.hasShield()) {
                    if (!this.getInventory().addItem(this.shield))
                        return;
                }
                this.getInventory().removeItem(item);
                this.shield = (Defense) item;
                break;
            default:
                System.out.println("You cannot equip this item");
                break;
        }
    }

    public void equipItem(String itemName) {
        BaseItem item = this.getInventory().getItem(itemName);
        this.equipItem(item);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Defense getShield() {
        return shield;
    }

    public boolean hasWeapon() {
        return this.weapon != null;
    }

    public boolean hasShield() {
        return this.shield != null;
    }
}
