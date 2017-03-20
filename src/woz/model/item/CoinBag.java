package woz.model.item;
/**
 * Class of type CoinBag that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class CoinBag extends InventoryItem {
    private Integer amount;

    /**
     * Constructor of CoinBag
     * @param name CoinBag's name
     * @param description Description of CoinBag
     */
    public CoinBag(String name, String description) {
        super(name, description, 0, InventoryItem.COIN_BAG);
        this.amount = 0;
    }

    /**
     * Get Amount of coins in bag
     * @return Amount of coins
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Add coins to bag
     * @param amount amount of coins to be added on bag
     */
    public void addCoins(Integer amount) {
        this.amount = ((this.amount + amount) >= 0) ? this.amount+amount : 0;

        if (this.amount == 0) {
            setSpace(1);
            return;
        }

        int newSpace = (int) Math.ceil((double) this.amount / 1000);

        if (newSpace != getSpace())
            setSpace(newSpace);
    }

    /**
     * Remove coins from bag
     * @param amount amount of coins to remove
     */
    public void removeCoins(Integer amount) {
        addCoins(amount*-1);
    }

    @Override
    /**
     * Return a string with a description of coin bag
     */
    public String toString() {
        String s = "";
        s += String.format("\tCoin Bag:%n");
        s += String.format("\t\tCoins: %d%n", amount);
        s += String.format("\t\tCurrent Size: %d%n", getSpace());
        return s;
    }
}
