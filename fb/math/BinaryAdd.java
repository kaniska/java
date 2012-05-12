package fb.math;

/**
 * @author jbu
 */
public class BinaryAdd {
  public static char[] bstAdd(char[] a, char[] b) {
    int carry = 0;
    char[] r = new char[Math.max(a.length, b.length) + 1];
    int n1, n2;
    for (int i = a.length - 1, j = b.length - 1, x = r.length - 1; x >= 0; i--, j--, x--) {
      n1 = i >= 0 ? a[i] - '0' : 0;
      n2 = j >= 0 ? b[j] - '0' : 0;
      r[x] = (char) ((n1 ^ n2 ^ carry) + '0');
      carry = (n1 + n2 + carry) >> 1;
      System.out.println("n1=" + n1 + ";n2=" + n2 + ";r[x]=" + r[x] + ";carry=" + carry);
    }
    return r;
  }

  public static void main(String args[]) {
    System.out.println(bstAdd("11".toCharArray(), "1".toCharArray()));
    System.out.println(bstAdd("11000100111".toCharArray(), "100101".toCharArray()));
  }
}
