package fb.permutation;

import java.util.*;

/**
 * Subsets
 * Given a set of distinct integers, S, return all possible subsets.
 * <p/>
 * For example,
 * If S = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * » Solve this problem
 * <p/>
 * Similar to Combination problem
 *
 * @author: mindpower
 * @created: 4/22/12-10:14 AM
 */
public class SubSet {
  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    subsets(S, 0, new ArrayList<Integer>(), result);
    return result;
  }

  void subsets(int[] S, int pos, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
    result.add(new ArrayList<Integer>(current));
    if (pos == S.length) return;
    for (int i = pos; i < S.length; i++) {
      current.add(S[i]);
      subsets(S, i + 1, current, result);
      current.remove(current.size() - 1);
    }
  }
}
