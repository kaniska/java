package fb.array;

/**
 * @author mindpower
 */
public class RemoveDuplicates {
  public int removeDuplicates(int[] A) {
    if (A==null || A.length==0) return 0;
    int k = 1;
    for (int i=1;i<A.length;i++) {
      if (A[i]!=A[i-1]) A[k++]=A[i];
    }
    return k;
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
