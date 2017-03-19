package woz.model.character;

import woz.model.Inventory;
import woz.model.item.*;
/**
 * * Class of Hero type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */

public class Hero extends Character {
    private final Integer lvl_multiplier = 10;
    private Inventory inventory;
    private Integer XP;
    private Weapon weapon;
    private Defense shield;

    /**
     * Constructor of Hero
     * @param name Hero's name
     * @param hp Hero's hp
     */
    public Hero(String name, Integer hp) {
        super(name, hp, 1);
        this.XP = 0;
        this.inventory = new Inventory();
        this.weapon = null;
    }

    /**
     * Return hero's inventory
     * @return hero's inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Set hero's inventory
     * @param inventory Hero's invetory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Return hero's xp
     * @return Hero's xp
     */
    public Integer getXP() {
        return XP;
    }

    /**
     * Set hero's xp
     * @param XP Hero's xp
     */
    public void setXP(Integer XP) {
        this.XP = XP;
    }

    /**
     * Xp to be increased
     * @param XP Earned xp
     */
    public void addXP(Integer XP) {
        this.XP += XP;
        if (this.XP >= (this.getLevel() * this.lvl_multiplier)) {
            this.XP -= (this.getLevel() * this.lvl_multiplier);
            this.increaseLevel();
            System.out.println("*** LEVEL INCREASED! ***");
        }
    }

    /**
     * Use a inventory's item
     * @param itemName Name of item to be used
     */
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
                increaseHp(increase);
                getInventory().removeItem(item);
                break;
            case BaseItem.POTION:
                increase = ((Potion) item).getLifeIncrease();
                increaseHp(increase);
                break;
            case BaseItem.WEAPON:
                System.out.println("This is a weapon item");
                break;
            case BaseItem.LIFE:
                setHp(Hero.MAX_HP);
                getInventory().removeItem(item);
                break;
            default:
                System.out.println("Item type not recognized");
                break;
        }
    }

    @Override
    /**
     * Print Hero's status
     */
    public void showStatus() {
        super.showStatus();
        System.out.println("\tXP: " + this.getXP());

        if (this.hasWeapon())
            this.getWeapon().showStatus();
        else
            System.out.println("\tWeapon: None");

        if (this.hasShield())
            this.getShield().showStatus();
        else
            System.out.println("\tShield: None");
    }

    /**
     * Print inventory's or hero's status
     * @param command Command that tells which status to showed
     */
    public void show(String command) {
        if (command == null) {
            System.out.println("Show what?");
            return;
        }

        switch (command) {
            case "inventory":
                this.getInventory().show();
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

    /**
     * Equip a item on hero
     * @param item Item to be equipped
     */
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

    /**
     * Equip a item on hero
     * @param itemName Item to be equipped
     */
    public void equipItem(String itemName) {
        BaseItem item = this.getInventory().getItem(itemName);
        this.equipItem(item);
    }

    /**
     * Return hero's weapon
     * @return hero's weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Return hero's shield
     * @return hero's shield
     */
    public Defense getShield() {
        return shield;
    }

    /**
     * Check if hero has a weapon
     * @return true if hero has a sword, false if hasn't
     */
    public boolean hasWeapon() {
        return this.weapon != null;
    }

    /**
     * Check if hero has a shield
     * @return true if hero has a shield, false if hasn't
     */
    public boolean hasShield() {
        return this.shield != null;
    }

    /**
     * Battle with a enemy
     * @param enemy Enemy to battle with
     */
    public void battle(Enemy enemy) {
        if (enemy.isDead()) {
            System.out.println("Enemy is dead already.");
            return;
        }
        int damage, defense;

        damage = this.hasWeapon() ? this.weapon.getDamageIncrease() : 0;
        defense = this.hasShield() ? this.shield.getDefenseIncrease() : 0;

        enemy.decreaseHp(damage + getLevel());
        this.decreaseHp(enemy.getLevel() - defense);

        this.showStatus();
        enemy.showStatus();
    }
}
