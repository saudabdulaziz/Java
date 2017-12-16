/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes and Saud Aljandal
 * @version 2017.07.15
 */

/**
 * EX 6.14 & EX 6.15: Adding command words "look" & "luggage" to the list of 
 * legal commands words.
 * 
 */
public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
            "go", "quit", "help", "look", "luggage"
        };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * EX 6.16:
     * Print all valid commands to System.out.
     * EX 6.18:
     * change the method name to getCommandList and changing the code so it will return the list
     * of command words instead of printing them.
     */ 
    public String getCommandList() {
        String commandList = ""; //empty string to be filled from the following loop!
        for( String  i : validCommands){
            commandList = commandList + i + " ";
        }
        return commandList;
    } 

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
