/**
 * Saud Aljandal
 * lab2
 */


import java.io.*;


public class BinReader{
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream inLine= null;
		boolean checkPoint = false;
		boolean checkPoint2 = false;
        try {
        
			System.out.println("Enter Binary File Name");
		try {
			inLine = new DataInputStream(new FileInputStream(in.readLine()));

		}catch (FileNotFoundException e){
				System.out.println("File dosen't exist");
				checkPoint = true;
					}
		while(checkPoint);
		System.out.println("Binary file reader");
		while(!checkPoint2){
			try{
			System.out.print(inLine.readUTF());
			int var = inLine.readInt();
			double val = inLine.readDouble();
			System.out.print(var+" ");
			System.out.print(val);
			System.out.println("");
			}catch(EOFException eofe){
				checkPoint2 = true;
				inLine.close();
			}
		}
		}finally{System.out.println("\nBinReader Completed; data printed");
	}
}
}