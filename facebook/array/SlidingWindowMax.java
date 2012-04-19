package facebook.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jbu
 */
public class SlidingWindowMax {
  public static void main(String args[]) {
    getWindowMax(new int[]{2,3,4,2,6,7,8,2,4,1,2,3},3 );
  }


  public static int[] getWindowMax(int[] a, int w) {
    int[] b = new int[a.length - w + 1];

    ArrayDeque<Integer> q = new ArrayDeque<Integer>();
    for (int i = 0; i < w; i++) {
      while (!q.isEmpty() && a[q.peekLast()] <= a[i]) {
        q.removeLast();
      }
      q.addLast(i);
    }

    b[0] = a[q.peekFirst()];
    for (int i = w; i < a.length; i++) {
      while (!q.isEmpty() && q.peekFirst() <= i - w) {
        q.removeFirst();
      }
      while (!q.isEmpty() && a[q.peekLast()] <= a[i]) {
        q.removeLast();
      }
      q.addLast(i);
      b[i - w + 1] = a[q.peekFirst()];
    }

    System.out.println(Arrays.toString(b));
    return b;
  }
}
