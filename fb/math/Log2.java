package fb.math;

/**
 * @author jbu
 */

public interface Log2 {
  double calculate(double x);
}

class Log2Test {

  public static void main(String args[]) {
    double d[] = {1232498172.123e223, 17.99, 251.223132, 15, 1.222, 0.1847812};
    double r[] = new double[d.length];
    for (int i = 0; i < d.length; i++) r[i] = Math.log(d[i]) / Math.log(2);
    Log2[] alg = new Log2[]{/*new Log2Binary(),*/ new Log2Glassdoor(), new Log2GlassdoorSimple(), new Log2Junjie()};

    for (Log2 log : alg) {
      System.out.println("CURRENT Algorithm: " + log.getClass().getSimpleName());
      long total = System.nanoTime();
      for (int i = 0; i < d.length; i++) {
        long cur = System.nanoTime();
        double rr = log.calculate(d[i]);
        System.out.printf("Log2(%10.4f)=%16.10f , diff=%4.2f%%, Time=%d us\n", d[i], rr, (rr - r[i]) * 100 / r[i], (System.nanoTime()-cur)/1000);
//        System.out.println("Log2("+d[i]+")="+log.calculate(d[i])+"    Difference="+r[i] +  "   (TOOK "+(System.currentTimeMillis()-cur)+"ms)");
      }
      System.out.println("Total time: " + (System.nanoTime() - total)/1000 + " us");
    }
  }
}

class Log2Binary implements Log2 {
  public double calculate(double x) {
    long l = (long) x;
    int n = 0;
    while (l > 0) {
      l >>= 1;
      n++;
    }
    double low = x < 1 ? n : n - 1;
    double high = x < 1 ? (n - 1) : n;
    double result = (high + low) / 2;
    while (Math.abs(Math.pow(2, result) - x) > 0.00001) {
      if (Math.pow(2, result) > x) {
        high = result;
      } else {
        low = result;
      }
      result = (high + low) / 2;
//      System.out.println(result + "  " + Math.pow(2, result));
    }
    return high;
  }
}

class Log2Glassdoor implements Log2 {

  /**
   * http://www.glassdoor.com/Interview/Write-a-function-that-computes-log2-using-sqrt-QTN_151363.htm
   * ln(1+x) = x(6+x)/(6+4x) (see http://www.nezumi.demon.co.uk/consult/logx.htm)
   * Pade's approximation
   * So, log2(1+x) = (x(6+x)/(6+4x))/ln(2)
   * <p/>
   * Using Sumer Cip's code and modifying it a bit:
   * <p/>
   * def log2(x):
   * if x <= 2:
   * z = x-1
   * return (1.442695*z*(6+z)/(6+4*z))
   * else:
   * y = sqrt(x)
   * return 2*log2(y)
   *
   * @param x
   * @return
   */
  public double calculate(double x) {
    if (x < 1) {
      return -1 * calculate(1 / x);
    } else if (x == 1) {
      return 0;
    } else if (x < 2) {  // suppose x>=1
      double z = x - 1;
      return 1.442695 * z * (6 + z) / (6 + 4 * z);
    } else if (x == 2) {
      return 1;
    } else { // x>2    logX= 2* logSqrt(X)
      return 2 * calculate(Math.sqrt(x));
    }
  }
}

class Log2GlassdoorSimple implements Log2 {
  /**
   * Notice Log2(1+y) = y/ln(2) = 1.442695*y (when x is very small)
   * So the solution is: when x >= 2, divide x, until 1<x<2, suppose we do m times
   * Then do sqrt(x) continually, until x-1 is very close to 0, suppose we do it n times
   * We can have log2(x) = m + (2^n)*(x'-1)*1.442695
   * <p/>
   * For example, suppose x = 18
   * m = 4, then x = 1.125
   * do sqrt(x) 10 times, n=10, x will become 1.000115029111
   * So log2(18) = 4 + 2^10*(0.000115029111)*1.442695 = 4.169934
   *
   * @param x
   * @return
   */
  public double calculate(double x) {
    if (x < 1)  return -1 * calculate(1 / x);
    if (x == 1) return 0;
    if (x == 2) return 1;
    if (x < 2) {  // suppose x>=1
      double z = x - 1;
      if (z < 0.0001) {
        return 1.442695 * z;
      } else {
        return 2 * calculate(Math.sqrt(x));
      }
    } else { // x>2    logX= 2* logSqrt(X)
      return 1 + calculate(x / 2);
    }
  }
}

class Log2Junjie implements Log2 {

  /**
   * by Junjie, we can keep sqrt x until it very close to 1;
   *
   * @param x
   * @return
   */
  public double calculate(double x) {
    if (x == 1) return 0;
    if (x == 2) return 1;
    if (x < 1) return -1 * calculate(1 / x);
    double z = x - 1;
    if (z < 0.00001) {
      return 1.442695 * z;
    } else {
      return 2 * calculate(Math.sqrt(x));
    }
  }

}

