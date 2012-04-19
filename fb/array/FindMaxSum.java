package fb.array;

/**
 * @author jbu
 */
public class FindMaxSum {
  public static void main(String args[]) {
    int[] a = {12, -23, 123, 12, 213123123, -23432, 1231231, 12, 12, 12, -34, -23423, 2123};
    System.out.println(max(a));
  }

  public static int max(int[] a) {
    int curMax = 0, max= 0;
    for (int i=0;i<a.length;i++) {
      curMax = curMax>0? curMax+a[i]:a[i];
      max = max>curMax? max:curMax;
    }
    return max;
  }

}
