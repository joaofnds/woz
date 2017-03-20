package woz.model;

import woz.model.item.InventoryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class of type Inventory that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Inventory {
    public static final Integer MAX = 1000;
    List<InventoryItem> items;
    private Integer load;

    /**
     * Constructor of inventory
     */
    public Inventory() {
        this.items = new ArrayList<InventoryItem>();
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
    public List<InventoryItem> getItems() {
        return items;
    }
    /**
     * Set inventory's items
     * @param items list of inventory's items
     */
    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
    /**
     * Get Inventory's Item
     * @param name Item's name
     * @return Inventory's item
     */
    public InventoryItem getItem(String name) {
        for (InventoryItem inventoryItem : this.getItems()) {
            if (inventoryItem.getName().toLowerCase().equals(name)) {
                return inventoryItem;
            }
        }
        return null;
    }

    /**
     Returns whether it was possible to add the item to inventory
     * @param inventoryItem Item to be added
     * @return true is was possible add, false if wasn't
     */

    public Boolean addItem(InventoryItem inventoryItem) {
        if (this.load + inventoryItem.getSpace() > Inventory.MAX) {
            System.out.println("Insufficient space on your inventory");
            return false;
        } else {
            this.items.add(inventoryItem);
            this.load += inventoryItem.getSpace();
            return true;
        }
    }

    /**
     * Returns whether it was possible to remove the item to inventory
     * @param inventoryItem Item to be removed
     * @return true is was possible remove, false if wasn't
     */
    public Boolean removeItem(InventoryItem inventoryItem) {
        if (inventoryItem.getType().equals(InventoryItem.COIN_BAG)) {
            System.out.println("Why would you do that??? This item is permanent, you cannot remove it!");
            return false;
        }

        if (!this.getItems().contains(inventoryItem)) {
            return false;
        } else {
            this.items.remove(inventoryItem);
            this.load -= inventoryItem.getSpace();
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

        InventoryItem item = this.getItem(itemName);
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
        for (InventoryItem inventoryItem : this.getItems()) {
            System.out.println(inventoryItem.toString());
        }
    }

    /**
     * Check if has the searched item
     * @param item Item to be searched
     * @return True if inventory has the item, false if hasn't
     */
    public boolean contains(InventoryItem item) {
        if (item == null)
            return false;

        for (InventoryItem i : this.items) {
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
        for (InventoryItem i : this.items) {
            if (i.getName().equals(itemName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Updates inventory load
     */
    public void updateLoad() {
        int load = 0;
        for (InventoryItem i : this.items) {
            load += i.getSpace();
        }
        this.load = load;
    }
}
