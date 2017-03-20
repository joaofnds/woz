package woz.model.item;

/**
 * Class of type Potion that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Potion extends InventoryItem {


    private Integer lifeIncrease;

    /**
     * Constructor of Potions
     * @param name Potion's name
     * @param description Potion's description
     * @param space Space occupied by potion
     * @param lifeIncrease Amount of life to be increased
     */
    public Potion(String name, String description, Integer space, Integer lifeIncrease) {
        super(name, description, space, InventoryItem.POTION);
        this.lifeIncrease = lifeIncrease;
    }

    /**
     *Get amount of life to be increased
     * @return amount of life to increase
     */
    public Integer getLifeIncrease() {
        return lifeIncrease;
    }

    /**
     * Set amount to increase with potion
     * @param lifeIncrease amounto to increase
     */
    public void setLifeIncrease(Integer lifeIncrease) {
        this.lifeIncrease = lifeIncrease;
    }
}
