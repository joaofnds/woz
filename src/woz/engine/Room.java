package woz.engine;

import woz.model.character.Enemy;
import woz.model.item.BaseItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room
 * stores a reference to the neighboring room.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Room {
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private List<BaseItem> items;
    private List<Enemy> enemies;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<String, Room>();
        this.items = new ArrayList<BaseItem>();
        this.enemies = new ArrayList<Enemy>();
    }

    /**
     * Define an exit from this room.
     *
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form:
     * You are in the kitchen.
     * Exits: north west
     *
     * @return A long description of this room
     */
    public String getLongDescription() {
        String s = "";

        s += String.format("Location: %s%n", this.description);
        s += String.format("%s%n", getExitString());
        s += String.format("%s%n", getItemsString());
        s += String.format("%s%n", getEnemiesString());

        return s;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     *
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public List<BaseItem> getItems() {
        return items;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy findEnemy(String enemyName) {
        for (Enemy e : this.enemies) {
            if (e.getName().equals(enemyName))
                return e;
        }

        return null;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     *
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public String getEnemiesString() {
        if (this.enemies.size() == 0)
            return "Luckely there's no enemies in this room.";


        String s = "Enemies: ";
        for (int i = 0; i < this.enemies.size(); i++) {
            s += i + 1 == this.enemies.size()
                    ? this.enemies.get(i).getName() + "."
                    : this.enemies.get(i).getName() + ", ";
        }
        return s;
    }

    public String getItemsString() {
        if (this.items.size() == 0)
            return "There's no items in this room.";

        String s = "Items: ";
        for (int i = 0; i < this.items.size(); i++) {
            s += i + 1 == this.items.size()
                    ? this.items.get(i).getName() + "."
                    : this.items.get(i).getName() + ", ";
        }
        return s;
    }

    private String getItemsDetailsString() {
        if (this.items.size() == 0)
            return "There's no items in this room.";

        String s = String.format("Items in this room:%n");
        for (BaseItem i : this.items) {
            s += String.format("%n\tName: %s%n", i.getName());
            s += String.format("\tDescription: %s%n", i.getDescription());
            s += String.format("\tSpace: %s%n", i.getSpace());
        }
        return s;
    }

    private String getEnemiesDetailsString() {
        if (this.enemies.size() == 0)
            return "Luckely there's no enemies in this room.";

        String s = String.format("Enemies in this room:%n");
        for (Enemy e : this.enemies) {
            s += String.format("%n\tName: %s%n", e.getName());
            s += String.format("\tLife: %s%n", e.getHp());
            s += String.format("\tLevel: %s%n", e.getLevel());
        }
        return s;
    }

    public void lookItemsDetails() {
        System.out.println(getItemsDetailsString());
    }

    public void lookEnemiesDetails() {
        System.out.println(getEnemiesDetailsString());
    }

    public void lookExits() {
        System.out.println(getExitString());
    }

    public void look(String command) {
        if (command == null) {
            System.out.printf("%n%s%n", this.getLongDescription());
            return;
        }

        switch (command) {
            case "enemies":
                this.lookEnemiesDetails();
                break;
            case "items":
                this.lookItemsDetails();
                break;
            case "exits":
                this.lookExits();
                break;
            default:
                System.out.println("I can't look into that..");
                break;
        }
    }
}

