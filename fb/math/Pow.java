package fb.math;

public class Solution {
  public double pow(double x, int n) {
    if (x == 0 && n < 0) throw new IllegalArgumentException("AAA");
    if (n == 0) return 1.0;
    boolean isNeg = (n < 0);
    n = n < 0 ? -n : n;
    double result = 0;
    if ((n & 1) == 1) {
      result = x * pow(x, n - 1);
    } else {
      double d = pow(x, n >> 1);
      result = d * d;
    }
    return isNeg ? 1.0d / result : result;

  }
}