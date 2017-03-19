package woz.model.item;

/**
 * Class of Defense type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Defense extends BaseItem {

    private Integer defenseIncrease;

    /**
     * Constructor of Defense items
     * @param name Defense's items name
     * @param description Defense's items description
     * @param space Space occupied by defense
     * @param defenseIncrease Defense's items amount of defense to be increased
     */
    public Defense(String name, String description, Integer space, Integer defenseIncrease) {
        super(name, description, space, BaseItem.DEFENSE);
        this.defenseIncrease = defenseIncrease;
    }

    /**
     * Get Defense to be increased
     * @return amount of defense to be increased
     */
    public Integer getDefenseIncrease() {
        return defenseIncrease;
    }

    /**
     * Set amount of defense to be increased
     * @param defenseIncrease Amount to be increased
     */
    public void setDefenseIncrease(Integer defenseIncrease) {
        this.defenseIncrease = defenseIncrease;
    }

    /**
     * Print defense's item status
     */
    public void showStatus() {
        System.out.println("\tDefense:");
        System.out.println("\t\tName: " + this.getName());
        System.out.println("\t\tDescription: " + this.getDescription());
        System.out.println("\t\tSpace: " + this.getSpace());
        System.out.printf("\t\tDefense Increase: +%d%n", this.getDefenseIncrease());
    }
}
