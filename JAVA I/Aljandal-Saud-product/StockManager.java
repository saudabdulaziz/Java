import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Saud Aljandl) 
 * @version (May/29/2017)
 * modifications:
 * method printProductDetails() has been fixed with the requirements of EX. 4.56
 * method findProduct(int id) has been fixed with the requirements of EX. 4.57
 * method numberInStock(int id) has been fixed with the requirements of EX. 4.58
 * method delivery(int id, int amount) has been fixed with the requirements of EX. 4.59
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * EX. 4.59
     * modifications: if statements has been added to satisfy the requirment.
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product p = findProduct(id);
        if( p!=null)
        {
            p.increaseQuantity(amount);
        }
    }

    /**
     * EX. 4.57
     * modifications: for each loop has been added to satisfy the requirment.
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product p : stock){
            if (p.getID() == id)
            {
                return p;
            }
        }
        return null;
    }

    /**
     * EX. 5.58
     * modifications: if statement has been added to satisfy the requirment below.
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product p = findProduct(id);
        if(p != null)
        {return p.getQuantity();
        }
        return 0;
    }

    /**
     * EX.56
     * modifications: for each loop has been added to satisfy the requirment below.
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product p : stock){
            System.out.println(p.toString());
        }
    }
}
