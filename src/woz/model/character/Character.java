package woz.model.character;

/**
 ** Class of type Character that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public abstract class Character {
    public static final Integer MAX_HP = 100;
    public static final Integer MAX_LEVEL = 10;

    private String name;
    private Integer hp;
    private Integer level;

    /**
     * Constructor of character
     * @param name Created character name
     * @param hp Created character hp
     * @param level Created character level
     */
    public Character(String name, Integer hp, Integer level) {
        this.name = name;
        this.hp = hp;
        this.level = level;
    }

    /**
     * Return a string with character's name
     * @return Return character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set caracter's name
     * @param name Name of character
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Return a integer with caracter's HP
     * @return Return charater's HP
     */
    public Integer getHp() {
        return hp;
    }

    /**
     * Set caracter's HP
     * @param hp Hp of caracter
     */
    public void setHp(Integer hp) {
        this.hp = (hp > Character.MAX_HP)
                ? Character.MAX_HP
                : (hp < 0)
                ? 0
                : hp;
    }

    /**
     * Increases character's HP
     * @param amount Amount of life to be increased
     */
    public void increaseHp(Integer amount) {
        this.setHp(this.hp + amount);
    }

    /**
     * Decrease character's HP
     * @param amount Amount of life to be decreased
     */
    public void decreaseHp(Integer amount) {
        this.setHp(this.hp - amount);
    }

    /**
     * Return a integer with character's level
     * @return Return character's level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Set Character's level
     * @param level Character's level
     */
    public void setLevel(Integer level) {
        this.level = (level > Character.MAX_LEVEL)
                ? Character.MAX_LEVEL
                : (level < 0)
                ? 0
                : level;
    }

    /**
     * Increases character's level
     */
    public void increaseLevel() {
        this.setLevel(this.level + 1);
    }

    /**
     * Decrease character's level
     */
    public void decreaseLevel() {
        this.setLevel(this.level - 1);
    }

    /**
     * Print character's status
     */
    public void showStatus() {
        System.out.printf("- %s:%n", this.name);
        System.out.println("\tHP: " + this.hp);
        System.out.println("\tLevel: " + this.level);
    }

    /**
     * Check if the character is dead
     * @return true if character is dead false if he is alive
     */
    public Boolean isDead() {
        return this.hp == 0;
    }
}
