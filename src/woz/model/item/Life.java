package woz.model.item;


/**
 * Class of type Life that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Life extends InventoryItem {
    /**
     * Constructor of life
     */
    public Life() {
        super("life",
                "Restore all your life when you die",
                10,
                InventoryItem.LIFE);
    }
}
