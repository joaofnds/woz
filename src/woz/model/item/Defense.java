package woz.model.item;

public class Defense extends BaseItem {

    private Integer defenseIncrease;

    public Defense(String name, String description, Integer space, Integer defenseIncrease) {
        super(name, description, space, BaseItem.DEFENSE);
        this.defenseIncrease = defenseIncrease;
    }

    public Integer getDefenseIncrease() {
        return defenseIncrease;
    }

    public void setDefenseIncrease(Integer defenseIncrease) {
        this.defenseIncrease = defenseIncrease;
    }

    public void showStatus() {
        System.out.println("\tDefense:");
        System.out.println("\t\tName: " + this.getName());
        System.out.println("\t\tDescription: " + this.getDescription());
        System.out.println("\t\tSpace: " + this.getSpace());
        System.out.printf("\t\tDefense Increase: +%d%n", this.getDefenseIncrease());
    }
}
