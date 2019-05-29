import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class flatLandSpace {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        int[] max = new int[n];
        int getMax = 0;
        for(int i=0;i<n;i++){
            int distToSpaceStation = Integer.MAX_VALUE;
            for(int j=0;j<c.length;j++){
                if(Math.abs(c[j] - i) == 0){
                    distToSpaceStation = 0;
                    break;
                }else{
                    if(distToSpaceStation > Math.abs(c[j] - i)){
                        distToSpaceStation = Math.abs(c[j] - i);
                    }
                }
            }
            max[i] = distToSpaceStation;
            if(max[i] > getMax){
                getMax = max[i];
            }
        }
        
        return getMax;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data.out"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
