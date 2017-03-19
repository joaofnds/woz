package woz.model.character;

/**
 * Class of Boss type that stores values ​​and methods for same
 * @author Gabriel Soares e João Fernandes
 * @Version 1.00
 */
public class Boss extends Enemy {
    /**
     * Constructor of boss
     * @param name Boss's name
     * @param life Boss's life
     * @param level Boss's level
     */
    public Boss(String name, Integer life, Integer level) {
        super(name, life, level);
    }
}
