/**
 * Saud Aljandal
 * lab3
 * 
 */
import java.io.*;
import java.util.Scanner;

public class TakeTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Scanner input = new Scanner(System.in);
	private static String fileName;
	private static String bitString;
	private static boolean readMore = true;
	static BufferedReader in;
	private static int count = 0;
	
	public static void main(String[] args) {

		System.out.println("Question file name: ");
		fileName = input.nextLine();
		getReadConnection(fileName);
		while (readMore){
			getQuestion();
			count++;
			if (readMore)
				getAnswer();
		}
		System.out.println(score());
	}
	

	@SuppressWarnings("resource")
	public static double score() {
		ObjectInputStream stream;
		try {
			stream = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(fileName+".key")));
			BitMap key = (BitMap) stream.readObject();
			//build object
			BitMap inputTest = new BitMap(bitString);
			//return grade
			return inputTest.score(key, count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace(System.err);
		}
		return 0;
	}
	
	public static void getReadConnection(String fileName){
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getQuestion(){
		try {
			String question = in.readLine();
			if (question!=null){
				System.out.println(question);
				System.out.println("type t or f");
			}else {
				System.out.println("Done. percentage of 'correct' bits in this bitmap:");
				readMore = false;
			}
		}catch(Exception e){
			System.out.println("Done!.");
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

