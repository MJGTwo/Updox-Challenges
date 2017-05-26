package challenge2;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() {
		try {
			Primes x = new Primes();
			assertEquals(x.isPrime(11),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void test2() {
		try {
			Primes x = new Primes();
			assertEquals(x.isPrime(7),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
