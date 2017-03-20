package woz.model.item;

public class Weapon extends InventoryItem {

    private Integer damageIncrease;

    public Weapon(String name, String description, Integer space, Integer damageIncrease) {
        super(name, description, space, InventoryItem.WEAPON);
        this.damageIncrease = damageIncrease;
    }

    public Integer getDamageIncrease() {
        return damageIncrease;
    }

    public void setDamageIncrease(Integer damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    public void showStatus() {
        System.out.println("\tWeapon:");
        System.out.println("\t\tName: " + this.getName());
        System.out.println("\t\tDescription: " + this.getDescription());
        System.out.println("\t\tSpace: " + this.getSpace());
        System.out.printf("\t\tDamage Increase: +%d%n", this.getDamageIncrease());
    }
}
