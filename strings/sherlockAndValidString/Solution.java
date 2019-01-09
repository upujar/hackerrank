import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the isValid function below.
  static String isValid(String s) {
    Map<Character, Integer> freq = new HashMap();
    for (char x : s.toCharArray()) {
      if (!freq.containsKey(x)) {
        freq.put(x, 1);
      } else {
        freq.put(x, freq.get(x) + 1);
      }
    }
    int k = freq.get(s.charAt(0));

    int count = 0;//freq.entrySet().stream().mapToInt(entry->entry.getValue()-k).sum();
    System.out.println(freq + "" + (s.length() - 2));
    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
      int temp;
      if (entry.getValue() == 1) {
        temp = 1;
      } else {
        temp = Math.abs(entry.getValue() - k);
      }
      System.out.println(temp);
      if (Math.abs(temp) > 1) {
        return "NO";
      }

      count += temp;
    }
    System.out.println(count);
    if (count == 0 || Math.abs(count) == s.length() - 2 || Math.abs(count) == 1) {
      return "YES";
    }
    return "NO";


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    String result = isValid(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
