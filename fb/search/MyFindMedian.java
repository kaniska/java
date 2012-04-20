package fb.search;

/**
 * @author jbu
 * @since 3/19/12 10:16 PM
 */
public class MyFindMedian {

  public double findMedianSortedArrays(int A[], int B[]) {
    int m = A.length, n = B.length, len = m + n;
    //   if (m==0) return median(B);
    //   if (n==0) return median(A);
    return find(A, B, Math.max(0, (m - n) / 2), Math.min(m - 1, (m + n) / 2));
  }

  private double find(int A[], int B[], int l, int r) {
    int m = A.length, n = B.length, len = m + n;
    if (l > r) return find(B, A, Math.max(0, (n - m) / 2), Math.min(n - 1, (m + n) / 2));
    int i = (l + r) / 2;
    int j = len / 2 - i - 1;
    int Bj = j <= -1 ? Integer.MIN_VALUE : B[j];
    int Bj1 = (j + 1 >= B.length ? Integer.MAX_VALUE : B[j + 1]);
    if (A[i] < Bj) return find(A, B, i + 1, r);
    if (A[i] > Bj1) return find(A, B, l, i - 1);
    if ((len & 1) == 1) return A[i];
    int second = (i > 0 && j >= 0) ? Math.max(A[i - 1], Bj) : j >= 0 ? Bj : A[i - 1];
    return (second + A[i]) / 2.0;
  }

  private double median(int[] A) {
    if (A.length == 0) return 0.0;
    if (A.length % 2 == 1) {
      return A[A.length / 2];
    } else {
      return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0;
    }
  }

  public static void main(String args[]) {
    int a[] = {2, 3, 5, 6, 7};
    int b[] = {1, 4};
    System.out.println(new MyFindMedian().findMedianSortedArrays(a, b));
  }

}
