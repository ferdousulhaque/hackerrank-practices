import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class viralAdvertisement {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int cumulative, shared, liked;
        cumulative = 0;
        liked = 0;
        shared = 5;
        while(n>0){
            liked = shared / 2;
            cumulative += liked;
            shared = liked * 3;
            n--;
        }
        return cumulative;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data.out"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
