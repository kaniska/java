package fb.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 3Sum
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 * @author jbu
 */
public class ThreeSum {

    /**
     * (1) Sort first  O(nlogn)
     * (2) Two loop, O(n*n) to check
     * @param num
     * @return
     */
  public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    if (num == null || num.length == 0) return new ArrayList<ArrayList<Integer>>();
    Arrays.sort(num);

    for (int i = 0; i < num.length; i++) {
      if (num[i] > 0 || (i > 0 && num[i] == num[i - 1])) continue;
      int j = i + 1, k = num.length - 1;
      while (j < k) {
        if (num[j] + num[k] > -num[i]) {
          k--;
        } else if (num[j] + num[k] < -num[i]) {
          j++;
        } else {
          ArrayList<Integer> one = new ArrayList<Integer>();
          one.add(num[i]);
          one.add(num[j]);
          one.add(num[k]);
          result.add(one);
          j++;
          k--;
        }
      }

    }

    ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    r.addAll(result);
    return r;
  }
}
