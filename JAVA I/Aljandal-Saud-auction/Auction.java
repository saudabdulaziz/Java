import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 *  Modifications:
 * Author: Aljandal, Saud 5/17/2017.
 * method getUnsold() has been added.EX. 4.49
 * method getLot() has been modified. EX. 4.51
 * method close() has been added. EX.4.48
 * method removeLot(int number) has been added.  EX. 4.52
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * EX. 4.49
     * Name: getUnsold
     * Description: Returning a list containing the unsold lots.
     */
    public ArrayList<Lot> getUnsold()
    {
        ArrayList<Lot> unsoldLots = new ArrayList<Lot>();
        for(Lot lot : lots){
            Bid bid = lot.getHighestBid();
            if(bid == null){
                unsoldLots.add(lot);
            }
        }
        return unsoldLots;// return the list!
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     * MODIFICATIONS: EX. 4.47 got solved by making an anonymous object.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {

            boolean successful = selectedLot.bidFor(new Bid(bidder, value));//anonymous object
            if(successful) {
                System.out.println("The bid for lot number " +
                    lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                    " already has a bid of: " +
                    highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     * 
     * EX 4.51
     * Description: rewriting the method so that it does not rely on a lot with a number being stored at 
     * index(number - 1) in the collection. Will be rewritten by using for-each loop.
     */
    public Lot getLot(int lotNumber)
    {
        for( Lot selectedLot : lots){
            if(selectedLot.getNumber() == lotNumber)
            {
                return selectedLot;
            }
        }
        System.out.println("Lot number: " + lotNumber +" does not exist.");
        return null;
    }

    /**
     * EX.4.48
     * Name: close
     * Description: method will iterate over the collection of lots and
     * will print out details of all the lots incloding names & the values of the bids.
     * Also, will report the lots with no biddrs
     */
    public void close()
    {
        Bid bid;
        Person person;
        for(Lot lot : lots)
        {
            bid = lot.getHighestBid();
            if(bid != null){// for sold items
                person= bid.getBidder();
                System.out.println(lot.getNumber()+"- "+lot.getDescription()+" was sold for "+
                    bid.getValue()+" to the bidder " + person.getName()+".");
            }else{ // for unsold items
                System.out.print(lot.getNumber() +"- "+lot.getDescription() + " is not sold. \n");
            }
        }
    }

    /**
     * EX 4.52
     * Name: removeLot
     * Description: Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    public Lot removeLot(int number)
    {
        Lot l= getLot(number);// I used the method getLot() and it will handle the most. even the null return in case of not sinding the number!
        
        if(l != null){
                lots.remove(l);
            }
            return l;
        }
}
