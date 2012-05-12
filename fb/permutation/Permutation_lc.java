package fb.permutation;

import java.util.*;

public class Permutation_lc {
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    boolean[] used = new boolean[num.length];
    int[] current = new int[num.length];
    doPermutation(num, 0, used, current, result);
    return result;
  }

  void doPermutation(int[] num, int pos, boolean[] used, int[] current, ArrayList<ArrayList<Integer>> result) {
    if (pos == num.length) {
      ArrayList<Integer> one = new ArrayList<Integer>();
      for (int i = 0; i < current.length; i++) {
        one.add(current[i]);
      }
      result.add(one);
      return;
    }
    for (int i = 0; i < used.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      current[pos] = num[i];
      doPermutation(num, pos + 1, used, current, result);
      used[i] = false;
    }
  }
}