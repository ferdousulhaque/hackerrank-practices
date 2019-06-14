import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LoveLetter {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {

        int length  = s.length();
        int val1, val2 = 0;
        int change_counts = 0;

        for(int i=0;i<length/2;i++){
            val1 = s.charAt(i);
            val2 = s.charAt(length-i-1);
            if(val1 != val2){
                change_counts += Math.abs(val2-val1);
            }
        }
        return change_counts;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data.out"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
