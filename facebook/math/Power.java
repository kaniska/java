package facebook.math;

/**
 * @author jbu
 */
public class Power {
    public static double pow(double x, int n) {
        if (n==0) return 1;
        if (x==0 && n>0) return 0;
        if (x==0 && n<0) throw new IllegalArgumentException("divide by 0");
        boolean isNeg = (n<0);
        n = Math.abs(n);

        double r;

        if (n%2==1)
            r = x*pow(x,n-1);
        else {
            double p = pow(x,n/2);
            r = p*p;
        }
        return isNeg? 1.0/r:r;
    }

  public static void main(String args[]) {
    System.out.println("92181.12312^12=" + Math.pow(92181.12312, 12) + "/" + pow(92181.12312, 12));
    System.out.println("22.332^-8=" + Math.pow(22.332, -8) + "/" + pow(22.332, -8));

  }

}
