package woz.model.item;


/**
 * Class of type InventoryItem that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */

public abstract class InventoryItem {
    public final static String WEAPON = "weapon";
    public final static String DEFENSE = "defense";
    public final static String FOOD = "food";
    public final static String POTION = "potion";
    public final static String LIFE = "life";
    public final static String COIN_BAG = "coin-bag";

    private String name;
    private String description;
    private Integer space;
    private String type;

    /**
     * Contructor of InventoryItem
     * @param name InventoryItem's name
     * @param description InventoryItem's description
     * @param space Space occupied by InventoryItem
     * @param type InventoryItem's type
     */

    public InventoryItem(String name, String description, Integer space, String type) {
        this.name = name;
        this.description = description;
        this.space = space;
        this.type = type;
    }

    /**
     * Get baseItem's name
     * @return baseItem's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set baseItem's name
     * @param name baseItem's
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get baseItem's description
     * @return baseItem's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set baseItem's description
     * @param description baseItem's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get baseItem's Occupied space
     * @return baseItem's occupied space
     */
    public Integer getSpace() {
        return space;
    }

    /**
     * Set baseItem's occupied space
     * @param space baseItem's occupied space
     */
    public void setSpace(Integer space) {
        this.space = space;
    }

    /**
     * Get baseItem's type
     * @return baseItem's type
     */
    public String getType() {
        return type;
    }

    @Override
    /**
     * transform strings to the right formate
     */
    public String toString() {
        String s = "";
        s += String.format("\tName: %s%n", this.getName());
        s += String.format("\tDescription: %s%n", this.getDescription());
        s += String.format("\tSpace: %s%n", this.getSpace());
        return s;
    }
}
