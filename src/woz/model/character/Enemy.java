package woz.model.character;

import woz.model.item.BaseItem;

/**
 * Class of Enemy type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */

public class Enemy extends Character {

    public static final Integer XP_REWARD_MULTIPLIER = 2;
    private BaseItem droppableItem;

    /**
     * Constructor of Enemy
     * @param name Enemy's name
     * @param life Enemy's life
     * @param level Enemy's level
     */
    public Enemy(String name, Integer life, Integer level) {
        super(name, life, level);
    }

    /**
     * Drop enemy's item
     * @return Item to be dropped
     */
    public BaseItem getDroppableItem() {
        return droppableItem;
    }

    /**
     * Set Item to be dropped
     * @param droppableItem Enemy's item
     */
    public void setDroppableItem(BaseItem droppableItem) {
        this.droppableItem = droppableItem;
    }

    /**
     * Check if enemy has a droppable item
     * @return True if you have an item, false if you have not
     */
    public Boolean hasDroppableItem() {
        return this.droppableItem != null;
    }

    /**
     * Returns xp to be increased to those who defeated
     * @return Return Xp to be increased
     */
    public Integer getXPReward() {
        return this.getLevel() * Enemy.XP_REWARD_MULTIPLIER;
    }
}
