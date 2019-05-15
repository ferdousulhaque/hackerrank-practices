import java.io.*;
import java.util.*;

public class binaryGap {

    static int convBin(int a){
        int n = 0;
        int flag = 0;
        int temp = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        String x = "";
        while(a>0){
            n = a % 2;
            x = n+x;
            a = a / 2;
            if(n == 1 && flag == 0){
                flag = 1;
            }
            else if(n == 0 && flag == 1){
                count++;
            }
            else if(n == 1 && flag == 1){
                if(count > max){
                    max = count;
                }
                count = 0;
                flag = 1;
            }
        }

        
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int n;
        int a;

        n = scanner.nextInt();
        scanner.close();

        a = convBin(n);

        System.out.println("Binary gap of "+n+" is : "+a);
    }
}
