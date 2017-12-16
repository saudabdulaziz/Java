import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * 
 * * Author: Aljandal, Saud 5/14/2017.
 * method listFile(int index) has been modified by adding the method validIndex(index) in the if-statements.
 * method removeFile(int index) has been modified by adding the method validIndex(index) in the if-statements.
 * method ckeckIndex(int index) has been added
 * method validIndex(int index) has been added
 * method listAllFiles() has been added
 * method listMatching(String searchString) has been added
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     * ckecks from the method validIndex(). If True is returned, we should get the list.
     * If false is returned from validIndex(), nothing should change.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     * ckecks from the method validIndex(). If True is returned, it should remove the item from the list.
     * If false is returned from validIndex(), nothing should change.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }
        /**
     * EX 4.12
     * @param index The index check if it is valid and exist in the list "files".
     * if it is valid, it will print nothing.
     * if it not valid, it will print an error saying what the valid range is.
     */
    public void checkIndex(int index)
    {  
        if(files.isEmpty()) {
            System.out.println("The list is empty!");
            return;//returns nothing to avoid checking the next if statement!
        }
            
        if( index >= 0 && index < files.size() ){
            System.out.println("");
        }
        else {
            System.out.println("This is not a valid index. The valid range is: "+ files.size());
        }
    }
    /**
     * EX 4.15
     * @param index The index checks if it is valid or not.
     * boolean should be returned.
     */
    public boolean validIndex(int index)
    {
        if(index >= 0 && index < files.size()) {
            return true;
         
        }else{
            return false;
        }
    }
    
    /**
     * EX 4.20
     * printing all the files names in the collection "files" by using for statement.
     * Also, as EX 4.24 asked, the item position will be printed too.
     */
    public void listAllFiles()
    {
        int position = 0;//initializing a position number to use it in the loop.
        for(String track: files){
            System.out.println(position+": "+track);
            position++;
        }
    }
    /**
     * ِEX 4.25
     * List the names of files matching the givin search string.
     * @param searchString is the string that used to be checked inside the collection.
     */
    public void listMatching(String searchString)
    {
        for ( String i : files){
            if(i.contains(searchString)){//if True, it should be printed!
                System.out.println(i);
            }
        }
    }
}