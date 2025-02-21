import java.util.Arrays;

public class Concat {

    public static void main(String[] args) {
        int[] array1 = new int[10000000];
        int[] array2 = new int[10000000];

	for (int i=0; i < 10000000;i++) {
		array1[i] = i;
		array2[i] = i + 10000000;
	}	
	
        int aLen = array1.length;
        int bLen = array2.length;
        int[] result = new int[aLen + bLen];

	// Start measuring execution time
        long startTime = System.nanoTime();
        
        System.arraycopy(array1, 0, result, 0, aLen);
        System.arraycopy(array2, 0, result, aLen, bLen);

	// Stop measuring execution time
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
	long executionTime
            = (endTime - startTime);

	double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println(seconds + " s");
        
        //System.out.println(Arrays.toString(result));
    }
}
