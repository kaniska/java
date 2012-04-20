package fb.array;

/**
 * @author jbu
 */
public class SearchInsertPosition {

  public int searchInsert(int[] A, int target) {
    return search(A, 0, A.length - 1, target);
  }

  private int search(int[] A, int i, int j, int target) {
    if (i > j) return i;
    if (i == j) {
      if (target <= A[i]) return i;
      else return i + 1;
    }
    int middle = (i + j) / 2;
    if (A[middle] == target) return middle;
    else if (target < A[middle]) return search(A, i, middle - 1, target);
    else return search(A, middle + 1, j, target);
  }
}
