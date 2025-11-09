import java.io.*;

public class Empty {
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
        for (long i = 0; i < x; i++)
            ;
    }
}
