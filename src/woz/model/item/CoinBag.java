package woz.model.item;

public class CoinBag extends InventoryItem {
    private Integer amount;

    public CoinBag(String name, String description) {
        super(name, description, 0, InventoryItem.COIN_BAG);
        this.amount = 0;
    }

    public Integer getAmount() {
        return amount;
    }

    public void addCoins(Integer amount) {
        this.amount = ((this.amount + amount) >= 0) ? this.amount+amount : 0;

        if (this.amount == 0) {
            setSpace(1);
            return;
        }

        int newSpace = (int) Math.ceil(this.amount / 1000);

        if (newSpace != getSpace())
            setSpace(newSpace);
    }

    public void removeCoins(Integer amount) {
        addCoins(amount*-1);
    }

    @Override
    public String toString() {
        String s = "";
        s += String.format("\tCoin Bag:%n");
        s += String.format("\t\tCoins: %d%n", amount);
        s += String.format("\t\tCurrent Size: %d%n", getSpace());
        return s;
    }
}
