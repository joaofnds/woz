package woz.model.item;

public class Potion extends BaseItem {

    private Integer lifeIncrease;

    public Potion(String name, String description, Integer space, Integer lifeIncrease) {
        super(name, description, space, BaseItem.POTION);
        this.lifeIncrease = lifeIncrease;
    }

    public Integer getLifeIncrease() {
        return lifeIncrease;
    }

    public void setLifeIncrease(Integer lifeIncrease) {
        this.lifeIncrease = lifeIncrease;
    }
}
