import woz.model.Hero;
import woz.model.Item;

public class Main {
    public static void main(String[] args) {
//        Game game = new Game();
//        game.play();

        Hero h = new Hero("João", 100);
        Item maca = new Item("maçã", "Come essa merda", 1);
        Item pera  = new Item("Pera", "Come essa merda tbm", 2);
        h.addItemToInventory(maca);
        h.addItemToInventory(pera);
        h.showInventory();
        h.removeItemFromInventory(maca);
        h.showInventory();
    }
}
