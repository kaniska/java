package fb.array;

/**
 * find max sum with sequence not adjacent
 * @author jbu
 */
public class FindMaxSequence {
  public static int find(int[] a) {
    int len = a.length;
    if (len == 1) {
      return a[0];
    }
    if (len == 2) {
      return a[0] > a[1] ? a[0] : a[1];
    }
    if (len == 3) {
      return a[0] + a[2] > a[1] ? a[0] + a[2] : a[1];
    }
    int[] max = new int[len];
    max[0] = a[0];
    max[1] = a[1];
    max[2] = a[0] + a[2];
    int mm = max[2] > max[1] ? max[2] : max[1];

    for (int i = 3; i < len; i++) {
      max[i] = Math.max(max[i - 2] + a[i], max[i - 3] + a[i]);
      if (max[i] > mm) {
        mm = max[i];
      }
    }

    return mm;
  }

  public static int findSimple(int[] a) {
    if (a == null || a.length == 0) {
      return -1;
    }
    int len = a.length;
    if (len == 1) {
      return a[0];
    }
    if (len == 2) {
      return Math.max(a[0], a[1]);
    }
    int[] max = new int[len];
    max[0] = a[0];
    max[1] = a[1];
    max[2] = a[0] + a[2];
    for (int i = 3; i < len; i++) {
      max[i] = Math.max(max[i - 2], max[i - 3]) + a[i];
    }
    return Math.max(max[len - 1], max[len - 2]);
  }

  /**
   * http://nthrgeek.wordpress.com/2009/10/09/maximum-non-contiguous-subsequence/
   * int MaxNoncontSum(int buf[],size_t cnt)
   * {
   * int incl = 0,    // max sequence including the previous item
   * excl = 0,   // max sequence excluding the previous item
   * excl_new = 0;
   * <p/>
   * size_t i;
   * <p/>
   * for(i = 0; i<cnt; i++)
   * {
   * excl_new = max(incl,excl); // current max excluding i
   * <p/>
   * incl = excl + buf[i]; // current max including i
   * excl = excl_new;
   * }
   * <p/>
   * return max(incl,excl);
   * }
   *
   * @param a
   * @return
   */
  public static int findAnother(int[] a) {
    int incl = 0, excl = 0, excl_new;
    for (int i = 0; i < a.length; i++) {
      excl_new = Math.max(incl, excl);
      incl = excl + a[i];
      excl = excl_new;
    }
    return Math.max(incl, excl);

  }

  public static void main(String args[]) {
    int[] a = new int[0];

    System.out.println(find(new int[]{1, 51, 3, 1, 100, 199, 3}));
    System.out.println(find(new int[]{1, 2, 3, 4, 5, 6}));
    System.out.println(find(new int[]{1, 51, 3, 2, 41, 23, 20}));
    System.out.println(find(new int[]{1, 3, 1, 3, 100}));
    System.out.println(find(new int[]{3, 2, 7, 10}));
    System.out.println(find(new int[]{3, 2, 5, 7, 10}));
    System.out.println();

    System.out.println(findSimple(new int[]{1, 51, 3, 1, 100, 199, 3}));
    System.out.println(findSimple(new int[]{1, 2, 3, 4, 5, 6}));
    System.out.println(findSimple(new int[]{1, 51, 3, 2, 41, 23, 20}));
    System.out.println(findSimple(new int[]{1, 3, 1, 3, 100}));
    System.out.println(findSimple(new int[]{3, 2, 7, 10}));
    System.out.println(findSimple(new int[]{3, 2, 5, 7, 10}));
    System.out.println();

    System.out.println(findAnother(new int[]{1, 51, 3, 1, 100, 199, 3}));
    System.out.println(findAnother(new int[]{1, 2, 3, 4, 5, 6}));
    System.out.println(findAnother(new int[]{1, 51, 3, 2, 41, 23, 20}));
    System.out.println(findAnother(new int[]{1, 3, 1, 3, 100}));
    System.out.println(findAnother(new int[]{3, 2, 7, 10}));
    System.out.println(findAnother(new int[]{3, 2, 5, 7, 10}));
    System.out.println();

  }

}
