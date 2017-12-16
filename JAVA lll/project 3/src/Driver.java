// Driver program to test the BitMap class. 

import java.io.*;

public class Driver {
	static BitMap bitMap[];
	static BufferedReader in = 
			new BufferedReader (new InputStreamReader(System.in));
	 
	// Method to start the driver program. 
	public static void main(String[] args) {
		int bit, map, option;
		BitMap bitMap = new BitMap();
		
		// Use a menu to test all of the other options.
		option = menu();
		while (option != 7) {
			switch (option)	{ 
				case 0:// toString
					System.out.println(bitMap);
					break;				
				case 1: // Set bit.
					bit = getBit();
					bitMap.setBit(bit);
					System.out.println(bitMap);
					break;
				case 2: // Clear bit.
					bit = getBit();
					bitMap.clearBit(bit);
					System.out.println(bitMap);
					break;
				case 3: // Check bit.
					bit = getBit();
					if (bitMap.checkBit(bit)) 
						System.out.println("Bit "+bit+" is set");
					else 
						System.out.println("Bit "+bit+" is not set");
					System.out.println(bitMap);
					break;
				case 4:// Clear all bits.
					bitMap.clearAll();
					System.out.println(bitMap);
					break;
				case 5:// Set all bits.
					bitMap.setAll();
					System.out.println(bitMap);
					break;
				case 6:// Score a BM
					System.out.println("Enter the user's answers:");
					BitMap ans = getMap();
					System.out.println("Enter the number of valid bits in key: ");
					int valid = readInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
					System.out.println(ans.score(bitMap, valid));
					break;
				default: 
					System.out.println("Illegal Option - try again");
					break;
			}
			option = menu();
		}
		System.out.println("End of Driver for BitMap");
	}// End main.
	
	// Method to display menu and get selection.
	public static int menu() {
		System.out.println("Menu of driver options");
		System.out.println(" 0 = toString");
		System.out.println(" 1 = setBit");
		System.out.println(" 2 = clearBit");
		System.out.println(" 3 = checkBit");
		System.out.println(" 4 = clearAll");
		System.out.println(" 5 = setAll");
		System.out.println(" 6 = score");
		System.out.println(" 7 = exit");
		System.out.print("Enter option: ");
		return readInt(0,7);
	}// End menu().
	
	// Method to accept a bit number.
	public static int getBit() {
		int bit;
		System.out.print("Enter bit number: ");
		bit = readInt(0,BitMap.LENGTH-1);
		return bit;
	}// End getBit().
	
	// Method to instantiate either a boolean or string bit map.
	public static BitMap getMap() {
		boolean success = false;
		BitMap bitMap= null;
		do {
			try	{
				System.out.println("Enter string of 't','T','f', or 'F' MSB to LSB > ");
				String values = in.readLine().trim().toLowerCase();
				
				System.out.println(
						"Enter 'b' or 'B' for Boolean map, anything else for string map > ");
				String type = in.readLine().trim().toLowerCase();
				
				if (type.length()!=0 && type.charAt(0)=='b') {
					boolean bools[] = new boolean[values.length()];
					for (int i=0; i<values.length(); i++) {
						// leftmost char in s is the MSB value
						if(Character.toLowerCase(values.charAt(i))=='t')
							bools[values.length()-(i+1)] = true;
					}
					bitMap = new BitMap(bools);
				}
				else
					bitMap = new BitMap(values);
				success = true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} while (!success);
		return bitMap;
	}// End getMap().
	
	// Method to get an integer between min and max.
	public static int readInt(int min, int max) {
		String token;
		int value = 0;
		boolean ok = false;
		
		while (!ok) {
			ok = true;
			try {
				token = in.readLine();
				value = Integer.parseInt (token); 
				if (value<min || value>max)
					ok = false;
			} 
			catch (Exception exception) {
				ok = false;
			}
			if (!ok)
				System.out.print("Illegal input, enter between " 
						+ min + " and " + max + ": ");			
		}
		return value;
	}// End readInt().
}// End class. 