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
        char[] word = s.toCharArray();
        String conv;
        char[] conv_word;
        int count = word.length;
        int result = 0;
        for(int i=0; i<count;i++){
            for(int j=i+1;j<=count;j++){
                conv = s.substring(i,j);
                System.out.println(conv);
                conv_word = conv.toCharArray();
                if(conv_word.length == 1){
                    result++;
                }
                else if(istAllSame(conv_word)){
                    result += 2;
                }else if(istPalindrom(conv_word)){
                    result++;
                }
            }
        }
        
        // System.out.println(result);
        return result;

    }

    public static boolean istAllSame(char[] word){
        int i1 = 0;
        int i2 = 0;
        i1 = word[0];
        for(int i =1; i<word.length; i++){
            i2 = word[i];
            if(i1 != i2){
                return false;
            }
        }
        return true;
    }

    public static boolean istPalindrom(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
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
