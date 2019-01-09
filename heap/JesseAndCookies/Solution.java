import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  /*
   * Complete the cookies function below.
   */
  static int cookies(int k, int[] A) {
    /*
     * Write your code here.
     */
    PriorityQueue<Long> pq = new PriorityQueue<>();

    for (int i = 0; i < A.length; i++) {
      pq.add(Long.valueOf(A[i]));
    }
    int count = 0;
    while (pq.peek() < k && pq.size() >= 2) {
      long a = pq.poll();

      long b = pq.poll();
      pq.add(a + 2l * b);
      count++;

    }
    return pq.peek() >= k ? count : -1;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0].trim());

    int k = Integer.parseInt(nk[1].trim());

    int[] A = new int[n];

    String[] AItems = scanner.nextLine().split(" ");

    for (int AItr = 0; AItr < n; AItr++) {
      int AItem = Integer.parseInt(AItems[AItr].trim());
      A[AItr] = AItem;
    }

    int result = cookies(k, A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
