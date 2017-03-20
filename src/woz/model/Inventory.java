package woz.model;

import woz.model.item.InventoryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    public static final Integer MAX = 1000;
    List<InventoryItem> items;
    private Integer load;

    public Inventory() {
        this.items = new ArrayList<InventoryItem>();
        this.load = 0;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }

    public InventoryItem getItem(String name) {
        for (InventoryItem inventoryItem : this.getItems()) {
            if (inventoryItem.getName().toLowerCase().equals(name)) {
                return inventoryItem;
            }
        }
        return null;
    }

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

    public Boolean isFull() {
        return Objects.equals(this.getLoad(), Inventory.MAX);
    }

    public void show() {
        System.out.printf("- Inventory: (%d/%d)%n", this.getLoad(), Inventory.MAX);
        for (InventoryItem inventoryItem : this.getItems()) {
            System.out.println(inventoryItem.toString());
        }
    }

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

    public boolean contains(String itemName) {
        for (InventoryItem i : this.items) {
            if (i.getName().equals(itemName)) {
                return true;
            }
        }

        return false;
    }
}
