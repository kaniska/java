package fb.array;

import java.util.Arrays;

/**
 * @author jbu
 */
public class MergeTwoArray {
  /*
   * a.length=n , b.length=2n
   */
  public static int[] merge(int[] a, int[] b) {
    int n1 = a.length;
    int n2 = b.length;
    assert (n2 == n1 * 2);
    int i2 = n1 - 1, i1 = n1 - 1, c = n2 - 1;
    while (i1 >= 0 && i2 >= 0) {
      if (a[i1] >= b[i2]) {
        b[c--] = a[i1--];
      } else {
        b[c--] = b[i2--];
      }
    }
    while (i1>=0) b[c--]=a[i1--];
    return b;
  }

  public static void main(String args[]) {
    int[] a = {1, 2, 4, 5, 6, 8, 12, 44, 45, 78};
    int[] c = {4, 8, 12, 13, 18, 19, 22, 30, 40, 45};
    int[] b = new int[a.length * 2];
    System.arraycopy(c, 0, b, 0, c.length);

    System.out.println(Arrays.toString(merge(a, b)));
  }

}
