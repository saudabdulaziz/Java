 
// Program to add and multiply complex numbers.
// Lab #1 for cs258; uses a class that handles complex numbers (Complex.java).
 
import java.io.*;
 
public class Calculator
{  public static void main(String[] args)
   {  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
      Complex num1, num2, result = new Complex();
      char    op;
      boolean more;
 
      System.out.println("\nComplex number calculation program\n");
      do
      {  num1 = readComplex(in);
         num2 = readComplex(in);
         
         //for division, put try catch to throw the exception
         try{
         op   = readChar(in, "Enter the operation '+, -, *, or /': ", "+-*/");
         switch (op)
         {  case '+':  result = num1.add(num2);
                       break;
            case '*':  result = num1.product(num2);
                       break;
            case '/':  result = num1.div(num2);
                       break;
            case '-':  result = num1.minus(num2);                      
         }
         System.out.println(num1+" "+op+" "+num2+" = "+result);}
         catch (IllegalArgumentException e){
             System.out.println("illegal operation - cannot divide bu zero.");
         }
         more = (readChar(in, "Perform another calculation? (y/n): ", "yn") !='n');
                 
      } while (more);
           
      System.out.println("\n\nCalculation program completed\n");
   }
     
   // Method to read a complex number
   public static Complex readComplex(BufferedReader in)
   {  
     String line;

      while (true)
      {     System.out.print("Enter a complex number: ");   
            try 
            {  line = in.readLine();
               return Complex.parseComplex (line);  
            } 
            catch (Exception exception) 
            {  System.out.println("illegal Format - enter 'a+bi' and try again");  }
      }

   }
     
   // Method to read the first character of a string
   public static char readChar(BufferedReader in, String prompt, String chars)
   {
      String line;
      char   value;
      
      while (true)
      {  try
         {  System.out.print(prompt);
            line = in.readLine();
            value = line.toLowerCase().charAt(0);
            if (chars.indexOf(value)<0) throw new NumberFormatException();
            return value;
         }
         catch (Exception exception) 
         { System.out.println("Illegal - try again"); }
      }
   }
}
 
  