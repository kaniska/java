package fb.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author jbu
 */
public class FourSum {
  /**
   * Back fill, exponential , similar to brute force in this case ,
   * Since we specially need four sum, this solution does not specifically address that
   *
   * @param num
   * @param target
   * @return
   */
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    doCheck(num, target, 0, new ArrayList<Integer>(), result);
    return new ArrayList<ArrayList<Integer>>(result);
  }

  void doCheck(int[] num, int target, int pos, ArrayList<Integer> current, HashSet<ArrayList<Integer>> result) {
    if (current.size() == 4) {
      if (target == 0) {
        result.add(new ArrayList<Integer>(current));
        return;
      } else return;
    }
    for (int i = pos; i < num.length; i++) {
      if (num[i] <= target) {
        current.add(num[i]);
        doCheck(num, target - num[i], i + 1, current, result);
        current.remove(current.size() - 1);
      }
    }
  }
}
