package woz.engine;

import woz.model.character.Hero;
import woz.model.item.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Hero player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        this.player = new Hero("Joao", 90);
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        Food maca = new Food("maça", "Coma para ganhar energia", 1, 4);
        Weapon sword = new Weapon("sword", "Kill'em all", 5, 20);
        Defense shield = new Defense("shield", "Defend'em all", 3, 15);

        outside.getItems().add(maca);
        outside.getItems().add(sword);
        outside.getItems().add(shield);

        theatre.getItems().add(maca);
        pub.getItems().add(maca);
        lab.getItems().add(maca);
        office.getItems().add(maca);


        // initialise room exits
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();

        switch (commandWord) {
            case CommandWords.HELP:
                printHelp(command);
                break;
            case CommandWords.GO:
                goRoom(command);
                break;
            case CommandWords.QUIT:
                wantToQuit = quit(command);
                break;
            case CommandWords.LOOK:
                look(command);
                break;
            case CommandWords.SHOW:
                this.player.show(command.getSecondWord());
                break;
            case CommandWords.COLLECT:
                collectItem(command);
                break;
            case CommandWords.PURGE:
                purgeItem(command);
                break;
            case CommandWords.USE:
                this.player.useItem(command.getSecondWord());
                break;
            case CommandWords.EQUIP:
                this.player.equipItem(command.getSecondWord());
                break;
            default:
                break;
        }

        return wantToQuit;
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp(Command command)
    {
        if (command.getSecondWord() == null) {
            System.out.println("You are lost. You are alone. You wander");
            System.out.println("around at the university.");
            System.out.println();
            System.out.println("Your command words are:");
            parser.showCommands();
        } else {
            System.out.println(CommandWords.getDescription(command));
        }
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void look(Command command) {
        if (command.getSecondWord() == null) {
            System.out.printf("%n%s%n", currentRoom.getLongDescription());
            return;
        }

        switch (command.getSecondWord()) {
            case "enemies":
                currentRoom.lookEnemiesDetails();
                break;
            case "items":
                currentRoom.lookItemsDetails();
                break;
            case "exits":
                currentRoom.lookExits();
                break;
            default:
                System.out.println("I can't look into that..");
                break;
        }
    }

    private void collectItem(Command command) {
        if (command.getSecondWord() == null) {
            System.out.println("Collect what?");
            return;
        }

        if (currentRoom.getItems().size() == 0) {
            System.out.println("This room doesn't have any items!");
            return;
        }

        String item = command.getSecondWord();
        for (BaseItem i : currentRoom.getItems()) {
            if (i.getName().equals(item)) {
                if (player.addItemToInventory(i)) {
                    System.out.println("Item collected!");
                    currentRoom.getItems().remove(i);
                } else {
                    System.out.println("Couldn't collect item!");
                }
                return;
            }
        }

        System.out.printf("Couldn't find item '%s' in this room.%n", item);
    }

    private void purgeItem(Command command) {
        if (command.getSecondWord() == null) {
            System.out.println("You need to provide a item name");
            return;
        }
        
        String itemName = command.getSecondWord();
        boolean found = false;
        for (BaseItem i : this.player.getInventory().getItems()) {
            if (i.getName().equals(itemName)) {
                player.removeItemFromInventory(i);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.printf("'%s' was not found in your inventory!%n", itemName);
        } else {
            System.out.printf("'%s' was purged from your inventory!%n", itemName);
        }
    }

    private void equipItem(Command command) {
        System.out.println("Functionality not implemented yet");
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
