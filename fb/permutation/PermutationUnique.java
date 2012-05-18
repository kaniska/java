package fb.permutation;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

public interface PermutationUnique {
  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num);
}

class PermutationUnqiue_NextPermutation implements PermutationUnique {
  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    do {
      ArrayList<Integer> one = new ArrayList<Integer>();
      for (int i = 0; i < num.length; i++) one.add(num[i]);
      result.add(one);
    }
    while (nextPermutation(num));
    return result;
  }

  public boolean nextPermutation(int[] num) {
    // from back to front, find one number  is smaller than the one after it (head)
    int len = num.length, head = len - 2;
    while (head >= 0 && num[head] >= num[head + 1]) {
      head--;
    }
    // if head==-1, return (can't find)
    if (head == -1) {
//      reverse(num, 0, len - 1);
      return false;
    }
    // from back to (head-1), find first number that is larger than (head), call is tail
    int tail = len - 1;
    while (num[tail] <= num[head]) {
      tail--;
    }
    // exchange head with tail
    swap(num, head, tail);
    // reverse from head+1 to end
    reverse(num, head + 1, len - 1);
    return true;
  }

  private void swap(int[] num, int i, int j) {
    int t = num[i];
    num[i] = num[j];
    num[j] = t;
  }

  private void reverse(int[] num, int i, int j) {
    for (int k = i; k < (j + i) / 2 + 1; k++) {
      swap(num, k, i + j - k);
    }
  }
}

class PermutationUnique_Recursive implements PermutationUnique {
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
      for (int i = 0; i < current.length; i++) {
        one.add(current[i]);
      }
      result.add(one);
      return;
    }
    for (int i = 0; i < used.length; i++) {
      if (used[i] || (i > 0 && num[i] == num[i - 1] && !used[i - 1])) {
        continue;
      }
      used[i] = true;
      current[pos] = num[i];
      doPermutation(num, pos + 1, used, current, result);
      used[i] = false;
    }
  }
}
