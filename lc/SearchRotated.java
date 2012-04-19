package lc;

/**
 * @author jbu
 */
public class SearchRotated {
  public int search(int[] A, int target) {

    return search(A, 0, A.length - 1, target);
  }

  public int search(int[] A, int l, int u, int target) {
    if (l >= u) {
      if (A[l] == target) return l;
      else return -1;
    }
    // l<u at least 2 elements
    int m = (l + u) / 2;
    if (A[m] == target) return m;

    if (A[l] <= A[m]) {
      if (target < A[m] && target >= A[l]) return search(A, l, m - 1, target);
      else return search(A, m + 1, u, target);
    } else {
      if (target <= A[u] && target > A[m]) return search(A, m + 1, u, target);
      else return search(A, l, m - 1, target);
    }

  }

}
