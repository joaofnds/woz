package woz.engine;

import woz.model.character.Boss;
import woz.model.character.Enemy;
import woz.model.character.Hero;
import woz.model.item.*;

import java.util.Scanner;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Hero player;

    /**
     * Create the game and initialise its internal map and hero.
     */
    public Game() {
        createRooms();
        parser = new Parser();
        System.out.printf("Hero name%n> ");
        String heroName = (new Scanner(System.in)).nextLine().toLowerCase();
        this.player = new Hero(heroName, 90);
    }

    /**
     * Create all the rooms and link their exits together
     * Creates all enemies and places them in rooms.
     * Creates all items and distributes between rooms and enemies
     */
    private void createRooms() {
        Room hall,
                livingRoom,
                office,
                library,
                lavatory,
                dinnerRoom,
                kitchen,
                cellar,
                storeroom,
                corridor,
                livingroom2,
                lab,
                corridor2,
                room,
                room2,
                room3;

        // create the rooms
        hall = new Room("Entrance of the mansion");
        livingRoom = new Room("Living Room");
        office = new Room("Office");
        library = new Room("Library");
        lavatory = new Room("Lavatory");
        dinnerRoom = new Room("Dinner Room");
        kitchen = new Room("Kitchen");
        cellar = new Room("Cellar");
        storeroom = new Room("Store Room");
        corridor = new Room("Corridor");
        livingroom2 = new Room("Another Living Room");
        lab = new Room("Lab");
        corridor2 = new Room("Another Corridor");
        room = new Room("Room");
        room2 = new Room("Room");
        room3 = new Room("Room");

        //Create enemies
        Enemy Mob1 = new Enemy("ghost", 5, 3);
        Enemy Mob2 = new Enemy("demon", 35, 20);
        Enemy MobSh = new Enemy("devil", 155, 30);
        Enemy MobSw = new Enemy("devil", 155, 30);
        Boss boss = new Boss("mochila-de-criança", 200, 50);

        //Create Items
        Food apple = new Food("apple", "Eat to heal 4HP", 1, 4);
        Weapon sword = new Weapon("sword", "A simple sword", 50, 10);
        Weapon swordM = new Weapon("large-sword", "A blessed sword", 200, 25);
        Weapon excalibur = new Weapon("excalibur", "Legendary sword", 700, 150);
        Defense shield = new Defense("shield", "Defend'em all", 50, 10);
        Defense shieldM = new Defense("large-shield", "A blessed shield", 60, 25);
        Potion hpPot = new Potion("health-potion", "Heal 25HP", 15, 25);
        Life life = new Life();

        //Set room's items
        hall.getItems().add(apple);
        hall.getItems().add(hpPot);
        hall.getItems().add(life);

        dinnerRoom.getItems().add(apple);

        livingRoom.getItems().add(sword);
        livingRoom.getItems().add(shield);
        livingRoom.getItems().add(apple);

        kitchen.getItems().add(apple);
        cellar.getItems().add(apple);
        storeroom.getItems().add(apple);
        library.getItems().add(apple);
        lavatory.getItems().add(apple);
        corridor.getItems().add(apple);
        livingroom2.getItems().add(apple);
        lab.getItems().add(apple);
        office.getItems().add(apple);
        corridor2.getItems().add(apple);
        room.getItems().add(apple);
        room2.getItems().add(apple);
        room3.getItems().add(apple);


        // initialise room exits
        hall.setExit("east", livingRoom);
        hall.setExit("south", lavatory);
        hall.setExit("north", office);
        livingRoom.setExit("west", hall);
        office.setExit("south", hall);
        lavatory.setExit("north", hall);
        livingRoom.setExit("north", library);
        library.setExit("south", livingRoom);
        livingRoom.setExit("east", dinnerRoom);
        dinnerRoom.setExit("west", livingRoom);
        dinnerRoom.setExit("east", kitchen);
        kitchen.setExit("west", dinnerRoom);
        kitchen.setExit("north", storeroom);
        storeroom.setExit("south", kitchen);
        kitchen.setExit("south", cellar);
        cellar.setExit("north", kitchen);
        livingRoom.setExit("south", corridor);
        corridor.setExit("north", livingRoom);
        livingroom2.setExit("north", corridor);
        corridor.setExit("south", livingroom2);
        livingroom2.setExit("south", corridor2);
        livingroom2.setExit("east", lab);
        lab.setExit("west", livingroom2);
        corridor2.setExit("north", livingroom2);
        corridor2.setExit("south", room);
        corridor2.setExit("east", room2);
        corridor2.setExit("west", room3);
        room.setExit("north", corridor2);
        room2.setExit("west", corridor2);
        room3.setExit("east", corridor2);


        currentRoom = hall;  // start game outside

        //initialise room enemies
        hall.getEnemies().add(Mob1);
        office.getEnemies().add(Mob1);
        lavatory.getEnemies().add(Mob1);
        cellar.getEnemies().add(Mob1);
        kitchen.getEnemies().add(Mob1);
        livingRoom.getEnemies().add(Mob1);
        livingRoom.getEnemies().add(Mob2);
        corridor.getEnemies().add(Mob2);
        livingroom2.getEnemies().add(Mob1);
        livingroom2.getEnemies().add(Mob2);
        corridor2.getEnemies().add(Mob2);
        library.getEnemies().add(Mob1);
        storeroom.getEnemies().add(Mob2);
        lab.getEnemies().add(Mob2);
        dinnerRoom.getEnemies().add(Mob2);
        room.getEnemies().add(Mob2);
        room2.getEnemies().add(Mob2);
        room3.getEnemies().add(Mob2);
        room.getEnemies().add(Mob1);
        room2.getEnemies().add(Mob1);
        room3.getEnemies().add(Mob1);
        room.getEnemies().add(MobSh);
        room2.getEnemies().add(MobSw);
        room3.getEnemies().add(boss);

        //Set Enemies items
        Mob1.setDroppableItem(apple);
        Mob2.setDroppableItem(hpPot);
        MobSh.setDroppableItem(shieldM);
        MobSw.setDroppableItem(swordM);
        boss.setDroppableWeapon(excalibur);
    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the New World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
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
                this.currentRoom.look(command.getSecondWord());
                break;
            case CommandWords.SHOW:
                this.player.show(command.getSecondWord());
                break;
            case CommandWords.COLLECT:
                collectItem(command);
                break;
            case CommandWords.PURGE:
                this.player
                        .getInventory()
                        .removeItem(command.getSecondWord());
                break;
            case CommandWords.USE:
                this.player.useItem(command.getSecondWord());
                break;
            case CommandWords.EQUIP:
                this.player.equipItem(command.getSecondWord());
                break;
            case CommandWords.ATTACK:
                attack(command.getSecondWord());
                break;
            default:
                break;
        }

        return wantToQuit;
    }

    /**
     * Explain the game scenario and Print the commands that can be used.
     */
    private void printHelp(Command command) {
        if (command.getSecondWord() == null) {
            System.out.println("You are in a haunted mansion in search of adventure.");
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
     *
     * @param command Command containing the direction the player wants to go
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * Try to collect an item in the room.
     * If you can not, tell them that does not have the item in the room.
     *
     * @param command Command containing the item to be collected
     */
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
        for (InventoryItem i : currentRoom.getItems()) {
            if (i.getName().equals(item)) {
                if (player.getInventory().addItem(i)) {
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

    /**
     * Try to attack an enemy in the room
     * If you can not, tell them that does not have the enemy in the room.
     *
     * @param enemyName Name of the enemy to be attacked
     */
    private void attack(String enemyName) {
        if (enemyName == null) {
            System.out.println("You need to provide a enemy name");
            return;
        }

        Enemy enemy = currentRoom.findEnemy(enemyName);
        if (enemy == null) {
            System.out.printf("The enemy '%s' is not in the current room.%n", enemyName);
            return;
        }

        player.battle(enemy);

        if (player.isDead()) {
            if (player.getInventory().contains("life")) {
                player.useItem("life");
                System.out.println("You died! But don't worry, your life was restored because you had a Life in your inventory!");
            } else {
                System.out.println("You're dead!");
                System.out.println(" --- GAME OVER ---");
                return;
            }
        }

        if (enemy.isDead()) {
            System.out.printf("You've killed %s and gained %d XP and %d coins!%n", enemy.getName(),
                    enemy.getXPReward(),
                    enemy.getCoinReward());

            currentRoom.getEnemies().remove(enemy);

            ((CoinBag)this.player.getInventory().getItem(InventoryItem.COIN_BAG)).addCoins(enemy.getCoinReward()); // Adds coins as reward for the player
            this.player.addXP(enemy.getXPReward()); // Adds XP as reward for the player

            boolean hasDropped = false;

            if (enemy.getClass().getSimpleName().equals("Boss")) {
                if (((Boss) enemy).hasDroppableWeapon()) {
                    currentRoom.getItems().add(((Boss) enemy).getDroppableWeapon());
                    hasDropped = true;
                }

                if (((Boss) enemy).hasDroppableLife()) {
                    currentRoom.getItems().add(((Boss) enemy).getDroppableLife());
                    hasDropped = true;
                }


            }

            if (enemy.hasDroppableItem()) {
                this.currentRoom.getItems().add(enemy.getDroppableItem());
                hasDropped = true;
            }

            if (hasDropped)
                System.out.printf("%s dropped an item, look around in the room and see if you can find it!%n",
                        enemy.getName());
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}
