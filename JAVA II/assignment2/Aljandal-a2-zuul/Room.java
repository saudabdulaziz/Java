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
 * @version 2017.07.10
 */

import java.util.HashMap;
import java.util.Set;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Room northExit;//all 4 should be deleted after 6.8
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * MODIFICATION:
     * EX 6.8 new hashmap has been initialized
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     * MODIFICATIONS:
     * EX 6.8 the if statements have been modified for the hashmap. 
     * we added the hashmap 'put' method. 
     * the method has been entirely changed to be suitable with hashmap.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor); 
    }

    /**
     * EX 6.6 getExit method has been added.
     * return the available exit by the typed direction.
     * @param direction.
     * MODIFICATIONS:
     * the exits directions old code block has been replaced with the hashmap method 'get'
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /** 
     * EX 6.7
     * Return a description of the room’s exits,
     * for example, "Exits: north west". 
     * @return A description of the available exits.
     * MODIFICATIONS:
     * EX 6.11
     * the method has been modified to set the exits direction inside a set to make it 
     * easier if we want to add new directions.
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
     * EX 6.11
     * * Return a long description of this room, of the form: 
     *  You are in the looby.
     *  Directions of where you can go: east west north south
     *   @return A description of the room, including exits.
     */   

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    // /**
    // *FOR GRADING
    // * EX 6.6
    // * return the available exit by the typed direction.
    // * @param direction.
    // */
    // public Room getExit(String direction)
    // {
    // if(direction.equals("north")){
    // return northExit;
    // }
    // if(direction.equals("east")){
    // return eastExit;
    // }
    // if(direction.equals("south")){
    // return southExit;
    // }
    // if(direction.equals("west")){
    // return westExit;
    // }
    // return null;
    // }

    // /**
    // *FOR GRADING
    // * EX 6.7
    // * Return a description of the room’s exits,
    // * for example, "Exits: north west". 
    // * @return A description of the available exits.
    // */ 
    // public Room getExitString()
    // {
    // String exitString = "Directions of where you can go: ";
    // if(northExit != null){
    // exitString += "north ";
    // }
    // if(eastExit != null){
    // exitString += "east ";
    // }
    // if(southExit != null){
    // exitString += "south ";
    // }
    // if(westExit != null){
    // exitString += "west ";
    // }
    // System.out.println(exitString);
    // return null;
    // }
}
