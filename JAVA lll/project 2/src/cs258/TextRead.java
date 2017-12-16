/**
 * Saud Aljandal
 * lab2
 */
package cs258;

import java.io.*;
public class TextRead extends Keyboard
{  
   public TextRead(String filename) throws FileNotFoundException {
	   this.in = new BufferedReader(new FileReader(filename));
	   String line = null;
		   try{
	   while(in.ready()){
		   line= in.readLine();
		   System.out.println(line);
	       }
	  } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	  }  
	   }	   
   
   
	   public void close() throws IOException {
	     in.close();
	   }

   
   public boolean endOfFile() {
	   
	   try {
		if(in.ready()==false){
		//	System.out.println("here");
			   return true;
		   }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      // hint: check the BufferedReader API for some helpful methods
	return false;
   }
}