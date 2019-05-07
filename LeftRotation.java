import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    static int[] leftRotation(int[] a,int n, int d){
        int temp, j = 0;
        for(int i=0;i<d;i++){ 
            temp = a[0]; 
            for (j = 0; j < n - 1; j++) 
                a[j] = a[j + 1]; 
            a[j] = temp; 
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();

        a = leftRotation(a,n,d);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
