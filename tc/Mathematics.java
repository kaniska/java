package tc;

import java.util.Arrays;


/**
 * @author jbu
 */
public class Mathematics {
  public static boolean[] prime(int n) {
    boolean[] prime = new boolean[n + 1];
    Arrays.fill(prime, true);

    prime[0] = false;
    prime[1] = false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (prime[i]) {
        for (int k = i * i; k <= n; k += i) prime[k] = false;
      }
    }
    return prime;
  }

  public static long GCD(long a, long b) {
    if (b == 0) return a;
    return GCD(b, a % b);
  }


  public static int toDecimal(int a, int b) {
    int t = 0;
    int multiplier = 1;
    while (a != 0) {
      t = a % 10 * multiplier + t;
      multiplier *= b;
      a = a / 10;
    }
    return t;
  }

  public static void main(String args[]) {
    int n = 100000;
    boolean[] p = prime(n);
    System.out.println(GCD(1231297888, 419784));

    System.out.println(toDecimal(101011, 2));
  }

}
