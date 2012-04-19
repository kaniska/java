package fb.math;

/**
 * @author jbu
 */
public class Root {
  public static double sqrt(double d) {
    if (d<0) return Double.NaN;
    double x = d;
    while (Math.abs(x*x-d)>0.0001) {
      x = (x+d/x)/2;
    }
    return x;
  }


  public static double cubic(double d) {
    if (d<0) return Double.NaN;
    if (d==0) return 0;
    if (d==1) return 1;
    double low =0, high=d;
    if (d<1) {
      low =d;
      high =1;
    }
    double result = (high+low)/2;
    while (Math.abs(result*result*result-d)>0.0001) {
      if (result*result*result>d) {
        high = result;
      } else {
        low = result;
      }
      result =(high+low)/2;
    }
    return result;
  }

    public static double cubicNewton(double d) {
    if (d<0) return Double.NaN;
    if (d==0) return 0;
    if (d==1) return 1;
    double result = d/3;
    while (Math.abs(result*result*result-d)>0.0001) {
      result = (d/(result*result)+2*result)/3;
    }
    return result;
  }

  public static void main(String args[]) {
    System.out.println(sqrt(12312));
    int start=123123213;
    for (int i=start;i<=start+10;i++)
      System.out.println(cubic(i));
    System.out.println(cubic(0.1234));
    System.out.println(cubic(0.789));


    for (int i=start;i<=start+10;i++)
      System.out.println(cubicNewton(i));
    System.out.println(cubicNewton(0.1234));
    System.out.println(cubicNewton(0.789));

  }
}
