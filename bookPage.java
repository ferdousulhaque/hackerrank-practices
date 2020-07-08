import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class bookPage {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int page1 = Math.abs((p) / 2);
        if(n%2==0){
            n++;
        }
        int page2 = Math.abs((p - (n)) / 2);
        return page1 < page2 ? page1 : page2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String executionPath = System.getProperty("user.dir");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(executionPath.replace("\\", "/"))+"in.out"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}