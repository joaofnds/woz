package woz.model.character;

import woz.model.item.InventoryItem;
import woz.model.item.Defense;
import woz.model.item.Weapon;

/**
 * Class of type Enemy that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @version 1.00
 */

public class Enemy extends Character {

    private final Integer XP_REWARD_MULTIPLIER = 2;
    private final Integer COIN_REWARD = 200;
    private InventoryItem droppableItem;

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
    public InventoryItem getDroppableItem() {
        return droppableItem;
    }

    /**
     * Set Item to be dropped
     * @param droppableItem Enemy's item
     */
    public void setDroppableItem(InventoryItem droppableItem) {
        if (droppableItem.getType().equals(InventoryItem.WEAPON) // If i'm setting a weapon
                && ((Weapon) droppableItem).getDamageIncrease() > 50) { // And this weapon has more than 50 points of damage increase
                System.out.println("You cannot set a weapon this powerful to a normal enemy");
                return;
        }

        if (droppableItem.getType().equals(InventoryItem.DEFENSE) // If i'm setting a shield
                && ((Defense) droppableItem).getDefenseIncrease() > 50 ) { // And this shield has more than 50 points of defense increase
            System.out.println("You cannot set a shield this powerful to a normal enemy");
            return;
        }

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
     * Returns xp to be increased to those who defeated the enemy
     * @return Return Xp to be increased
     */
    public Integer getXPReward() {
        return this.getLevel() * XP_REWARD_MULTIPLIER;
    }

    /**
     * Get coin to be earned to those who defeated the enemy
     * @return coin to be earned
     */
    public Integer getCoinReward() {
        return COIN_REWARD;
    }
}
