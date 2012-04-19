package fb.math;

/**
 * @author jbu
 */
public class Divide {
  public static int divide(int a, int b) throws ArithmeticException {
    if (b==0) throw new ArithmeticException("divide by zero");
    boolean bNeg = false;
    if ((a>0 && b<0) || (a<0 && b>0))  bNeg=true;
    a=(a<0)?-a:a;
    b=(b<0)?-b:b;
    int msb=0,q=0;
    while ((b<<msb)<a) msb++;
    for (int i=msb;i>=0;i--) {
      if ((b<<i)>a) continue;
      q|=1<<i;
      a-=(b<<i);
    }
    return bNeg? -q:q;
  }

  /**
   *
   *        int r = 0;
       while ((divisor<<msb) <dividend) msb++;
       for (int i=msb;i>=0;i--) {
         if ((divisor<<i) >dividend) continue;
         r |=(1<<i);
         dividend -= (divisor<<i);
       }
       return isNeg? -r:r;
    * @param args
   */

  public static void main(String args[]) {
    System.out.println(divide(365,7));
    System.out.println(divide(123123123,213));
    int a=-2147483648;
    System.out.println(a+"  "+(-a)+" "+Integer.MIN_VALUE);

  }

}
