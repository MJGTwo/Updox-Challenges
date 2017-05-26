//Author: Michael Gardner
//Date: 5/26/17
//Purpose: To take in two integers and return a List of all primes that
//	exist between the given two integers.
//File: This is the j-unit test file to verify prime generation.

package challenge2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Tests {

	@Test
	public void isPrime1() {
		try {
			Primes x = new Primes();
			assertEquals(x.isPrime(11),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void isPrime2() {
		try {
			Primes x = new Primes();
			assertEquals(x.isPrime(-23),false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void isPrime3() {
		try {
			Primes x = new Primes();
			assertEquals(x.isPrime(1),false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void isPrime4() {
		try {
			Primes x = new Primes();
			assertEquals(x.isPrime(104729),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void generatePrimes1() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(-9,3);
			List<Integer> expected = Arrays.asList(2);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void generatePrimes2() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(2,3);
			List<Integer> expected = Arrays.asList();
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes3() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(-100,-1);
			List<Integer> expected = Arrays.asList();
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes4() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(1,10);
			List<Integer> expected = Arrays.asList(2,3,5,7);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes5() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(0,100);
			List<Integer> temp = new ArrayList<>(x.refNumberList);
			List<Integer> expected = new ArrayList<>();
			temp.stream().filter(value -> value < 100).forEach(expected::add);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes6() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(50,100);
			List<Integer> temp = new ArrayList<>(x.refNumberList);
			List<Integer> expected = new ArrayList<>();
			temp.stream().filter(value -> value < 100 && value > 50).forEach(expected::add);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes7() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(100,-100);
			List<Integer> temp = new ArrayList<>(x.refNumberList);
			List<Integer> expected = new ArrayList<>();
			temp.stream().filter(value -> value < 100 ).forEach(expected::add);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes8() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(1000,0);
			List<Integer> temp = new ArrayList<>(x.refNumberList);
			List<Integer> expected = new ArrayList<>();
			temp.stream().filter(value -> value < 1000 ).forEach(expected::add);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes9() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(1000,0);
			List<Integer> temp = new ArrayList<>(x.refNumberList);
			List<Integer> expected = new ArrayList<>();
			temp.stream().filter(value -> value < 1000 ).forEach(expected::add);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatePrimes10() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(104730,0);
			List<Integer> expected = new ArrayList<>(x.refNumberList);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
