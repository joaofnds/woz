package woz.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static final Integer MAX = 1000;

    private Integer load;
    List<Item> items;

    public Inventory() {
        this.items = new ArrayList<Item>();
        this.load = 0;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem(String name) {
        for (Item item : this.getItems()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Boolean addItem(Item item) {
        if (this.load+item.getSpace() > Inventory.MAX) {
            return false;
        } else {
            this.items.add(item);
            this.load += item.getSpace();
            return true;
        }
    }

    public Boolean removeItem(Item item) {
        if (!this.getItems().contains(item)) {
            return false;
        } else {
            this.items.remove(item);
            this.load -= item.getSpace();
            return true;
        }
    }

    public Boolean isFull() {
        return this.getLoad() == Inventory.MAX;
    }

    public void show() {
        System.out.printf("- Inventory: (%d/%d)%n", this.getLoad(), Inventory.MAX);
        for (Item item : this.getItems()) {
            System.out.println(item.toString());
        }
    }
}
