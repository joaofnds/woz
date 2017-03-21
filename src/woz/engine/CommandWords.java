package woz.engine;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords {
    public static final String GO = "go";
    public static final String LOOK = "look";
    public static final String SHOW = "show";
    public static final String COLLECT = "collect";
    public static final String PURGE = "purge";
    public static final String USE = "use";
    public static final String EQUIP = "equip";
    public static final String HELP = "help";
    public static final String QUIT = "quit";
    public static final String ATTACK = "attack";
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
            CommandWords.GO,
            CommandWords.LOOK,
            CommandWords.SHOW,
            CommandWords.COLLECT,
            CommandWords.PURGE,
            CommandWords.USE,
            CommandWords.EQUIP,
            CommandWords.HELP,
            CommandWords.QUIT,
            CommandWords.ATTACK
    };


    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() { }

    /**
     * Checks if the syntax of the command is correct
     * @param command Command to be verified
     * @return Returns the right format
     */
    public static String getDescription(Command command) {
        String s = "";
        switch (command.getSecondWord()) {
            case CommandWords.GO:
                s += String.format("Syntax: go north|south|east|west");
                s += String.format("%nDescription: Use this command to change rooms.");
                s += String.format("%nExample: go east");
                break;
            case CommandWords.LOOK:
                s += String.format("Syntax: look enemies|items|exist");
                s += String.format("%nDescription: Lists available enemies, items or exits in the current room.");
                s += String.format("%nExample: look enemies");
                break;
            case CommandWords.SHOW:
                s += String.format("Syntax: show inventory|itemName");
                s += String.format("%nDescription: Shows your whole inventory or a specific item in your inventory.");
                s += String.format("%nExample: show apple (Assuming that the player have an 'apple' item in their inventory)");
                break;
            case CommandWords.COLLECT:
                s += String.format("Syntax: collect itemName");
                s += String.format("%nDescription: Takes a item from the current room and stores in player inventory");
                s += String.format("%nExample: collect apple (Assuming that the current room have an 'apple' item)");
                break;
            case CommandWords.PURGE:
                s += String.format("Syntax: purge itemName");
                s += String.format("%nDescription: Purges a item from players inventory");
                s += String.format("%nExample: purge apple (Assuming that the player have an 'apple' item in their inventory)");
                break;
            case CommandWords.USE:
                s += String.format("Syntax: use itemName");
                s += String.format("%nDescription: Uses an item to get it's benefits");
                s += String.format("%nExample: use apple (Assuming that the player have an 'apple' item in their inventory)");
                break;
            case CommandWords.EQUIP:
                s += String.format("Syntax: equip itemName");
                s += String.format("%nDescription: Equips an item from inventory to get it's benefits");
                s += String.format("%nExample: equip sword (Assuming that the player have an 'sword' item in their inventory)");
                break;
            case CommandWords.HELP:
                s += String.format("Syntax: help go|look|show|collect|purge|use|equip|help|quit");
                s += String.format("%nDescription: Show information about a given command.");
                s += String.format("%nExample: help");
                break;
            case CommandWords.ATTACK:
                s += String.format("Syntax: attack");
                s += String.format("%nDescription: Attack a target");
                s += String.format("%nExample: attack ghost");
                break;
            case CommandWords.QUIT:
                s += String.format("Syntax: quit");
                s += String.format("%nDescription: Quits the game.");
                s += String.format("%nExample: quit");
                break;

            default:
                s += "This isn't a command";
        }
        return s;
    }

    /**
     * * Check whether a given String is a valid command word.
     * @param aString String to be tested
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString) {
        for (String command : validCommands) {
            if (command.equals(aString)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() {
        for (String command : validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
