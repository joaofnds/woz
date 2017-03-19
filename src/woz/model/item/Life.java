package woz.model.item;

/**
 * Class of Life type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Life extends BaseItem {

    /**
     * Constructor o Life
     */
    public Life() {
        super("life",
                "Restore all your life when you die",
                10,
                BaseItem.LIFE);
    }
}
