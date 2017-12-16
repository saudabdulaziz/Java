/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes and Saud Aljandal
 * @version 2017.07.15
 */

import java.util.HashMap;
import java.util.Set;

public class Room 
{

    private String description;
    private HashMap<String, Room> exits;
   // private Item roomItem;//EX 6.20 private field for item description.
    private Item item;//EX 6.20  Reference for the class Item to bring the info.
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * EX 6.20    
     * MODIFICATION:
     * @param description The room's description. & String itemDescriotion, int itemWeight
     * Also, initializing an item information field. 
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
   //     roomItem = new Item(itemDescription, itemWeight);
    }

    /**
    * Add an item to this room
    *EX 6.20
    */
    public void setItem(Item item)
    {
        this.item = item;
    }
    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor); 
    }

    /**
     * return the available exit by the typed direction.
     * @param direction
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /** 
     * Return a description of the room’s exits,
     * for example, "Exits: north west". 
     * @return A description of the available exits.
     * 
     */ 
    public String getExitString()
    {
        String exitString = "Directions of where you can go:";
        Set<String> keys = exits.keySet(); 
        for(String exit : keys) { 
            exitString += " " + exit; 
        }
        return exitString;
    }

    /**
     *  Return a long description of this room, of the form: 
     *  You are in the looby.
     *  Directions of where you can go: east west north south
     *   @return A description of the room, including exits.
     *   EX 6.20: editing the print statement so it contains the item information and weight.
     *   
     */   

    public String getLongDescription() {
        String descrip = "You are " + description + ".\n";
        if(item != null) {
            descrip += "this area has" + item.getItemInformation() + ".\n";
        }
        return descrip + getExitString();
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
}

