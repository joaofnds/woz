package woz.model.character;

import woz.model.item.BaseItem;

public class Enemy extends Character{

    private BaseItem droppableBaseItem;

    public Enemy(String name, Integer life, Integer level) {
        super(name, life, level);
    }
}
