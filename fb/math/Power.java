package fb.math;

/**
 * @author jbu
 */
public class Power {
  public static double pow(double x, int n) {
    if (x == 0 && n < 0) {
      throw new IllegalArgumentException("divide by 0");
    }
    if (n == 0) {
      return 1;
    }
    if (x == 0 && n > 0) {
      return 0;
    }
    boolean isNeg = (n < 0);
    n = Math.abs(n);
    double r;
    if ((n & 1) == 1) {
      r = x * pow(x, n - 1);
    }
    else {
      System.out.println("x="+x+"  n="+n+"("+Integer.toBinaryString(n));
      double p = pow(x, n >> 1);
      r = p * p;
    }
    return isNeg ? 1.0 / r : r;
  }

  public static void main(String args[]) {
//    System.out.println("92181.12312^12=" + Math.pow(92181.12312, 12) + "/" + pow(92181.12312, 12));
//    System.out.println("22.332^-8=" + Math.pow(22.332, -8) + "/" + pow(22.332, -8));
    System.out.println("1^-MIN=" + pow(1, Integer.MIN_VALUE) );

    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE)+ "\t" + Math.abs(Integer.MIN_VALUE));
  }
}
