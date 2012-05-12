package fb.array;

/**
 * @author jbu
 */
public class RemoveDuplicates {
  public int removeDuplicates(int[] A) {
    if (A.length < 2) {
      return A.length;
    }
    int cur = 1;
    for (int i = 1; i < A.length; i++) {
      if (A[i] == A[i - 1]) {
        continue;
      }
      else {
        A[cur++] = A[i];
      }
    }
    return cur;
  }

  public int removeDuplicatesTwice(int[] A) {
    if (A.length <= 1) {
      return A.length;
    }
    int start = 1;
    boolean appearedTwice = false;
    for (int i = 1; i < A.length; i++) {
      if (A[i] == A[i - 1]) {
        if (appearedTwice) {
          continue;
        }
        A[start++] = A[i];
        appearedTwice = true;
      }
      else {
        A[start++] = A[i];
        appearedTwice = false;
      }
    }
    return start;
  }
}
