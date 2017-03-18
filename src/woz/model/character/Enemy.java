package woz.model.character;

import woz.model.item.BaseItem;

public class Enemy extends Character {

    public static final Integer XP_REWARD_MULTIPLIER = 2;
    private BaseItem droppableItem;

    public Enemy(String name, Integer life, Integer level) {
        super(name, life, level);
    }

    public BaseItem getDroppableItem() {
        return droppableItem;
    }

    public void setDroppableItem(BaseItem droppableItem) {
        this.droppableItem = droppableItem;
    }

    public Boolean hasDroppableItem() {
        return this.droppableItem != null;
    }

    public Integer getXPReward() {
        return this.getLevel() * Enemy.XP_REWARD_MULTIPLIER;
    }
}
