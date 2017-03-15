package woz.model.item;

public class Defense extends BaseItem {

    private Integer defenseIncrease;

    public Defense(String name, String description, Integer space, Integer defenseIncrease) {
        super(name, description, space);
    }

    public Integer getDefenseIncrease() {
        return defenseIncrease;
    }

    public void setDefenseIncrease(Integer defenseIncrease) {
        this.defenseIncrease = defenseIncrease;
    }
}
