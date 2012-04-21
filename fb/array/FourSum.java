package fb.array;


import java.util.*;

/**
 * @author jbu
 */
public class FourSum {
  public static void main(String[] args) {
    FourSum f = new FourSum();
    f.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
  }

  /**
   * Back fill, exponential , similar to brute force in this case ,
   * Since we specially need four sum, this solution does not specifically address that
   *
   * @param num
   * @param target
   * @return
   */
  public ArrayList<ArrayList<Integer>> fourSum_brute_force(int[] num, int target) {
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

  /**
   * @param num
   * @param target
   * @return
   * @since 04/20/2012  Using a Tuple class and sort the two sum array first before binary search
   *        OK, it's still not working.
   *        It comes out that Binary Search has  no guarantee which one will be found
   *        If the array contains multiple elements equal to the specified object
   */
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

    int n = num.length;
    if (n == 0) return new ArrayList<ArrayList<Integer>>(result);
    Tuple[] p = new Tuple[n * (n - 1) / 2];
    int k = 0;
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++) {
        p[k++] = new Tuple(num[i] + num[j], i, j);
      }
    Arrays.sort(p);
    for (int i = 0; i < p.length; i++) {
      int j = i;
      while (true) {
        j = Arrays.binarySearch(p, j + 1, p.length, new Tuple(target - p[i].val, 0, 0));
        if (p[i].j < p[j].i) {
          ArrayList<Integer> one = new ArrayList<Integer>();
          one.add(num[p[i].i]);
          one.add(num[p[i].j]);
          one.add(num[p[j].i]);
          one.add(num[p[j].j]);
          result.add(one);
        }
      }
    }
    return new ArrayList<ArrayList<Integer>>(result);
  }

  /**
   * this seems fail some of the test cases in lc
   * OK, I see the problem is because the two sum array is NOT sorted even we sorted the original array
   *
   * @param num
   * @param target
   * @return
   * @since 04/20/2012
   */
  public ArrayList<ArrayList<Integer>> fourSum_binarySearch(int[] num, int target) {
    int n = num.length;
    Arrays.sort(num);
    int[] p = new int[n * (n - 1) / 2];
    int ix1[] = new int[p.length], ix2[] = new int[p.length];
    int k = 0;
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++) {
        p[k] = num[i] + num[j];
        ix1[k] = i;
        ix2[k++] = j;
      }
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    Set<Integer> s = new HashSet<Integer>();
    for (int i = 0; i < p.length; i++) {
      int j = i;
      while (true) {
        j = Arrays.binarySearch(p, j + 1, p.length, target - p[i]);
        if (j < 0) break;
        if (ix2[i] < ix1[j]) {
          ArrayList<Integer> one = new ArrayList<Integer>();
          one.add(num[ix1[i]]);
          one.add(num[ix2[i]]);
          one.add(num[ix1[j]]);
          one.add(num[ix2[j]]);
          result.add(one);
        }
      }
    }
    return new ArrayList<ArrayList<Integer>>(result);
  }


  /**
   * @param num
   * @param target
   * @return
   * @since 04/20/2012
   *        Also tried using HashMap to look up , but seems not working
   *        Since two sum could have duplicates
   *        OK, Now it's working, however it still time out on large test cases (which is similar to the O(n^2*n) simple linear search of the p array solution
   */
  public ArrayList<ArrayList<Integer>> fourSum_hash(int[] num, int target) {
    int n = num.length;
    Arrays.sort(num);
    int[] p = new int[n * (n - 1) / 2];
    int ix1[] = new int[p.length], ix2[] = new int[p.length];
    int k = 0;
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++) {
        p[k] = num[i] + num[j];
        ix1[k] = i;
        ix2[k++] = j;
      }
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    Map<Integer, ArrayList<Integer>> s = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < p.length; i++) {
      if (s.containsKey(target - p[i])) {
        for (int j : s.get(target - p[i]))
          if (ix2[j] < ix1[i]) {
            ArrayList<Integer> one = new ArrayList<Integer>();
            one.add(num[ix1[j]]);
            one.add(num[ix2[j]]);
            one.add(num[ix1[i]]);
            one.add(num[ix2[i]]);
            result.add(one);
          }
      } else if (s.containsKey(p[i])) {
        s.get(p[i]).add(i);
      } else {
        s.put(p[i], new ArrayList<Integer>(Arrays.asList(i)));
      }
    }
    return new ArrayList<ArrayList<Integer>>(result);
  }
}


class Tuple implements Comparable<Tuple> {
  int val, i, j; // i, j is the original index

  public Tuple(int val, int i, int j) {
    this.val = val;
    this.i = i;
    this.j = j;
  }

  public int compareTo(Tuple t) {
    return this.val - t.val;
  }
}