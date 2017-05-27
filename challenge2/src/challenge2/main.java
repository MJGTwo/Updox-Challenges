//Author: Michael Gardner
//Date: 5/25/17
//Purpose: To take in two integers and return a List of all primes that
//	exist between the given two integers.
//File: This is the main file for the program. 

package challenge2;
import java.io.IOException;
import java.util.List;

public class Main {

	private static boolean isInteger(String s){
		if (s.isEmpty()){return false;}
		for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) {return false;}
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),10) < 0) {return false;}
	    }
	    return true;
	}
	
	
	public static void main(String[] args) {
		//println to make sure I am sane during testing.
		//System.out.println("Hello, world!");
		Primes numberRange;
		String s1,s2;
		Integer num1, num2;
		List<Integer> answer;
		
		
		if (args.length == 0 || args.length > 2){
			//If ran without arguments
			System.out.println("\nUsage: java main NUMBER1 NUMBER2\n\nHelp: java main HELP");
		}
		else if (args.length == 1){
			//If ran with 1 argument
			String userInput = args[0];
			if (userInput.equals("help")){
				//If ran with the argument help
				System.out.println("\nUsage: java main NUMBER1 NUMBER2\n\n"
						+ "The following program's purpose is to general a list of prime numbers between two given numbers.\n"
						+ "The two numbers must be integers and must be positive.\n"
						+ "NOTE: Program decided to work with primes less than 104729."
						+ "Example USAGE:\n\n"
						+ "java main 1 10");
			}
			else{
				System.out.println("\nUsage: java main NUMBER1 NUMBER2\n\nHelp: java main HELP");
			}
		}
		else if (args.length == 2){
			//If ran with two arguments ...
			s1 = args[0];
			s2 = args[1];
			if (isInteger(s1) && isInteger(s2)){
				// ... that are both integers
				num1 = Integer.parseInt(s1);
				num2 = Integer.parseInt(s2);
				try {
					numberRange = new Primes();
					answer = numberRange.generate(num1,num2);
					System.out.println(answer);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				// ... that are not both integers
				System.out.println("\nUsage: java main NUMBER1 NUMBER2\n\nHelp: java main HELP");
			}
		}
		
		
		
		
		
	}

}
