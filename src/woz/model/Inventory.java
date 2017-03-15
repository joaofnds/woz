package woz.model;

import woz.model.item.BaseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    public static final Integer MAX = 1000;

    private Integer load;
    List<BaseItem> baseItems;

    public Inventory() {
        this.baseItems = new ArrayList<BaseItem>();
        this.load = 0;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public List<BaseItem> getBaseItems() {
        return baseItems;
    }

    public void setBaseItems(List<BaseItem> baseItems) {
        this.baseItems = baseItems;
    }

    public BaseItem getItem(String name) {
        for (BaseItem baseItem : this.getBaseItems()) {
            if (baseItem.getName().toLowerCase().equals(name)) {
                return baseItem;
            }
        }
        return null;
    }

    public Boolean addItem(BaseItem baseItem) {
        if (this.load+ baseItem.getSpace() > Inventory.MAX) {
            return false;
        } else {
            this.baseItems.add(baseItem);
            this.load += baseItem.getSpace();
            return true;
        }
    }

    public Boolean removeItem(BaseItem baseItem) {
        if (!this.getBaseItems().contains(baseItem)) {
            return false;
        } else {
            this.baseItems.remove(baseItem);
            this.load -= baseItem.getSpace();
            return true;
        }
    }

    public Boolean isFull() {
        return Objects.equals(this.getLoad(), Inventory.MAX);
    }

    public void show() {
        System.out.printf("- Inventory: (%d/%d)%n", this.getLoad(), Inventory.MAX);
        for (BaseItem baseItem : this.getBaseItems()) {
            System.out.println(baseItem.toString());
        }
    }
}
