import java.util.Arrays;

public class Concat2 {

    public static void main(String[] args) {
        int[] array1 = new int[10000000]; //000000
        int[] array2 = new int[10000000];

	for (int i=0; i < 10000000;i++) {
		array1[i] = i;
		array2[i] = i + 10000000;
	}	
	
        int aLen = array1.length;
        int bLen = array2.length;
        int[] result = new int[aLen];

	// Start measuring execution time
        long startTime = System.nanoTime();

	for (int i = 0; i < aLen; i++) {
            result[i] = array1[i] + array2[i];
        }

	// Stop measuring execution time
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
	long executionTime
            = (endTime - startTime);

	double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println(seconds + " s");
    }
}
