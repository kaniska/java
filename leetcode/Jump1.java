package leetcode;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 4:53 PM
 */
public class Jump1 {
  // back filling, time consuming,
  public int jump(int[] A) {
    if (A.length <= 1) return 0;
    return doJump(A, 0);
  }

  int doJump(int[] A, int pos) {
    if (pos == A.length - 1) return 0;
    int min = Integer.MAX_VALUE, steps;
    for (int i = 1; i <= A[pos]; i++) {
      if (pos + i < A.length) {
        steps = doJump(A, pos + i);
        if (steps < min) min = steps;
      }
    }
    return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + min;
  }




}
