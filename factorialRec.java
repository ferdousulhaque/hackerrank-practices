import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class factorialRec {

    // Complete the findFactorial function below.
    static int findFactorial(int n) {
        if(n == 0){
            return 1;
        } else if(n == 1){
            return 1;
        }else{
            return (n * findFactorial(n-1));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String executionPath = System.getProperty("user.dir");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(executionPath.replace("\\", "/"))+"in.out"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findFactorial(n);
            System.out.println(result);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
