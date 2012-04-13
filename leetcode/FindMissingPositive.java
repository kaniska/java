package leetcode;

import java.util.*;

/**
 * @author jbu
 */
public class FindMissingPositive {

  /**
   * brute force; sort first, O(nlogN);
   *
   * @param A
   * @return
   */
//  public int firstMissingPositive(int[] A) {
//    if (A.length == 0) return 1;
//    Arrays.sort(A);
//    if (A[0] > 1) return 1;
//
//    for (int i = 1; i < A.length; i++) {
//      if (A[i] <= 0) continue;
//      if (A[i] > 0 && A[i - 1] <= 0) {
//        if (A[i] > 1) return 1;
//      } else if (A[i] - A[i - 1] > 1) return A[i - 1] + 1;
//    }
//    return A[A.length - 1] + 1;
//  }

  /**
   * http://yewenxing.wordpress.com/2012/03/13/first-missing-positive/
   */
  public int firstMissingPositive(int[] A) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
      while (A[i] != i) {
        if (A[i] < 0 || A[i] >= n || A[i] == A[A[i]]) break;
        int temp = A[i];
        A[i] = A[temp];
        A[temp] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      if (A[i] != i && i != 0) return i;
    }
    return n;
  }
}

