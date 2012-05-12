package fb.array;

/**
 * @author jbu
 */
public class SearchRange {
  public int[] searchRange(int[] A, int target) {
    return search(A, 0, A.length - 1, target);
  }

  int[] search(int[] A, int l, int h, int target) {
    if (l >= h) {
      return A[l] == target ? new int[]{l, l} : new int[]{-1, -1};
    }
    int m = (l + h) / 2;
    if (A[m] == target) {
      int[] left = search(A, l, m - 1, target);
      int[] right = search(A, m + 1, h, target);
      return new int[]{left[0] == -1 ? m : left[0], right[1] == -1 ? m : right[1]};
    }
    else if (target < A[m]) {
      return search(A, l, m - 1, target);
    }
    return search(A, m + 1, h, target);
  }
}
