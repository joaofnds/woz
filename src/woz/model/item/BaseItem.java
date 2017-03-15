package woz.model.item;

public class BaseItem {
    public final static String[] validTypes = {
        BaseItem.WEAPON,
        BaseItem.DEFENSE,
        BaseItem.FOOD,
        BaseItem.POTION
    };

    public final static String WEAPON = "weapon";
    public final static String DEFENSE = "defense";
    public final static String FOOD = "food";
    public final static String POTION = "potion";

    private String name;
    private String description;
    private Integer space;
    private String type;

    public BaseItem(String name, String description, Integer space, String type) {
        this.name = name;
        this.description = description;
        this.space = space;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        String s = "";
        s += String.format("\tName: %s%n", this.getName());
        s += String.format("\tDescription: %s%n", this.getDescription());
        s += String.format("\tSpace: %s%n", this.getSpace());
        return s;
    }
}