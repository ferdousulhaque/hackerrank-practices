import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class specialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int length = s.length();
        int result = 0;
        for(int i=0; i<length;i++){
            // if the current symbol is in the middle of palindrome
            int offset = 1;
            while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
                    && s.charAt(i + offset) == s.charAt(i - 1)) {
                        result++;
                        offset++;
            }
            // if this is repeatable characters aaaa
            int repeats = 0;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                repeats++;
                i++;
            }
		    result += repeats * (repeats + 1) / 2;
        }
        
        //System.out.println(result+length);
        return result+length;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data.out"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        substrCount(n, s);

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        
        scanner.close();
    }
}
