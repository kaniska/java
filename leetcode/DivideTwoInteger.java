package leetcode;

/**
 * @author jbu
 */
public class DivideTwoInteger {

  /**
   * use long to avoid overflow
   * @param dividend
   * @param divisor
   * @return
   */
    public int divide(int dividend, int divisor) {
        long a = dividend, b=divisor;
        if (b==0)  throw new IllegalArgumentException("Divide by 0");
        if (a==0) return 0;
        boolean isNeg = false;
        if ((a>0 && b<0) || (a<0 && b>0)) isNeg=true;
        a = (a>=0? a:-a);
        b = (b>=0? b:-b);
        int mcb = 0;
        int r = 0;
        while ((b<<mcb)<a) mcb++;
        for (int i=mcb;i>=0;i--) {
            if ((b<<i)>a) continue;
            r |=(1<<i);
            a -=(b<<i);
        }
        return isNeg? -r:r;

    }
}
