package fb.array;

import java.util.Arrays;

/**
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author jbu
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] num, int target) {
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
