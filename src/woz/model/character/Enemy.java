package woz.model.character;

import woz.model.item.BaseItem;

public class Enemy extends Character {

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
}
