package test111;

import java.util.Random;

/**
 * @author jbu
 */
public class MaxSum {
  public static int maxsum1(int[] x) {
    int n = x.length;
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += x[k];
        }
        max = Math.max(sum, max);
      }
    }
    return max;
  }

  public static int maxsum2a(int[] x) {
    int n = x.length;
    int max = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += x[j];
        max = Math.max(sum, max);
      }
    }
    return max;
  }

  public static int maxsum2b(int[] x) {
    int n = x.length;
    int[] cumarr = new int[n];
    for (int i = 0; i < n; i++) {
      cumarr[i] = (i == 0 ? 0 : cumarr[i - 1]) + x[i];
    }
    int max = 0, sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        sum = cumarr[j] - (i == 0 ? 0 : cumarr[i - 1]);
        max = Math.max(sum, max);
      }
    }
    return max;
  }

  public static int maxsum3(int[] x, int l, int u) {
    if (l > u) {
      return 0;
    }
    if (l == u) {
      return Math.max(x[l], 0);
    }
    int m = (l + u) / 2;
    int rmax = 0, lmax = 0, sum = 0;
    for (int i = m; i >= l; i--) {
      sum += x[i];
      lmax = Math.max(sum, lmax);
    }

    sum = 0;
    for (int i = m + 1; i <= u; i++) {
      sum += x[i];
      rmax = Math.max(sum, rmax);
    }

    int max = Math.max(maxsum3(x, l, m), maxsum3(x, m + 1, u));
    return Math.max(max, lmax + rmax);
  }

  public static int maxsum4(int[] x) {
    int max = 0, curmax = 0;
    int n = x.length;
    for (int i = 0; i < n; i++) {
      curmax = Math.max(0, curmax + x[i]);
      max = Math.max(max, curmax);
    }
    return max;
  }

  public static long now = 0;

  public static void main(String args[]) {
    Random r = new Random();
    int limit = 100000, n = 10000, x[] = new int[n];
    p("Array=[");
    for (int i = 0; i < n; i++) {
      x[i] = r.nextInt(limit) - limit / 2;
      p(x[i], ";");
    }
    pl("]");


    now = System.nanoTime();
    pl("maxsum1=", maxsum1(x), " time=", (double)(System.nanoTime()-now)/1000000000d, "s");
    now = System.nanoTime();
    pl("maxsum2a=", maxsum2a(x)," time=", (double)(System.nanoTime()-now)/1000000000d, "s");
    now = System.nanoTime();
    pl("maxsum2b=", maxsum2b(x)," time=", (double)(System.nanoTime()-now)/1000000000d, "s");
    now = System.nanoTime();
    pl("maxsum3=", maxsum3(x, 0, n - 1)," time=",(double)(System.nanoTime()-now)/1000000000d, "s");
    now = System.nanoTime();
    pl("maxsum4=", maxsum4(x)," time=", (double)(System.nanoTime()-now)/1000000d, "ms");

  }

  public static void pl(Object... msg) {
    p(msg);
    p("\n");
  }

  public static void p(Object... msg) {
    StringBuilder sb = new StringBuilder("");
    for (Object o : msg) {
      if (o != null) {
        sb.append(o);
      } else {
        sb.append("null");
      }
    }
    System.out.print(sb.toString());
  }

}
