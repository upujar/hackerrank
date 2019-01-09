import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static long[][] multiplyMatrix(long[][] m, long[][] m2) {
    int N = m.length;
    long[][] ans = new long[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        ans[i][j] = 0;
        for (int k = 0; k < N; k++) {

          ans[i][j] = (ans[i][j] + (m[i][k] * m2[k][j]) % 1000000007) % 1000000007;

        }
        //ans[i][j] %= 1000000007;
      }
    }

    return ans;
  }

  static long[][] matrixPower(long[][] a, long n) {
    if (n == 1) {
      return a;
    } else {
      // System.out.println(Math.floorDiv(n, 2));
      long[][] b = matrixPower(a, Math.floorDiv(n, 2));
      if (n % 2 == 0) {
        return multiplyMatrix(b, b);
      } else {
        return multiplyMatrix(b, multiplyMatrix(b, a));
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] nos = new int[4];
    nos[0] = sc.nextInt();
    nos[1] = sc.nextInt();
    nos[2] = sc.nextInt();
    nos[3] = sc.nextInt();
    long w = sc.nextLong();
    Arrays.sort(nos);
    long[][] a = getMatrix(nos);
    long res = 0;
    if (w >= nos[3]) {
      long[] b = getWays1(nos, 4, nos[3]);
      long[][] c = matrixPower(a, w - nos[3] + 1);

      res = getResult(c, b);
    } else {
      res = getWays1(nos, 4, (int) w)[(int) w];
    }

    System.out.println(res);
    // getWays1(nos,4,w);

  }

  private static long getResult(long[][] a, long[] b) {
    long res = 0;
    for (int i = 0; i < a.length; i++) {
      res += (a[0][i] * b[b.length - i - 2]);
    }
    return res % 1000000007;
  }

  private static long[][] getMatrix(int[] nos) {
    long[][] res = new long[nos[3]][nos[3]];
    res[0][nos[0] - 1] = 1;
    res[0][nos[1] - 1] = 1;
    res[0][nos[2] - 1] = 1;
    res[0][nos[3] - 1] = 1;
    for (int i = 1; i < nos[3]; i++) {
      res[i][i - 1] = 1;
    }

    return res;
  }

  static long[] getWays1(int[] nos, int m, int n) {
    long[] opt = new long[n + 1];

    opt[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < m; j++) {
        long temp = 0l;
        if (i - nos[j] >= 0) {
          temp = opt[i - nos[j]];
        }

        opt[i] += temp;
        opt[i] %= 1000000007;
      }
    }

    //System.out.println(opt[n]%1000000007);
    return opt;
  }
}