public class Solution {

  static long repeatedString(String s, long n) {
    long count = 0;
    long mod = n % s.length() - 1;
    long count1 = 0;
    for (int i = 0; i < Math.min(s.length(), n); i++) {
      if (s.charAt(i) == 'a') {
        count++;
      }
      if (i == mod) {
        count1 = count;
      }
    }
    if (s.length() >= n) {
      return count;
    }

    count = n / s.length() * count + count1;

    return count;
  }

  public static void main(String[] args) {
    System.out.println(repeatedString("ababa", 3));
  }
}
