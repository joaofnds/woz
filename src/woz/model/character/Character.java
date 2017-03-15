package woz.model.character;

public abstract class Character {
    private String name;
    private Integer life;
    private Integer level;

    public Character(String name, Integer life, Integer level) {
        this.name = name;
        this.life = life;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
