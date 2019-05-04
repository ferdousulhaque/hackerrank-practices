import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[] vals = new int[16];
        int c = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                vals[c++] = arr[j][i]+arr[j][i+1]+arr[j][i+2]+
                        arr[j+1][i+1]+
                        arr[j+2][i]+arr[j+2][i+1]+arr[j+2][i+2];
            }
        }

        int maxCost;
        maxCost = Integer.MIN_VALUE;
        for(int i=0;i<16;i++){
            if(vals[i] > maxCost){
                maxCost = vals[i];
            }
        }

        return maxCost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data.out"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
