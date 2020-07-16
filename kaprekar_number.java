import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
 
public class Solution {
 
    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        boolean oneKaprekar = false;
        for(int i=p;i<=q;i++){
            if(isKaprekar(i)){
                oneKaprekar = true;
                System.out.print(i + " ");
            }
        }
        if(!oneKaprekar){
            System.out.println("INVALID RANGE");
        }
 
    }
 
    static boolean isKaprekar(int val){
        long squared = (long) val * val;
        String str   = String.valueOf(squared);
        String left  = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);
        int halfLeft = (left.isEmpty())  ? 0 : Integer.parseInt(left);
        int halfRight = (right.isEmpty()) ? 0 : Integer.parseInt(right);
        if (halfLeft + halfRight == val) {
            return true;
        } else {
            return false;
        }
    }
 
    private static final Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
        kaprekarNumbers(p, q);
 
        scanner.close();
    }
}