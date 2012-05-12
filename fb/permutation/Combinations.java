package fb.permutation;

import java.util.ArrayList;

/**
 * @author: mindpower
 * @since: 5/12/12-9:47 AM
 */
public class Combinations {
  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    doCombine(n, k, 0, 1, new ArrayList<Integer>(), result);
    return result;
  }

  private void doCombine(int n, int k, int pos, int start, ArrayList<Integer> current,ArrayList<ArrayList<Integer>> result)
  {
    if (pos == k) {
      result.add(new ArrayList<Integer>(current));
      return;
    }
    for (int i = start; i <= n; i++) {
      current.add(i);
      doCombine(n, k, pos + 1, i + 1, current, result);
      current.remove(current.size() - 1);
    }
  }
}
