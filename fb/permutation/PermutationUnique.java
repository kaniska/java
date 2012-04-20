package fb.permutation;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

public class PermutationUnique {
  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    boolean[] used = new boolean[num.length];
    int[] current = new int[num.length];
    Arrays.sort(num);
    doPermutation(num, 0, used, current, result);
    return new ArrayList<ArrayList<Integer>>(result);
  }


  void doPermutation(int[] num, int pos, boolean[] used, int[] current, Set<ArrayList<Integer>> result) {
    if (pos == num.length) {
      ArrayList<Integer> one = new ArrayList<Integer>();
      for (int i = 0; i < current.length; i++) one.add(current[i]);
      result.add(one);
      return;
    }
    for (int i = 0; i < used.length; i++) {
      if (used[i] || (i > 0 && num[i] == num[i - 1] && used[i - 1] == false)) continue;
      used[i] = true;
      current[pos] = num[i];
      doPermutation(num, pos + 1, used, current, result);
      used[i] = false;
    }
  }
}
