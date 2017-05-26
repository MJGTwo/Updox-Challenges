package challenge2;

import java.util.List;
import java.util.Set;
import java.io.*;
import java.util.HashSet;

public class Primes implements PrimeNumberGenerator {
	private String results;
	public Set<Integer> refNumbers = new HashSet<>();
	
	public Primes() throws IOException{
		//refNumbers 
		FileReader fl;
		try {
			fl = new FileReader("./src/challenge2/primes.txt");
			BufferedReader br = new BufferedReader(fl);
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			    	Integer num = Integer.valueOf(line);
			    	refNumbers.add(num);
			        line = br.readLine();
			    }
			} finally {
			    br.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPrime(int value) {
		// TODO Auto-generated method stub
		Set<Integer> test = new HashSet<>();
		test.add(value);
		
		//System.out.println(refNumbers);
		return refNumbers.containsAll(test);
	}

}
