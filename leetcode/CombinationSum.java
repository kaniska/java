package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
Combination Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … ,ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
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
