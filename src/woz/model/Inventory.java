package woz.model;

import woz.model.item.BaseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class of Inventory type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Inventory {
    public static final Integer MAX = 1000;
    List<BaseItem> items;
    private Integer load;

    /**
     * Constructor of inventory
     */
    public Inventory() {
        this.items = new ArrayList<BaseItem>();
        this.load = 0;
    }

    /**
     * Get load amount
     * @return load amount
     */
    public Integer getLoad() {
        return load;
    }

    /**
     * Set load amount
     * @param load load amount
     */
    public void setLoad(Integer load) {
        this.load = load;
    }

    /**
     * Get inventory's items
     * @return list of inventory's items
     */
    public List<BaseItem> getItems() {
        return items;
    }

    /**
     * Set inventory's items
     * @param items list of inventory's items
     */
    public void setItems(List<BaseItem> items) {
        this.items = items;
    }

    /**
     * Get Inventory's Item
     * @param name Item's name
     * @return Inventory's item
     */
    public BaseItem getItem(String name) {
        for (BaseItem baseItem : this.getItems()) {
            if (baseItem.getName().toLowerCase().equals(name)) {
                return baseItem;
            }
        }
        return null;
    }

    /**
     * Returns whether it was possible to add the item to inventory
     * @param baseItem Item to be added
     * @return true is was possible add, false if wasn't
     */
    public Boolean addItem(BaseItem baseItem) {
        if (this.load + baseItem.getSpace() > Inventory.MAX) {
            System.out.println("Insufficient space on your inventory");
            return false;
        } else {
            this.items.add(baseItem);
            this.load += baseItem.getSpace();
            return true;
        }
    }

    /**
     * Returns whether it was possible to remove the item to inventory
     * @param baseItem Item to be removed
     * @return true is was possible remove, false if wasn't
     */
    public Boolean removeItem(BaseItem baseItem) {
        if (!this.getItems().contains(baseItem)) {
            return false;
        } else {
            this.items.remove(baseItem);
            this.load -= baseItem.getSpace();
            return true;
        }
    }

    /**
     * Returns whether it was possible to remove the item to inventory
     * @param itemName Item to be removed's name
     * @return true is was possible remove, false if wasn't
     */

    public Boolean removeItem(String itemName) {
        if (itemName == null) {
            System.out.println("Purge what?");
            return false;
        }

        BaseItem item = this.getItem(itemName);
        if (item == null) {
            System.out.println("You don't have this item");
            return false;
        }

        return this.removeItem(item);
    }

    /**
     * Check if inventory is full
     * @return true if is full, false if isn't
     */
    public Boolean isFull() {
        return Objects.equals(this.getLoad(), Inventory.MAX);
    }

    /**
     * Print Intentory's items
     */
    public void show() {
        System.out.printf("- Inventory: (%d/%d)%n", this.getLoad(), Inventory.MAX);
        for (BaseItem baseItem : this.getItems()) {
            System.out.println(baseItem.toString());
        }
    }

    /**
     * Check if has the searched item
     * @param item Item to be searched
     * @return True if inventory has the item, false if hasn't
     */
    public boolean contains(BaseItem item) {
        if (item == null)
            return false;

        for (BaseItem i : this.items) {
            if (i.equals(item)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if has the searched item
     * @param itemName Item to be searched's name
     * @return True if inventory has the item, false if hasn't
     */
    public boolean contains(String itemName) {
        for (BaseItem i : this.items) {
            if (i.getName().equals(itemName)) {
                return true;
            }
        }

        return false;
    }
}
