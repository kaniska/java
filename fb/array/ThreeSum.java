package fb.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jbu
 */
public class ThreeSum {

  public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    // Start typing your Java solution below
    // DO NOT write main() function
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
