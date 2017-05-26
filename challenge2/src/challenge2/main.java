//Author: Michael Gardner
//Date: 5/25/17
//Purpose: To take in two integers and return a List of all primes that
//	exist between the given two integers.
//File: This is the main file for the program. 

package challenge2;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		//println to make sure I am sane during testing.
		System.out.println("Hello, world!");
		Primes numberRange;
		try {
			numberRange = new Primes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
