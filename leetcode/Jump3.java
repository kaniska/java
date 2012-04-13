package leetcode;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 5:29 PM
 */
public class Jump3 {

  // back track which stops earlier by global min
  public int jump(int[] A) {
    if (A.length <= 1) return 0;
    doJump(A, 0, 0);
    return min;
  }

  int min = Integer.MAX_VALUE;

  void doJump(int[] A, int pos, int steps) {
    if (pos == A.length - 1) {
        if (steps<min) min=steps;
        return;
    }
    if (steps>=min) return;
    for (int i = 1; i <= A[pos]; i++) {
      if (pos + i < A.length) {
        doJump(A, pos + i, steps+1);
      }
    }
  }

  public static void main(String args[]) {
    System.out.println(new Jump3().jump(new int[]{6,7,4,3,2,0,9,8,9,9,9,6,8,3,7,5,3,3,5,3,7,2,1,3,9,2,7,0,0,9,0,6,6,4,9,8,6,0,9,5,0,0,4,8,5,3,5,8,6,1,4,5,5,5,1,6,7,8,6,9,8,8,7,6,2,6,7,8,9,8,6,9,8,2,9,3,5,5,1,1,8,7,6,5,3,7,1,2}));
  }

}
