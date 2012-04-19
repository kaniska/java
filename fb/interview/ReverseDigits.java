package fb.interview;

/**
 * @author jbu
 */
public class ReverseDigits {
  public static int reverse(int x) {
    int r =0;
    boolean neg = false;
    if (x<0) {
      neg = true;
      x = x *(-1);
    }
    while (x!=0) {
      r = r *10 + (x % 10);
      x = x/10;
    }
    return neg? r*(-1):r;
  }

  public static void main(String args[]) {
    System.out.println("890 -->"+reverse(890));
    System.out.println("-890 -->"+reverse(-890));
    System.out.println("1231978 -->"+reverse(1231978));
    System.out.println("1231912371 -->"+reverse(1231912371));

  }


}
