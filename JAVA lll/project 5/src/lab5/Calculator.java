package lab5;
/*
 * Saud Aljandal
 * lab5
 * cs258
 * 
 */

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
	private static final String 		delimiters = "+-*/()"; 
	private static Stack5<String> 	operators;
	private static Stack5<Double>	numbers;
	private static boolean 			checkPoint;
	private static boolean 			signOk ;
	public static String 			qInput = "";
	
	
	
	public static void main(String[] args){
		do{
				signOk=false;
			try{
				
				System.out.println("Enter an Expression: ");
				Scanner sc=new Scanner(System.in);
				String INPUT = sc.nextLine();//You may assume the user will enter one expression per line.
				qInput = INPUT;//assign the string to check if it is "quit"
				INPUT = INPUT.replaceAll("\\s+", "");//ignore spaces
				//System.out.println(INPUT);//testing
				operators = new Stack5<String>();	//for delimiters
				numbers = new Stack5<Double>();		//for numbers
				
				StringTokenizer tokenizer= new StringTokenizer(INPUT, delimiters, true);// Use a StringTokenizer object with "+-*/()" as delimiters.
				//sc.close();
				while(tokenizer.hasMoreTokens()){//Input and evaluate expressions in a loop until the user enters the string “quit”
					String next = tokenizer.nextToken();
					//will use switch
					switch(next){
					//if user type quit
					case "quit":
						System.out.println("program is down");
						System.exit(0);// exit from program
						
						//first test parenthesis, opening and closing
					case "(":// if user starts with left parenthesis
						operators.push(next);
						break;
					case ")"://user now should close parenthesis after typing some expressions and opening parenthesis
						if(!operators.isEmpty() && !operators.top.data.equals("("))
						{
							eval();
							}
						else
							{
							System.out.println("The whole expression needs to be inside the parenthesis. ");
							//The input expression failed to parse if no matching left parenthesis is found
							break;
							}
							operators.pop();
							break;
					case "+":
						if(!operators.isEmpty() && (operators.top.data.equals("+") ))
						{
							eval();
							}
							operators.push(next);
							break;
					case "-":

						if(!operators.isEmpty() && (operators.top.data.equals("-") && (!signOk) ))
						{
							eval();
							
							operators.push(next);
							break;}
						else {
							signOk = false;
							
							operators.push(next);
							continue;}
							
					case "*":
						if (!operators.isEmpty() && (operators.top.data.equals("*")))
						{
							eval();
							}
							operators.push(next);
							break;
					case "/":
						while(!operators.isEmpty() && operators.top.data.equals("/")){
							eval();
							}
							operators.push(next);
							break;
					default:// starts with -
						if((next.startsWith("-"))&& signOk) {
							
							signOk = false;
							eval();

							break;
							} 
						else numbers.push(Double.parseDouble(next));
						//eval();
						break;
					}
				}
				while(!operators.isEmpty() && !numbers.isEmpty()) 
					eval(); //Evaluate if both operators and operands are not empty
				//print result;
				System.out.println(numbers.top.data);
				}
				catch(NumberFormatException e){
					System.out.println("invalid input.");
				}catch (EmptyStackException e2) {
					System.out.println("stack error");
				}catch (Exception e3){
					System.out.println("Error");
				}
		}while (!(checkPoint));
	}
	public static void eval(){//Implement an eval() method that pops two operands and an operator
		
		if(Stack5.isBool());
		//since it is stack, last input is the first output!
		double num2 = numbers.pop(); 
		double num1 = numbers.pop();
		String operator = operators.pop();
		if (signOk) {num1 = -1 * num1 ;}
		//will use switch
		switch(operator){
			case "+":
				numbers.push(num1+num2);
			break;
			case "-":
				numbers.push(num1-num2);
			break;
			case "*":
				numbers.push(num1*num2);
			break;
			case "/":
				numbers.push(num1/num2);
			break;
		}
	}
}
