package woz.model.character;

import woz.model.item.Life;
import woz.model.item.Weapon;

public class Boss extends Enemy {

    private final Integer XP_REWARD_MULTIPLIER = 5;
    private final Integer COIN_REWARD = 1000;

    private Weapon droppableWeapon;
    private Life droppableLife;

    /**
     *
     * @param name
     * @param life
     * @param level
     */
    public Boss(String name, Integer life, Integer level) {
        super(name, life, level);
    }

    public Weapon getDroppableWeapon() {
        return droppableWeapon;
    }

    public void setDroppableWeapon(Weapon droppableWeapon) {
        this.droppableWeapon = droppableWeapon;
    }

    public Boolean hasDroppableWeapon() {
        return this.droppableWeapon != null;
    }

    public Life getDroppableLife() {
        return droppableLife;
    }

    public void setDroppableLife(Life droppableLife) {
        this.droppableLife = droppableLife;
    }

    public Boolean hasDroppableLife() {
        return this.droppableLife != null;
    }

    public Integer getXPReward() {
        return this.getLevel() * XP_REWARD_MULTIPLIER;
    }

    public Integer getCoinReward() {
        return COIN_REWARD;
    }
}
