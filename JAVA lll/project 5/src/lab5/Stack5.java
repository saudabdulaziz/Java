package lab5;
/*
 * Saud Aljandal
 * lab5
 * cs258
 * 
 */
import java.util.EmptyStackException;
public class Stack5<D>
{    
   class Node {
       D data;
       private Node next;
        
       private Node (D value, Node link) {  
    	   this.data = value;
    	   next = link;
       }
   }
   private static final boolean bool = false;
   protected Node top;
 
   /**
    * Create a new Stack
    */
   public Stack5() {
        top = null;
   }
   /**
    * push a node onto the stack
    * @param value - the node
    */
   public void push(D value) {
        Node newNode = new Node(value, top);
        newNode.next = top;
        top = newNode;
   }
   /**
    * pop the top node from the stack
    * @return - the top node
    * @throws EmptyStackException if the stack is empty
    */
   public D pop () throws EmptyStackException {
          D data = peek();
          top = top.next;
          return data;
   }
   /**
    * return the top node without removing it from the stack
    * @return - the top node
    * @throws EmptyStackException if the stack isEmpty
    */
   public D peek() throws EmptyStackException {
	   if(isEmpty()) 
		   throw new EmptyStackException();
	   return top.data;
   }
   /**
    * @return - true if the stack is empty, else false
    */
   public boolean isEmpty() {
          return top == null;
   }
   /**
    * @return - a String representing all the items in the stack in order from top to bottom
    * separated by " ; "
    */
   public String toString() {
	   String s = top.data + " ; ";
          return s;
   }
public static boolean isBool() {
	return bool;
	}
} 

