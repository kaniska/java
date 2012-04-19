package scjp;

/**
 * @author jbu
 */
public class AA {

  static boolean bb = true;
  final static boolean bbb = true;


  public static void A(int x, boolean a) {
    int i;

    final boolean b = true;

    if (bbb) {
      i = 4;
    }

    System.out.println(i);

  }

  public static void main(String args[]) {
  }
}