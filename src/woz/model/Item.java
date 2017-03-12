package woz.model;

public class Item {
    private String name;
    private String description;
    private Integer space;

    public Item(String name, String description, Integer space) {
        this.name = name;
        this.description = description;
        this.space = space;
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

    @Override
    public String toString() {
        String s = "";
        s += String.format("\tName: %s%n", this.getName());
        s += String.format("\tDescription: %s%n", this.getDescription());
        s += String.format("\tSpace: %s%n", this.getSpace());
        return s;
    }
}
