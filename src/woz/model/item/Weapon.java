package woz.model.item;

/**
 * Class of Weapon type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Weapon extends BaseItem {

    private Integer damageIncrease;

    /**
     * Constructor of weapon items
     * @param name weapon' name
     * @param description weapon' description
     * @param space Space occupied by weapon
     * @param damageIncrease weapon's damage to be increased
     */
    public Weapon(String name, String description, Integer space, Integer damageIncrease) {
        super(name, description, space, BaseItem.WEAPON);
        this.damageIncrease = damageIncrease;
    }

    /**
     * Get amount of damage to be increased
     * @return Amount to be increased
     */
    public Integer getDamageIncrease() {
        return damageIncrease;
    }

    /**
     * Set damage to be increased
     * @param damageIncrease amount of damage
     */
    public void setDamageIncrease(Integer damageIncrease) {
        this.damageIncrease = damageIncrease;
    }

    /**
     * Print Weapon's status
     */
    public void showStatus() {
        System.out.println("\tWeapon:");
        System.out.println("\t\tName: " + this.getName());
        System.out.println("\t\tDescription: " + this.getDescription());
        System.out.println("\t\tSpace: " + this.getSpace());
        System.out.printf("\t\tDamage Increase: %d%%%n", this.getDamageIncrease());
    }
}
