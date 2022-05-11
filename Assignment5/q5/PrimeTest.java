package Assignment5.q5;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrimeTest {

  public static void main(String[] args) {
    Prime test1 = new Prime();
    System.out.println(assertEquals(false, test1.isPrime(2)));
    Prime test2 = new Prime();
    System.out.println(assertEquals(false, test2.isPrime(3)));
    Prime test3 = new Prime();
    System.out.println(assertEquals(false, test3.isPrime(4)));
    Prime test4 = new Prime();
    System.out.println(assertEquals(false, test4.isPrime(5)));
    Prime test5 = new Prime();
    System.out.println(assertEquals(false, test5.isPrime(6)));
  }
}
