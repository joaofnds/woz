package woz.model.item;


/**
 * Class of type Food that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @version 1.00
 */
public class Food extends InventoryItem {

    private Integer lifeIncrease;

    /**
     * Constructor of Food
     * @param name Food's name
     * @param description Food's description
     * @param space Space occupied by Food
     * @param lifeIncrease Amount of life to be increased
     */
    public Food(String name, String description, Integer space, Integer lifeIncrease) {
        super(name, description, space, InventoryItem.FOOD);
        this.lifeIncrease = lifeIncrease;
    }

    /**
     * Get amount of life to be increased
     * @return Amount to be increased
     */
    public Integer getLifeIncrease() {
        return lifeIncrease;
    }

    /**
     * Set amounto of life to be increased
     * @param lifeIncrease amount to increase
     */
    public void setLifeIncrease(Integer lifeIncrease) {
        this.lifeIncrease = lifeIncrease;
    }
}
