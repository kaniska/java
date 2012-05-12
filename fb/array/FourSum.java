package fb.array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p/>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p/>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 * @author jbu
 */

public interface FourSum {
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target);
}

class FourSumTest {
  public static void main(String[] args) {
    FourSum f = new FourSum_Solution();
    f.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
  }
}

class FourSum_Solution implements FourSum {
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    // important! edge case
    if (num.length < 4) {
      return ret;
    }
    Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    // key-sum, value-index pair
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < num.length - 1; i++) {
      for (int j = i + 1; j < num.length; j++) {
        int sum = num[i] + num[j];
        List<Integer> list = (map.containsKey(sum)) ?
            map.get(sum) : new ArrayList<Integer>();
        list.add(i << 16 | j);
        map.put(sum, list);
      }
    }
    for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
      Integer key = e.getKey();
      List<Integer> l1 = e.getValue();
      if (map.containsKey(target - key)) {
        List<Integer> l2 = map.get(target - key);
        for (Integer p1 : l1) {
          for (Integer p2 : l2) {
            int i = p1 >> 16;
            int j = 0x0000FFFF & p1;
            int m = p2 >> 16;
            int n = 0x0000FFFF & p2;
            if (i != m && i != n && j != m && j != n) {
              //System.out.println(String.format("%s, %s, %s, %s", i,j,m,n));
              Integer[] array = new Integer[]{num[i], num[j], num[m], num[n]};
              Arrays.sort(array);
              set.add(new ArrayList<Integer>(Arrays.asList(array)));
            }
          }
        }
      }
    }
    ret.addAll(set);
    return ret;
  }
}
//
///**
// * Also tried using HashMap to look up , but seems not working
// * Since two sum could have duplicates
// * OK, Now it's working, however it still time out on large test cases (which is similar to the O(n^2*n) simple linear search of the p array solution
// */
//class FourSum_Hash implements FourSum {
//  /**
//   * @since 04/20/2012
//   */
//  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
//    int n = num.length;
//    Arrays.sort(num);
//    int[] p = new int[n * (n - 1) / 2];
//    int ix1[] = new int[p.length], ix2[] = new int[p.length];
//    int k = 0;
//    for (int i = 0; i < n - 1; i++) {
//      for (int j = i + 1; j < n; j++) {
//        p[k] = num[i] + num[j];
//        ix1[k] = i;
//        ix2[k++] = j;
//      }
//    }
//    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//    Map<Integer, ArrayList<Integer>> s = new HashMap<Integer, ArrayList<Integer>>();
//    for (int i = 0; i < p.length; i++) {
//      if (s.containsKey(target - p[i])) {
//        for (int j : s.get(target - p[i])) {
//          if (ix2[j] < ix1[i]) {
//            ArrayList<Integer> one = new ArrayList<Integer>();
//            one.add(num[ix1[j]]);
//            one.add(num[ix2[j]]);
//            one.add(num[ix1[i]]);
//            one.add(num[ix2[i]]);
//            result.add(one);
//          }
//        }
//      }
//      else if (s.containsKey(p[i])) {
//        s.get(p[i]).add(i);
//      }
//      else {
//        s.put(p[i], new ArrayList<Integer>(Arrays.asList(i)));
//      }
//    }
//    return new ArrayList<ArrayList<Integer>>(result);
//  }
//}
///**
// * NOT WORKING
// * this seems fail some of the test cases in lc
// * OK, I see the problem is because the two sum array is NOT sorted even we sorted the original array
// */
//class FourSum_BinarySearch implements FourSum {
//  /**
//   * @since 04/20/2012
//   */
//  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
//    int n = num.length;
//    Arrays.sort(num);
//    int[] p = new int[n * (n - 1) / 2];
//    int ix1[] = new int[p.length], ix2[] = new int[p.length];
//    int k = 0;
//    for (int i = 0; i < n - 1; i++) {
//      for (int j = i + 1; j < n; j++) {
//        p[k] = num[i] + num[j];
//        ix1[k] = i;
//        ix2[k++] = j;
//      }
//    }
//    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//    Set<Integer> s = new HashSet<Integer>();
//    for (int i = 0; i < p.length; i++) {
//      int j = i;
//      while (true) {
//        j = Arrays.binarySearch(p, j + 1, p.length, target - p[i]);
//        if (j < 0) {
//          break;
//        }
//        if (ix2[i] < ix1[j]) {
//          ArrayList<Integer> one = new ArrayList<Integer>();
//          one.add(num[ix1[i]]);
//          one.add(num[ix2[i]]);
//          one.add(num[ix1[j]]);
//          one.add(num[ix2[j]]);
//          result.add(one);
//        }
//      }
//    }
//    return new ArrayList<ArrayList<Integer>>(result);
//  }
//}
//
///**
// * WORKING BUT WILL FAIL LARGE TEST  (TIME OUT)
// */
//class FourSum_Backtracking implements FourSum {
//  /**
//   * Back fill, exponential , similar to brute force in this case ,
//   * Since we specially need four sum, this solution does not specifically address that
//   *
//   * @param num
//   * @param target
//   * @return
//   */
//  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
//    Arrays.sort(num);
//    HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//    doCheck(num, target, 0, new ArrayList<Integer>(), result);
//    return new ArrayList<ArrayList<Integer>>(result);
//  }
//
//  void doCheck(int[] num, int target, int pos, ArrayList<Integer> current, HashSet<ArrayList<Integer>> result) {
//    if (current.size() == 4) {
//      if (target == 0) {
//        result.add(new ArrayList<Integer>(current));
//        return;
//      }
//      else {
//        return;
//      }
//    }
//    for (int i = pos; i < num.length; i++) {
//      if (num[i] <= target) {
//        current.add(num[i]);
//        doCheck(num, target - num[i], i + 1, current, result);
//        current.remove(current.size() - 1);
//      }
//    }
//  }
//}
///*****  NOT WORKING ******/
//
///**
// * @since 04/20/2012  Using a Tuple class and sort the two sum array first before binary search
// *        OK, it's still not working.
// *        It comes out that Binary Search has  no guarantee which one will be found
// *        If the array contains multiple elements equal to the specified object
// */
//class FourSum_Using_Tuple implements FourSum {
//
//  static class Tuple implements Comparable<Tuple> {
//    int val, i, j; // i, j is the original index
//
//    public Tuple(int val, int i, int j) {
//      this.val = val;
//      this.i = i;
//      this.j = j;
//    }
//
//    public int compareTo(Tuple t) {
//      return this.val - t.val;
//    }
//  }
//
//  /**
//   * @param num
//   * @param target
//   * @return
//   */
//  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
//    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//    int n = num.length;
//    if (n == 0) {
//      return new ArrayList<ArrayList<Integer>>(result);
//    }
//    Tuple[] p = new Tuple[n * (n - 1) / 2];
//    int k = 0;
//    for (int i = 0; i < n - 1; i++) {
//      for (int j = i + 1; j < n; j++) {
//        p[k++] = new Tuple(num[i] + num[j], i, j);
//      }
//    }
//    Arrays.sort(p);
//    for (int i = 0; i < p.length; i++) {
//      int j = i;
//      while (true) {
//        j = Arrays.binarySearch(p, j + 1, p.length, new Tuple(target - p[i].val, 0, 0));
//        if (p[i].j < p[j].i) {
//          ArrayList<Integer> one = new ArrayList<Integer>();
//          one.add(num[p[i].i]);
//          one.add(num[p[i].j]);
//          one.add(num[p[j].i]);
//          one.add(num[p[j].j]);
//          result.add(one);
//        }
//      }
//    }
//    return new ArrayList<ArrayList<Integer>>(result);
//  }
//}
//
