import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FormingMagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][] s1= {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
        int[][] s2= {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        int[][] s3= {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        int[][] s4= {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        int[][] s5= {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
        int[][] s6= {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        int[][] s7= {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        int[][] s8= {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        
        int[] diff = new int[8];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                diff[0] += Math.abs(s[i][j] - s1[i][j]);
                diff[1] += Math.abs(s[i][j] - s2[i][j]);
                diff[2] += Math.abs(s[i][j] - s3[i][j]);
                diff[3] += Math.abs(s[i][j] - s4[i][j]);
                diff[4] += Math.abs(s[i][j] - s5[i][j]);
                diff[5] += Math.abs(s[i][j] - s6[i][j]);
                diff[6] += Math.abs(s[i][j] - s7[i][j]);
                diff[7] += Math.abs(s[i][j] - s8[i][j]);
            }
        }
        int minCost;
        minCost = Integer.MAX_VALUE;
        for(int i=0;i<8;i++){
            if(diff[i]< minCost){
                minCost = diff[i];
            }
        }

        return minCost;
    }

    static int isMagicSquares(int[][] s1){
        int[] v = {0,0,0,0,0,0,0,0};
        int sum; sum = 0;
        for(int i=0; i<3; i++){
            v[0] += s1[i][i];
            v[1] += s1[2-i][i];
            v[2] += s1[0][i];
            v[3] += s1[1][i];
            v[4] += s1[2][i];
            v[5] += s1[i][0];
            v[6] += s1[i][1];
            v[7] += s1[i][2];
        }
        for(int i=0;i<8;i++){
            sum += v[i];
        }
        return (sum == 120)?1:0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data.out"));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
