/**
 * Saud Aljandal
 * lab2
 */
// This program writes different types of files.
//    Random, Binary, and Text.
// Created 3/29/2004 for the lab 2 cs258 project.
 
import java.io.*;
import java.security.*;
 
public class Writers {  
    private final static int NAME_SIZE  = 30;
    private final static String spaces  = "                              ";
 
    // Keyboard input stream.
    private final static BufferedReader in =
        new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String args[]) {
        // variables needed for Files.
        Writer out = null;
        String fileType = null, fileName = null;
 
        // variables needed for data.
        String  name;
        int     age;
        double  salary;
        String  doMore;
        boolean quit, moreFiles;
 
        System.out.println("File writer program");
        do { 
            try {
                do {
                    System.out.print("Enter file type (text, binary, random): ");
                    fileType = in.readLine().toLowerCase();
                } while ( !("text".startsWith(fileType) ||
                          "binary".startsWith(fileType) ||
                          "random".startsWith(fileType)));
 
                System.out.print("Enter the file name: ");
                fileName = in.readLine().toLowerCase();
                switch (fileType.charAt(0)) {
                    case 't':
                        out = new Text(fileName);
                        break;
                    case 'b':
                        out = new Binary(fileName);
                        break;
                    case 'r':
                        out = new Random(fileName);
                        break;
                    default:
                        throw new InvalidParameterException();
                }
 
                do { 
                    System.out.print("Enter Name: ");
                    name = in.readLine() + spaces;
                    name = name.substring(0,NAME_SIZE);
 
                    age  = getAge();
                    salary = getSalary();
                    out.write(name, age, salary);
 
                    System.out.println("\n Type 'quit' to exit: ");
 
                    doMore = in.readLine().toLowerCase();
                    quit = (doMore.length()>0 && "quit".startsWith(doMore));
                }  while (!quit);
            }
            catch (InvalidParameterException e) {
                System.out.println("Unknown case");
                System.exit(1);
            }
            catch (IOException e) {
                System.out.println("I/O Error");
            }
            catch (Exception e) {
                System.out.println("Illegal Entry");
            }
            finally {
                try {
                    out.close();
                }
                catch(Exception e) {}
            }
            System.out.println("Another file? (y/n) ");
 
            try {
                doMore = in.readLine().toLowerCase();
                moreFiles = (doMore.length()>0 && "yes".startsWith(doMore));
            }
            catch (Exception e) {
                moreFiles = false;
            }
        }  while (moreFiles);
 
        System.out.println("File write complete; data is in "+fileName+"\n");
    }   // End void main()
 
    // Method to input an age.
    private static int getAge() {
        int age = -1;
        String inputString = null;
 
        do {
            try {
                System.out.print("Enter Age: ");
                inputString = in.readLine();
                age = Integer.parseInt(inputString);
                if (age<0 || age>100)
                    throw new Exception();
                return age;
            }
            catch (Exception e) {
                System.out.println("Illegal age, try again");
            }
        }  while (true);
    }
 
    // Method to input a salary.
    private static double getSalary() {
        double salary = -1;
        String inputString = null;
 
        do {
            try {
                System.out.print("Enter Salary: ");
                inputString = in.readLine();
                salary = Double.parseDouble(inputString);
                if (salary<0 || salary>1000000)
                    throw new Exception();
                return salary;
            }
            catch (Exception e) {
                System.out.println("Illegal salary, try again");
            }
        }  while (true);
    }
}
    /**
     * fill in the code for the three classes (Random, Binary, and Text)
     *In each class, you will need a constructor, a write method, and a close method.
     *The constructor opens the file, the write method writes a record, and the close method closes the file.
     */
    /**
     * this class will have a constructor to open the file
     * a method named "write" to write a record. for this method,
     * we have to write a String "name" and an integer "age" and a double "salary"
     * Close method to close the file
     *   
     * @author saud
     *
     */
    abstract class Writer{
    	//will throw an IOException in case of  failure or interrupted I/O operations.
    	public abstract void write(String name, int age, double salary)
    			throws IOException;
    	public abstract void close();
    	}
//-------------------------------------------------------------------------------------
    //random class with its methods
    	class Random extends Writer{
    		RandomAccessFile out;
    	public Random(String fileName)
    			throws FileNotFoundException{
    		//from week02 PP
    		//RandomAccessFile raf = new RandomAccessFile(“path”,”access”);
    		//If “rw” or “w” and the file doesn’t exist, it will be created.
    		out = new RandomAccessFile(fileName,"rw");
    	}
		public void write(String name, int age, double salary)
				throws IOException {
		//need to write:
			
			out.writeUTF(name);
			out.writeInt(age);
			out.writeDouble(salary);
			//out.writeUTF(combined);
		}
		public void close(){
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	}
    	//Binary class with its methods
    	class Binary extends Writer{
    		DataOutputStream out;
    		
    	public Binary(String fileName)
    			throws IOException{
    		//from week02 PP
    		//DataOutputStream out=new DataOutputStream(new
    		//FileOutputStream(“path”));
    		out = new DataOutputStream(new FileOutputStream(fileName));
    	}
		public void write(String name, int age, double salary) 
				throws IOException {
			// will use UTF 
			out.writeUTF(name);
			out.writeInt(age);
			out.writeDouble(salary);
			out.flush();
		}
		public void close(){
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
   }

    	class Text extends Writer{
    		PrintWriter out;
    		
    	public Text(String fileName) 
    			throws IOException
    	{	
    		out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

    	}
    	public void write(String name, int age, double salary) throws IOException {
    		
    		
    		
    		String combined = name +"\f"+ age +"\f" +salary;
    		out.println(combined);
			out.flush();

		}
		public void close()
		{
			out.close();
	}
}