package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author jbu
 */
public class CombinationSum {
  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    doCombinationSum(candidates, target, 0, new ArrayList<Integer>(), result);
    return new ArrayList<ArrayList<Integer>>(result);
  }

  void doCombinationSum(int[] candidates, int target, int pos, ArrayList<Integer> current, HashSet<ArrayList<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<Integer>(current));
      return;
    }
    for (int i = pos; i < candidates.length; i++) {
      if (candidates[i] <= target) {
        current.add(candidates[i]);
        doCombinationSum(candidates, target - candidates[i], i, current, result);
        current.remove(current.size() - 1);
      }
    }
  }
}
