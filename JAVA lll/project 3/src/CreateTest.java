/**
 * Saud Aljandal
 * lab3
 * 
 * 
 * Now write a program (CreateTest.java) that constructs the answer key for a true/false test. This program must:
·       Ask the user for the name of the question file,
·       Read this file and ask the user each question and record the resulting answers in a bit map object. (Instantiate a BufferedReader and read lines from the text file until you encounter a null line.)
·       Use an ObjectOutputStream to write the BitMap object to a sequential binary file.
·       The name of this file must be the same as the base name of the question file + and have the extension “.key”.
 */


import java.io.*;
import java.util.Scanner;

public class CreateTest implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Scanner input = new Scanner(System.in);
	private static String fileName;
	private static String bitString;
	private static boolean readMore = true;
	static BufferedReader in;
	
	
	
	public static void main(String[] args) {
		System.out.println("What is the questions file name?  HINT :Questions : ");
		fileName = input.nextLine();
		getReadConnection(fileName);
		while (readMore){
			getQuestion();
			if (readMore)
				getAnswer();
		}
		writeObject();
	}
	public static void writeObject() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(fileName + ".key")));
			BitMap bitMap = new BitMap(bitString);
			os.writeObject(bitMap);
			os.flush();
			os.close();
			System.out.println("Answres now in " + fileName + ".key");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getReadConnection(String fileName){
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void getQuestion(){
		try {
			String line = in.readLine();
			if (line!=null){
				System.out.println(line);
				System.out.println("type t or f");
			}else {
			//	System.out.println("Done!");
				readMore = false;
			}
		}catch(Exception e){
			readMore = false;
		}
	}
	
	// for ts and fs
	public static void getAnswer() {
		String ans;
		//for first char
		if (bitString == null){
			ans = input.nextLine();
			if (ans.indexOf('t')==0) {
				bitString = "t";}
			else if (ans.indexOf('f')==0) {
				bitString = "f";}
			else {
				System.out.println("Illegal entry. type t for yes or f for no");
				getAnswer();
			}
			
		}else {
			ans = input.nextLine();
			if (ans.indexOf('t')==0) {
				bitString = bitString + "t";}
			else if (ans.indexOf('f')==0) {
				bitString = bitString + "f";}
			else {
				System.out.println("Illegal entry. type t for yes or f for no");
				getAnswer();
			}
		}
	}
}
