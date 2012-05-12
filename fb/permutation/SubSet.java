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
    LinkedList<Integer> current = new LinkedList<Integer>();
    result.add(new ArrayList<Integer>(current));
    doCombination(S, 0, 0, current, result);
    return result;
  }

  void doCombination(int[] S, int pos, int start, LinkedList<Integer> current,
                     ArrayList<ArrayList<Integer>> result)
  {
    for (int i = start; i < S.length; i++) {
      current.addLast(S[i]);
      result.add(new ArrayList(current));
      doCombination(S, pos + 1, i + 1, current, result);
      current.removeLast();
    }
  }
}
