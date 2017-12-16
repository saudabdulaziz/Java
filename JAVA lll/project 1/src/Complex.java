
/**
 * @author Saud Aljandal
 * @date 10/2/2017
 * lab#1
 */


public class Complex
{  private double real, imaginary;
	
	
 
   public Complex(){
	   //we need to set real and imaginary to zero.
	   //The constructor with no parameters should set the real and imaginary instance variables to zero
	   this.real = 0;
	   this.imaginary = 0;
   }
   public Complex(double real, double imaginary) {
       // if either real or imaginary is "NaN",
       // the respective value should be set to zero
       // See the Double class for a helpful method to
        // determine whether a double is a "NaN"

	   this.real = real;
	   this.imaginary = imaginary;
   }
 
   public String toString(){
	   /**
	    * Your toString() method should use the most appropriate format to format strings for printing. 
	    * You should NOT print, e.g., 3.0+-4.0i or 3+0.0i or 0.0+3i or 1.0i or -1.0i or 0.0+0.0i. 
	    * 3.0+-4.0i should display as 3.0-4.0i; 3.0+0.0i should display as 3.0; 0.0+3.0i should display as 3.0i; 
	    * 1.0i should display as i; -1.0i should display as –i; 0.0+0.0i should display as 0.0.
	    */
	   
	   // we need to set default vars to get prepared to the output.
	   
	   // as specified, we can only use the legal format a+bi. so we need to assume that "+" is already exist.
	    String legalOperator = "+";
	    //also, put "i" in the end of the output. 
		String i="i";
		// string our integers so we can manipulate with them.
		
		String realString= String.valueOf(real);
		String imaginaryString= String.valueOf(imaginary);
		
		//if both of them are zeros. they should be displayed as 0.0
		if (real == 0 && imaginary ==0){
			realString="0.0";
			legalOperator="";
			imaginaryString="";
			i="";}
		// if only real number is zero
		if (real == 0 && imaginary != 0){
			legalOperator = "";
			realString= "" ;}
		// if only the imaginary number is zero
		if (imaginary == 0 && real != 0){
			legalOperator = "";
			imaginaryString = "";
			i="";}
		// if imaginary is -1 and real is zero
		if (imaginary == -1 && real==0){legalOperator = "" ; imaginaryString = "-" ; realString = "" ;
		}
		// if imaginary is 1 and real is zero
		if (imaginary == 1 && real == 0){legalOperator = "" ; imaginaryString = "" ; realString = "" ;	
		}
		
		//the format should be displayed as:
		return realString+legalOperator+imaginaryString+i;
	}
   public Complex add( Complex c)
   {  return new Complex
           (real+c.real, imaginary+c.imaginary);
   }
   public Complex minus(Complex c) {
	   return new Complex
	           (real-c.real, imaginary-c.imaginary);
   }
   public Complex product(Complex c) {
	   return new Complex
		// using the exact steps in the specification page we write is as follows:
		(((real * c.real) - (imaginary * c.imaginary)),((real * c.imaginary) + (imaginary * c.real)));
   }
   public Complex div(Complex c) throws IllegalArgumentException {
        // throws IllegalArgumentException if both real and
        // imaginary parts of c == 0
	   
	   
	   //First we need to define the term: a complex number conjugate.
	   //Changing the sign of the imaginary portion by multiplying it by -1.
	    Complex conjudgete = new Complex(c.real, c.imaginary * -1);
	    
	    
	    //need to make numerator and denominator for both real and imaginary portions.
	    //for real:
	    double realNumerator = real * c.real + -1 * imaginary*conjudgete.imaginary;
	    double realDenominator = c.real * c.real + -1 * c.imaginary * conjudgete.imaginary;
	    //for imaginary:
	    double imaginaryNumerator = imaginary * c.real + real * conjudgete.imaginary;
	    double imaginaryDenominator = c.imaginary * c.real + c.real * conjudgete.imaginary;

	    
	    //check if they both equal to zero and throw an exception:
	    	if (realDenominator + imaginaryDenominator == 0)
	    		throw new IllegalArgumentException();
	    real = realNumerator /(realDenominator + imaginaryDenominator);
	    imaginary = imaginaryNumerator /(realDenominator + imaginaryNumerator);

	    return (new Complex(real,imaginary));
	  
   }
   public static Complex parseComplex(String str)
                    throws NumberFormatException {

		//using the split method to separate the real from imaginary.
		String[] splitter = str.split("(?=[+-])");//either + or -
		//using again the split method to get rid of "i" is the end of the splitter[1].
		String splitter2 = splitter[1].substring(0, splitter[1].length()-1);
		//prepare the numbers by parsing them.
		double fixedReal = Double.parseDouble(splitter[0]);
		double fixedImaginary = Double.parseDouble(splitter2.toString());
	   	   

		return new Complex(fixedReal,fixedImaginary);
	   }               
}

