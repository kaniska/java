package fb.array;

import java.util.Arrays;

/**
 * @author jbu
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int min = Integer.MAX_VALUE;
    Arrays.sort(num);
    int len = num.length;
    for (int i = 0; i < len; i++) {
      int j = i + 1, k = len - 1;
      while (j < k) {
        int r = (num[j] + num[k] + num[i]);
        if (r - target == 0) return target;
        if (Math.abs(r - target) < Math.abs(min)) {
          min = r - target;
        }
        if (r < target) {
          j++;
        } else {
          k--;
        }
      }
    }
    return target + min;

  }
}
