package fb.dp;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

public interface Jump {
  public int jump(int[] A);
}


class JumpTest {
  public static void main(String args[]) {
    Jump[] jumps = {  new Jump_Backtracking_Stop_At_GlobalMin(), new Jump_DP_forward(), new Jump_DP_backward()};
    int[] test = new int[]{6, 7, 4, 3, 2, 0, 9, 8, 9, 9, 9, 6, 8, 3, 7, 5, 3, 3, 5, 3, 7, 2, 1, 3, 9, 2, 7, 0, 0, 9, 0, 6, 6, 4, 9, 8, 6, 0, 9, 5, 0, 0, 4, 8, 5, 3, 5, 8, 6, 1, 4, 5, 5, 5, 1, 6, 7, 8, 6, 9, 8, 8, 7, 6, 2, 6, 7, 8, 9, 8, 6, 9, 8, 2, 9, 3, 5, 5, 1, 1, 8, 7, 6, 5, 3, 7, 1, 2};
    for (Jump j:jumps) {
      long t = System.nanoTime();
      System.out.println(j.jump(test));
      System.out.println( j.getClass().getCanonicalName ()+ " took "+(System.nanoTime()-t)/1000 + " ms");
    }

  }

}

/**
 * @author jbu
 * @since 3/23/12 4:53 PM
 */
class Jump_BackTracking implements Jump {
  // back tacking, time consuming,
  public int jump(int[] A) {
    if (A.length <= 1) {
      return 0;
    }
    return doJump(A, 0);
  }

  int doJump(int[] A, int pos) {
    if (pos == A.length - 1) {
      return 0;
    }
    int min = Integer.MAX_VALUE, steps;
    for (int i = 1; i <= A[pos]; i++) {
      if (pos + i < A.length) {
        steps = doJump(A, pos + i);
        if (steps < min) {
          min = steps;
        }
      }
    }
    return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + min;
  }
}

class Jump_Backtracking_Stop_At_GlobalMin implements  Jump{

  // back track which stops earlier by global min
  public int jump(int[] A) {
    if (A.length <= 1) {
      return 0;
    }
    doJump(A, 0, 0);
    return min;
  }

  int min = Integer.MAX_VALUE;

  void doJump(int[] A, int pos, int steps) {
    if (pos == A.length - 1) {
      if (steps < min) {
        min = steps;
      }
      return;
    }
    if (steps >= min) {
      return;
    }
    for (int i = 1; i <= A[pos]; i++) {
      if (pos + i < A.length) {
        doJump(A, pos + i, steps + 1);
      }
    }
  }
}

class Jump_DP_forward implements Jump {
  // DP
  public int jump(int[] A) {
    if (A.length <= 1) {
      return 0;
    }
    int s[] = new int[A.length];
    Arrays.fill(s, Integer.MAX_VALUE);
    s[0] = 0;
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = 1; j <= A[i]; j++) {
        if (i + j > A.length - 1) {
          break;
        }
        s[i + j] = s[i] + 1 < s[i + j] ? s[i] + 1 : s[i + j];
      }
    }
    return s[s.length - 1];
  }
}

/**
 * @author: mindpower
 * @created: 4/21/12-2:15 PM
 */
class Jump_DP_backward implements  Jump {
  public int jump(int[] A) {
    int[] min = new int[A.length];
    Arrays.fill(min, 10000);
    min[A.length - 1] = 0;
    for (int i = A.length - 2; i >= 0; i--) {
      int step = A[i];
      if (step <= 0) {
        continue;
      }
      if (i + step >= A.length - 1) {
        min[i] = 1;
      }
      else {
        for (int j = 1; j <= step; j++) {
          min[i] = Math.min(min[i], 1 + min[i + j]);
        }
      }
    }
    return min[0];
  }
}

