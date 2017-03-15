package woz.model.item;

public class Food extends BaseItem {

    private Integer lifeIncrease;

    public Food(String name, String description, Integer space, Integer lifeIncrease) {
        super(name, description, space);
    }

    public Integer getLifeIncrease() {
        return lifeIncrease;
    }

    public void setLifeIncrease(Integer lifeIncrease) {
        this.lifeIncrease = lifeIncrease;
    }
}
