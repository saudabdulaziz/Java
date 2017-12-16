/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modifications:
 * Author: Aljandal, Saud. 4/19/2017
 * the original constructor has been modified
 * added TicketMachine constructor
 * added getTotal method
 * added prompt method
 * added setPrice method
 * added showPrice method
 * added getTotal method
 * added empty method
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

   
    /**
    * Name: TicketMachine()
    * Description: the parameter has been removed. Also, a fixed number has been set in the price field.
    */
    public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
    }
    
     /**
     * Ex. 2.44
     * Name: TicketMachine(int newPrice)
     * Description: a constructor that takes an int arqument and change the value of the variable 'price' to what that argument int is.
     */
    public TicketMachine(int newPrice)
    {
        price = newPrice;
    }

    /**
     * Ex 2.37
     * Name: prompt()
     * Description:prompt the user to insert an amount of money.
     */
    public void prompt()
    {
        System.out.println("Please insert the correct amount of money.");
    }
    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }
     /**
     * Ex 2.32
     * Description: Assign the cost of the ticket to the field "price".
     */
    public void setPrice(int cost)
    {   
        price = cost;
    }
    /**
     * Ex 2.41
     * Name: showPrice()
     * Description: print the value in the price field.
     */
    public void showPrice()
    {
        System.out.println("The price of a ticket is " + price + " cents.");
    }
    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }
     /**
     * Ex. 2.26
     * Name: getTotal
     * Description: Return the total amount of money already inserted.
     */
    public int getTotal()
    {
        return total + balance;
    }
    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        // Update the total collected with the balance.
        total = total + balance;

        // Clear the balance.
        balance = 0;
    }
     /**
     * Ex. 2.45
     * Name: empty
     * Description: removing all money from the machine by assigning the field 'total' to zero.
     */
    public void empty()
    {
        total = 0;
    }

}
