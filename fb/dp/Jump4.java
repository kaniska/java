package fb.dp;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-2:15 PM
 */
public class Jump4 {
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
