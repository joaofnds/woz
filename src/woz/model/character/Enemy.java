package woz.model.character;

import woz.model.item.BaseItem;
import woz.model.item.Defense;
import woz.model.item.Weapon;

public class Enemy extends Character {

    private final Integer XP_REWARD_MULTIPLIER = 2;
    private BaseItem droppableItem;

    public Enemy(String name, Integer life, Integer level) {
        super(name, life, level);
    }

    public BaseItem getDroppableItem() {
        return droppableItem;
    }

    public void setDroppableItem(BaseItem droppableItem) {
        if (droppableItem.getType().equals(BaseItem.WEAPON) // If i'm setting a weapon
                && ((Weapon) droppableItem).getDamageIncrease() > 50) { // And this weapon has more than 50 points of damage increase
                System.out.println("You cannot set a weapon this powerful to a normal enemy");
                return;
        }

        if (droppableItem.getType().equals(BaseItem.DEFENSE) // If i'm setting a shield
                && ((Defense) droppableItem).getDefenseIncrease() > 50 ) { // And this shield has more than 50 points of defense increase
            System.out.println("You cannot set a shield this powerful to a normal enemy");
            return;
        }

        this.droppableItem = droppableItem;
    }

    public Boolean hasDroppableItem() {
        return this.droppableItem != null;
    }

    public Integer getXPReward() {
        return this.getLevel() * XP_REWARD_MULTIPLIER;
    }
}
