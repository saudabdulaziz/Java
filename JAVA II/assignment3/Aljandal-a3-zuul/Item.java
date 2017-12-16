
/**
 * This class will prepare an item description and it's weight to be returned after going to any direction in the game.
 *
 * @author (Saud Aljandal)
 * @version (2017.07.15)
 * Ex 6.20: creating a class called Item and implement methods for 
 * items which will be found in the rooms.
 * 
 * EX 6.20
 * Adding the class "Item" which describes an item + providing a weight for it.
 */
public class Item
{
    // private fields 
    private String itemDescription;
    private int itemWeight;

    /**
     * Create the item description and weight.
     */
    public Item(String itemDescription, int itemWeight)
    {
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;

    }

    /**
     * setting getter
     * Return the description and the weight fot the item
     */
    public String getItemInformation()
    {
      //  String itemInfo = "In this area, you can see " + itemDescription 
        //    + " and the weight for it is "+ itemWeight+"lb.\n";
        return itemDescription;
    }

}
