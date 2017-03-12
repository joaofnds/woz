package woz.model;

public class Hero extends Character {
    private Inventory inventory;
    private Integer XP;

    public Hero(String name, Integer life) {
        super(name, life, 1);
        this.XP = 0;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Boolean addItemToInventory(Item item) {
        return this.inventory.addItem(item);
    }

    public Boolean removeItemFromInventory(Item item) {
        return this.inventory.removeItem(item);
    }

    public Integer getXP() {
        return XP;
    }

    public void setXP(Integer XP) {
        this.XP = XP;
    }

    public void showInventory() {
        this.getInventory().show();
    }
}
