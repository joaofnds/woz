package woz.model.item;

public class Life extends InventoryItem {
    public Life() {
        super("life",
                "Restore all your life when you die",
                10,
                InventoryItem.LIFE);
    }
}
