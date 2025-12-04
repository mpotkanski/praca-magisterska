import java.io.*;
import java.math.BigInteger;

public class Addition2 {
    // main function
    public static void main(String[] args)
    {
        // Start measuring execution time
        long startTime = System.nanoTime();

        count_function(100_000_000);

        // Stop measuring execution time
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
        long executionTime
            = (endTime - startTime);

	double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println(seconds + " s");
    }
  
    public static void count_function(long x)
    {
    	BigInteger b1, b2;
 
        b1 = new BigInteger("100");
        int exponent = 100;
 
        BigInteger result = b1.pow(exponent);
        BigInteger result2 = result.add(BigInteger.valueOf(x));
        
        b2 = new BigInteger("2000");
        int exponent2 = 2_000;
 
        BigInteger result3 = b2.pow(exponent2);
        
    	BigInteger sum = BigInteger.ZERO;
		
        for (BigInteger bi = result; bi.compareTo(result2) < 0; bi = bi.add(BigInteger.ONE))
          sum = sum.add(result3);
    }
}
