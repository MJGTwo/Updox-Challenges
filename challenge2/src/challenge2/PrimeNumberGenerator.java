//Author: Michael Gardner
//Date: 5/25/17
//Purpose: To take in two integers and return a List of all primes that
//	exist between the given two integers.
//File: This is the interface file that was given to me for this problem.
//	It has not been touched, except the package name and import.

package challenge2;

import java.util.List;

public interface PrimeNumberGenerator {
	List<Integer> generate(int startingValue, int endingValue);

    boolean isPrime(int value);
}
