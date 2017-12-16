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
 * @author  Michael Kölling and David J. Barnes & Saud Aljandal
 * @version 2017.07.15
 * MODIFICATIONS:
 * the new scenario is that the game starts in a hotel lobby, and the user mession is to explore what is in the hotel!
 * it has 6 rooms + the main looby. The rooms are Desk, valet parking, lounge, swimming pool, vending machine room, and the hotel suites hall. 
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * MODIFICATIONS:
     * old rooms has been deleted and new rooms has been added.
     * I have followed the same linking code but changing in rooms names
     */
    private void createRooms()
    {
        Room looby, valetParking, lounge, swimmingPool, vendingRoom, floorRooms, desk;

        // create the rooms
        looby = new Room("in the main looby of the hotel");
        valetParking = new Room("in the valet parking. your car should be here in a moment");
        lounge = new Room("in the lounge area, please have a fresh juice");
        swimmingPool = new Room("in the swimming pool area. We have professional swimming trainers");
        vendingRoom = new Room("in the vending machine room area, where the fresh\njuice and free ice are located");
        floorRooms = new Room("in the first floor hall, where the hotel rooms are!");
        desk = new Room("in the desk room, where the check-in and check-out process is");

        // initialise room exits

        //for valet parking
        looby.setExit("west", valetParking);
        valetParking.setExit("east", looby);

        // for desk room
        looby.setExit("north", desk);
        desk.setExit("south", looby);

        // for lounge and swimming pool 
        looby.setExit("south", lounge);
        lounge.setExit("north", looby);
        lounge.setExit("east", swimmingPool);
        swimmingPool.setExit("west", lounge);

        // for vending room and floor room
        looby.setExit("east", vendingRoom);
        vendingRoom.setExit("west", looby);
        vendingRoom.setExit("east", floorRooms);
        floorRooms.setExit("west", vendingRoom);
        
        
        // create items and weight to the rooms
        Item vase;
        vase = new Item("a beautiful historical vase", 500);
        looby.setItem(vase);
        //==================== for next assignment =================================-----------------------------
        /**
         * ,"a long sofa",300
         * ,"a key box",20
         * "a tanning table",200
         * ,"an ice container ",20
         * ,"a king bed",300
         * ,"a Booking desk",300
         */

        currentRoom = looby;  // start game in the looby.
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
        System.out.println("Thank you for visiting our hotel. Have a great day.");
    }

    /**
     * Print out the opening message for the player.
     *   MODIFICATIONS:
     *  the welcome message has been changed to match my scenario.
     *  Zuul"2": printing location block of code has beeen eleminated and 
     *  replaced with a call code for the new method printLocationInfo().
     */
    private void printWelcome()
    {
        System.out.println("Welcome to our hotel. This is the place where you have a pleasent time.\nPlease make yourself comfortable and walk around to see our hotel.");
        System.out.println("How to explore our hotel? Simply, type the word 'go' followed by a direction word. East, west, north or south.\nAlso, type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     * #MODIFICATIONS:
     * EX 6.14 & EX 6.15: Adding command words "look" & "luggage" to be recognized.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Sorry, we did not understand what you typed, could you please type again?");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }        
        else if (commandWord.equals("look")) {
            look();
        }
        else if (commandWord.equals("luggage")) {
            luggage();
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     * Ex 6.16 MODOFYING the output for the help command so it brings all the command
     * words whith out any future update.
     * EX 6.18: Modifying the output method for the list
     * of the command words to match the other changes in other classes
     */
    private void printHelp() 
    {
        System.out.println("In our hotel, we use the global directions, north, east, west, south.\nPlease type the word 'go' plus the right direction."+
            "Now, you are " + currentRoom.getDescription());
        System.out.println();
        System.out.println("Your command words are:");
        String cmdList = parser.showCommands();
        System.out.println(cmdList);
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
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
            System.out.println("Sorry, but the wanted direction is not available right now. please type another direction");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * the "getExistString()" has been replaced with the new method "getLongDescription()"
     */
    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription()); 
    }

    /**
     * EX 6.14: Adding the method look
     * 
     */
    private void look() 
    {    
        System.out.println(currentRoom.getLongDescription()); 
    } 

    /**
     * EX 6.15: Adding the method luggege
     * printing a mesaage to the user that the luggege will be
     * brought to him/her when he/she booked a room.
     */
    private void luggage()
    {
        System.out.println("Your luggage will be brought to your room  immediately after you decided to book in our hotel");
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
