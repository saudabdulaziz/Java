//import java.io.Serializable;
//
////The first step is to develop a general-purpose class that will be able to
////perform operations on strings of bits. 
//public class BitMap implements Serializable {
//	
//	// The only instance variable that is needed is bitString.
//	private long bitString;
//	// Bits in a BitMap object are numbered from 0 (least significant) to 63 (most significant)
//	public static final int LENGTH = 64;
//	//Your second and third constructors will be called with, 
//	//e.g., "ttffft" or the boolean array {true, true, false, false, false, true}
//	public BitMap() {
//		//Constructs a bitmap of all zeros
//		
//	}
//	public BitMap(String s)
//		       throws java.lang.IndexOutOfBoundsException,
//		              java.lang.NumberFormatException{
//		
//	}
//	public BitMap(boolean[] bits)
//		       throws java.lang.IndexOutOfBoundsException{
//		
//	}
//	/**
//	 * Consider making a private method in the BitMap class that returns
//	 *  a long that could be used as a mask by any method performing an operation 
//	 *  on a single bit.
//	 */
//	private long mask (int b) {
//		return b;
//	}
//	public boolean	checkBit(int b) {
//		return false;
//		
//	}
//	public void	clearAll() {
//		bitString = "";
//	}
//	public void	clearBit(int b) {
//		//Clear(set to 0) the bit at index b
//		
//	}
//	public double score(BitMap key, int valid) {
//		return valid;
//		//Calculates the percentage of 'correct' bits in this bitmap
//	}
//	public void setAll() {
//		//set all bits to 1
//	}
//	public void setBit(int b) {
//		//Set the bit at index b to 1
//	}
//	//public String toString() {
//		//for (int i = this.bitString.length()-1; i>=0; i--){
//	//	return bitString;//this.bitString.charAt(i);}
//	//}
//	
//}
import java.io.Serializable;

	public class BitMap implements  Serializable
	{   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	public static final int  LENGTH = 64;
	    private long bitString;
	 
	    public  BitMap(){ 
	   // 	clearAll();
	    }
	    public  BitMap(String s)
	    
	  throws ArithmeticException, IndexOutOfBoundsException
	  {
	    	double tr = 1;
	    	s.replaceAll("\\s+", "");
			if(s.length()>LENGTH) throw new IndexOutOfBoundsException();
			for(int i = 0; i>s.length(); i++){
				if(s.charAt(i) == 't') setBit(i);
				else if(s.charAt(i) == 'f') clearBit(i);
				else throw new ArithmeticException();
	  }
	  }
	    public  BitMap(boolean[] bits)
	  throws IndexOutOfBoundsException{
	    	this();
	    	if(bits.length > LENGTH)throw new IndexOutOfBoundsException();
			for(int i=0; i<bits.length; i++){
				if(bits[i] == true) setBit(i);
				else clearBit(i);
			}
	    }
	    public  String  toString()  {
	    	String str="";
	    
			for(int i=0; i<LENGTH; i++){
				if(mask(i) !=0)
					str += "T";
				else str += "f";
			}
			return 	new StringBuilder(str).reverse().toString();
	}
	    private long    mask(int b){
	    	return bitString & (1L << b);
	    }
	    public  void    setBit(int b){
	    	if(!checkBit(b))
				bitString =	(bitString | (1L << b));
	    }
	    public  void    clearBit(int b){
			if(checkBit(b))
				bitString = (bitString & ~ (1 << b));
	    }
	    public  boolean checkBit(int b){
	    	if((bitString & (1L << b)) !=0)
				return true;
			else return false;
	    }
		
		public double score(BitMap key, int valid){
			//variables
			int total = 0;
			int correct = 0;
			String bitS =  new StringBuilder((int) bitString).toString();
			//Loop with valid index
			for (int i = 0; i < valid; i++) {
				if (key.bitString == this.bitString){
					correct++;
					total++;
				}else{
					total++;
				}
			}
			return (((double)correct/(double)total));
		}
	    public  void    clearAll(){
			bitString = 0;
		}
	    public  void    setAll(){
			clearAll();
			for(int i=0; i<LENGTH; i++){
				setBit(i);
			}
		}


	}

