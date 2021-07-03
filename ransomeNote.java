import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> mag_word = new HashMap<>();
        Map<String, Integer> ran_word = new HashMap<>();
        String message = "Yes";
        for (String word : magazine) {
            Integer n = mag_word.get(word);
            n = (n == null) ? 1 : ++n;
            mag_word.put(word, n);
        }
        for (String word : note) {
            Integer n = ran_word.get(word);
            n = (n == null) ? 1 : ++n;
            ran_word.put(word, n);
        }
        for (String word : note) {
            Integer mag_count, note_count;
            mag_count = mag_word.get(word);
            note_count = ran_word.get(word);
            if(mag_count != note_count) {    
                message = "No";
                break;
            }
        }
        System.out.println(message);

    }

}

public class ransomeNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
