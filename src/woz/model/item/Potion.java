package woz.model.item;

public class Potion extends BaseItem {

    private Integer lifeIncrease;

    public Potion(String name, String description, Integer space, Integer lifeIncrease) {
        super(name, description, space);
    }

    public Integer getLifeIncrease() {
        return lifeIncrease;
    }

    public void setLifeIncrease(Integer lifeIncrease) {
        this.lifeIncrease = lifeIncrease;
    }
}
