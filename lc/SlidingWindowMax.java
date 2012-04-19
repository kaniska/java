package lc;

import java.util.ArrayDeque;

/**
 * @author jbu
 */
public class SlidingWindowMax {
  public int[] slidingWindowMax(int[] a, int w) {
    int len = a.length;
    int[] m = new int[len - w + 1];
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    for (int i = 0; i < w; i++) {
      while (!deque.isEmpty() && a[deque.peekLast()] <= a[i]) deque.removeLast();
      deque.addLast(i);
    }
    m[0] = deque.removeFirst();

    for (int i = w; i < len; i++) {
      while (!deque.isEmpty() && deque.peekFirst() <= i - w) deque.removeFirst();
      while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) deque.removeLast();
      deque.addLast(i);
      m[i - w + 1] = deque.peekFirst();
    }
    return m;
  }


}
