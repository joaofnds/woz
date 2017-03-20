package woz.model.item;

public class Food extends InventoryItem {

    private Integer lifeIncrease;

    public Food(String name, String description, Integer space, Integer lifeIncrease) {
        super(name, description, space, InventoryItem.FOOD);
        this.lifeIncrease = lifeIncrease;
    }

    public Integer getLifeIncrease() {
        return lifeIncrease;
    }

    public void setLifeIncrease(Integer lifeIncrease) {
        this.lifeIncrease = lifeIncrease;
    }
}
