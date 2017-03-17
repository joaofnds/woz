package woz.model.character;

public abstract class Character {
    public static final Integer MAX_HP = 100;
    public static final Integer MAX_LEVEL = 10;

    private String name;
    private Integer hp;
    private Integer level;

    public Character(String name, Integer hp, Integer level) {
        this.name = name;
        this.hp = hp;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = (hp > Character.MAX_HP)
                ? Character.MAX_HP
                : (hp < 0)
                ? 0
                : hp;
    }

    public void increaseHp(Integer amount) {
        this.setHp(this.hp + amount);
    }

    public void decreaseHp(Integer amount) {
        this.setHp(this.hp - amount);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = (level > Character.MAX_LEVEL)
                ? Character.MAX_LEVEL
                : (level < 0)
                ? 0
                : level;
    }

    public void increaseLevel() {
        this.setLevel(this.level + 1);
    }

    public void decreaseLevel() {
        this.setLevel(this.level - 1);
    }

    public void showStatus() {
        System.out.println("Nome: " + name + "\nHp: " + hp + "\nLevel: " + level);
        System.out.printf("- %s%n", this.name);
        System.out.println("\tHP: " + this.hp);
        System.out.println("\tLevel: " + this.level);
    }
}
