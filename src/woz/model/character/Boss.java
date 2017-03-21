package woz.model.character;



import woz.model.item.Life;
import woz.model.item.Weapon;

/**
 * Class of type Boss that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @version 1.00
 */
public class Boss extends Enemy {

    private final Integer XP_REWARD_MULTIPLIER = 5;
    private final Integer COIN_REWARD = 1000;

    private Weapon droppableWeapon;
    private Life droppableLife;

    /**
     * Constructor of boss
     * @param name Boss's name
     * @param life Boss's life
     * @param level Boss's level
     */
    public Boss(String name, Integer life, Integer level) {
        super(name, life, level);
    }

    /**
     * Get a weapon to be dropped
     * @return Weapon to be dropped
     */
    public Weapon getDroppableWeapon() {
        return droppableWeapon;
    }

    /**
     * Set weapon to be dropped
     * @param droppableWeapon Weapon to be dropped
     */
    public void setDroppableWeapon(Weapon droppableWeapon) {
        this.droppableWeapon = droppableWeapon;
    }

    /**
     * Check if has a droppable weapon
     * @return true if has, false if hasn't
     */
    public Boolean hasDroppableWeapon() {
        return this.droppableWeapon != null;
    }

    /**
     * Get a life drop
     * @return a droppable life
     */
    public Life getDroppableLife() {
        return droppableLife;
    }

    /**
     * set a life to drop
     * @param droppableLife life to drop
     */
    public void setDroppableLife(Life droppableLife) {
        this.droppableLife = droppableLife;
    }

    /**
     * Check if has a life to drop
     * @return True if has, false if hasn't
     */
    public Boolean hasDroppableLife() {
        return this.droppableLife != null;
    }

    /**
     * Get xp to be increased to those who defeated the boss
     * @return xp to be increased
     */
    public Integer getXPReward() {
        return this.getLevel() * XP_REWARD_MULTIPLIER;
    }

    /**
     * Get coin to be earned to those who defeated the boss
     * @return coins to be earned
     */
    public Integer getCoinReward() {
        return COIN_REWARD;
    }
}
