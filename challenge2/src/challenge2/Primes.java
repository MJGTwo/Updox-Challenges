//Author: Michael Gardner
//Date: 5/25/17
//Purpose: To take in two integers and return a List of all primes that
//	exist between the given two integers.
//File: This file is the Prime class definition.  

package challenge2;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.io.*;
import java.util.HashSet;

public class Primes implements PrimeNumberGenerator {
	public Set<Integer> refNumberSet = new HashSet<>();
	public List<Integer> refNumberList = new ArrayList<>();
	public Primes() throws IOException{
		//refNumbers 
		FileReader fl;
		try {
			fl = new FileReader("./src/challenge2/primes.txt");
			BufferedReader br = new BufferedReader(fl);
			try {
			    String line = br.readLine();

			    while (line != null) {
			    	Integer num = Integer.valueOf(line);
			    	refNumberList.add(num);
			    	refNumberSet.add(num);
			        line = br.readLine();
			    }
			} finally {
			    br.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	private List<Integer> generate_helper(int startingValue, int endingValue){
		int min, max;
		List<Integer> result = new ArrayList<>();
		min = (startingValue < endingValue) ? startingValue : endingValue;
		max = (startingValue > endingValue) ? startingValue : endingValue;
		if (max-min <=1 || max <= 0){
			result.add(-1);
		}
		else{
			result.add(min);
			result.add(max);
		}
		
		
		
		
		return result;
	}
	
	
	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		//The purpose of this function is to generate a list of primes.
		int min, max, start;
		boolean flag = true;
		Double refRoot = Math.sqrt(endingValue);
		List<Integer> results = new ArrayList<Integer>();
		List<Integer> filtered;
		
		//Sort start and end
		List<Integer> temp = generate_helper(startingValue,endingValue);
		if (temp.size() == 1){
			return results;
		}
		else{
			min = temp.get(0);
			max = temp.get(1);
		}

		//Always start with odd number
		start = (min % 2 == 0) ? min+1 : min;
		refRoot = Math.sqrt(max-1);
		//Edge case
		if (min <= 1){results.add(2);start = 3;}
//		for (Integer i = 3; i < refRoot; i+=2){
//			results
//		}

		//Generates odd integers between the min and max
		for (;start < max; start+=2){
			flag = true;
			Double root = Math.sqrt(start);
			
			//removing perfect squares
			if (root == root.intValue()){
				flag = false;
			}
			else{
				//saves root of largest non-perfect square
				refRoot = root;
			}
			
			
			
			if (flag){
				results.add(start);
			}
		}
		
		
		//Loop from 3 to square root of largest number (SRLN)in list
		//O(M*N) M = numbers from 3 - SRLN. 
		//N = odd, non-perfect square numbers from min to max.
		//As i increases, we traverse the list and filter out any number that
		// is divisible by i while i is less than that number.
		for (Integer i = 3; i < refRoot.intValue(); i+=2){
			Integer num = i;
			filtered = new ArrayList<>();
			results.stream().filter(value -> (value % num != 0 && num != value) 
						|| num >= value)
					.forEach(filtered::add);
			results = filtered;
		}
		
		
		//System.out.println(results);
		return results;
	}
	
	public List<Integer> generate_sieve(int startingValue, int endingValue) {
		    //The purpose of this function is to generate a list of primes.
		    
		    int min, max;
		    List<Integer> results = new ArrayList<Integer>();
		    List<Integer> primes = new ArrayList<Integer>();
		    List<Integer> numbers = new ArrayList<Integer>();

		    
		  //Sort start and end
			List<Integer> temp = generate_helper(startingValue,endingValue);
			if (temp.size() == 1){
				return results;
			}
			else{
				min = temp.get(0);
				max = temp.get(1);
			}
		    temp = new ArrayList<Integer>();
		    //start prime list
		    primes.add(2);
		    //add odd numbers
		    for (Integer i = 3; i < max; i+=2){
		        numbers.add(i);
		    }
		    //Sieve
		    //Numbers list created sorted with smallest number first
		    //Loop starts and the Numbers list is filtered by the largest prime in Primes
		    //Smallest number left in Numbers must be new largest Prime
		    //Remove this number from Numbers. Repeat until Numbers is empty.
		    while(!numbers.isEmpty()){
		        numbers.stream().filter(
		                value -> value % primes.get(primes.size()-1) != 0 
		                && value != primes.get(primes.size()-1)).forEach(temp::add);
		        numbers = temp;
		        temp = new ArrayList<>();
		        if (!numbers.isEmpty()){
		            primes.add(numbers.remove(0));
		        }
		    }
		    //Remove all primes below your min
		    primes.stream().filter(
		            value -> value > min).forEach(results::add);

		    return results;

	}

	@Override
	public boolean isPrime(int value) {
		//The purpose of this function is to validate a number as a prime.
		Set<Integer> test = new HashSet<>();
		test.add(value);
		
		//System.out.println(refNumbers);
		return refNumberSet.containsAll(test);
	}

}
