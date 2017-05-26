//Author: Michael Gardner
//Date: 5/26/17
//Purpose: To take in two integers and return a List of all primes that
//	exist between the given two integers.
//File: This is the j-unit test file to verify prime generation.



import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.junit.Test;

import challenge2.Primes;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Test_nonsieve {

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
	public void generatePrimes_1() {
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
	public void generatePrimes_2() {
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
	public void generatePrimes_3() {
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
	public void generatePrimes_4() {
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
	public void generatePrimes_5() {
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
	public void generatePrimes_6() {
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
	public void generatePrimes_7() {
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
	public void generatePrimes_8() {
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
	public void generatePrimes_9() {
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
	public void generatePrimes_10() {
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
	
	@Test
	public void generatePrimes_11() {
		try {
			Primes x = new Primes();
			List<Integer> results = x.generate(104730,104728);
			List<Integer> expected = new ArrayList<>();
			expected.add(104729);
			assertThat(results, equalTo(expected));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
