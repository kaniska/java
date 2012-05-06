package fb.math;

import java.util.Random;

/**
 * @author mindpower
 * @since 5:20 PM 4/28/12
 */
public class FindMissingNumber {
  public int find(int[] a) {
    int total = 0;
    int xorTotal = 0;
    for (int i : a) {
      total += i;
      xorTotal ^= i;
    }
    return (total - xorTotal) / 2;
  }

  public int find2(int[] a) {
    int total = 0;
    for (int i : a) {
      total += i;
    }
    return (a.length + 2) * (a.length + 1) / 2 - total;
  }

  public static void main(String[] args) {
    Random r = new Random();
    int n = 1000;
    int missing = r.nextInt(n);
    System.out.println("n=" + n + "; missing=" + missing);
    int[] x = new int[n - 1];
    int start = 1;
    for (int i = 0; i < n - 1; i++) {
      if (start == missing) start++;
      x[i] = start++;
    }
    System.out.println(new FindMissingNumber().find2(x));
  }
}
