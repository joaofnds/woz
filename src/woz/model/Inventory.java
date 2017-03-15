package woz.model;

import woz.model.item.BaseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    public static final Integer MAX = 1000;

    private Integer load;
    List<BaseItem> items;

    public Inventory() {
        this.items = new ArrayList<BaseItem>();
        this.load = 0;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public List<BaseItem> getItems() {
        return items;
    }

    public void setItems(List<BaseItem> items) {
        this.items = items;
    }

    public BaseItem getItem(String name) {
        for (BaseItem baseItem : this.getItems()) {
            if (baseItem.getName().toLowerCase().equals(name)) {
                return baseItem;
            }
        }
        return null;
    }

    public Boolean addItem(BaseItem baseItem) {
        if (this.load+ baseItem.getSpace() > Inventory.MAX) {
            System.out.println("Insufficient space on your inventory");
            return false;
        } else {
            this.items.add(baseItem);
            this.load += baseItem.getSpace();
            return true;
        }
    }

    public Boolean removeItem(BaseItem baseItem) {
        if (!this.getItems().contains(baseItem)) {
            return false;
        } else {
            this.items.remove(baseItem);
            this.load -= baseItem.getSpace();
            return true;
        }
    }

    public Boolean isFull() {
        return Objects.equals(this.getLoad(), Inventory.MAX);
    }

    public void show() {
        System.out.printf("- Inventory: (%d/%d)%n", this.getLoad(), Inventory.MAX);
        for (BaseItem baseItem : this.getItems()) {
            System.out.println(baseItem.toString());
        }
    }

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

    public boolean contains(String itemName) {
        for (BaseItem i : this.items) {
            if (i.getName().equals(itemName)) {
                return true;
            }
        }

        return false;
    }
}
