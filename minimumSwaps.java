import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class minimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int[] orig_arr = new int[arr.length];
        int numberOfSwap = 0;
        orig_arr = arr;
        int temp = 0;
        Arrays.sort(arr);
        for(int i = 0; i < orig_arr.length; i++) {
            if (orig_arr[i] != arr[i]) {
                for (int j = i+1; j < orig_arr.length; j++) {
                    if(orig_arr[j] == arr[i]) {
                        temp = orig_arr[i];
                        orig_arr[i] = orig_arr[j];
                        orig_arr[j] = temp;
                        numberOfSwap++;
                        break;
                    }
                }
            }
        }
        return numberOfSwap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String executionPath = System.getProperty("user.dir");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(executionPath.replace("\\", "/"))+"in.out"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
