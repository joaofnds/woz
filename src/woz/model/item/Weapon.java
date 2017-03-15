package woz.model.item;

public class Weapon extends BaseItem {

    private Integer damageIncrease;

    public Weapon(String name, String description, Integer space, Integer damageIncrease) {
        super(name, description, space);
    }

    public Integer getDamageIncrease() {
        return damageIncrease;
    }

    public void setDamageIncrease(Integer damageIncrease) {
        this.damageIncrease = damageIncrease;
    }
}
