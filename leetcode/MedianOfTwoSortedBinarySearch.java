package leetcode;

/**
 * @author jbu
 */
public class MedianOfTwoSortedBinarySearch {

  public static void main(String args[]) {
    MedianOfTwoSortedBinarySearch m = new MedianOfTwoSortedBinarySearch();
    System.out.println(m.findMedianSortedArrays(new int[]{3, 4, 5, 6}, new int[]{1, 2, 3, 4, 7, 8, 9}));
    System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

  }

  private double findMedian(int A[]) {
    int len = A.length;
    return len % 2 == 0 ? (A[len / 2 - 1] + A[len / 2]) / 2.0d : A[len / 2];
  }

  private double findMedianWithOne(int x, int A[]) {
    int len = A.length;
    if (len == 0) return x;
    if (len == 1) return (x + A[0]) / 2.0d;
    if (len % 2 == 0) {
      if (x >= A[len / 2]) {
        return A[len / 2];
      } else if (x < A[len / 2 - 1]) {
        return A[len / 2 - 1];
      } else {
        return x;
      }
    } else {
      if (x <= A[len / 2]) {
        return x > A[len / 2 - 1] ? (x + A[len / 2]) / 2.0d : (A[len / 2 - 1] + A[len / 2]) / 2.0d;
      } else {
        return x < A[len / 2 + 1] ? (x + A[len / 2]) / 2.0d : (A[len / 2 + 1] + A[len / 2]) / 2.0d;
      }
    }
  }

  private double findMedianWithTwo(int x, int y, int A[]) {
    int len = A.length;
    if (len == 0) return (x+y)/2;
//    if (len == 1) return (x + A[0]) / 2.0d;
    if (len % 2 == 0) {
      //TODO
    } else {
      //TODO
    }
    return 0;
  }

  private int getMinOfTwo(int l1, int l2) {
    if (l2 > l1) return getMinOfTwo(l2, l1);
    return (l1 % 2 == 0) ? l1 / 2 - 1 : l1 / 2;
  }

  private double findMedianSortedArray(int A[], int B[], int l1, int r1, int l2, int r2) {
    int len1 = r1 - l1 + 1, len2 = r2 - l2 + 1;
    if (len1 == 1) return findMedianWithOne(A[0], B);
    if (len2 == 1) return findMedianWithOne(B[0], A);
    if (len1 == 2) return findMedianWithTwo(A[0], A[1], B);
    if (len2 == 2) return findMedianWithTwo(B[0], B[1], A);

    double m1 = findMedian(A);
    double m2 = findMedian(B);
    if (len1 == len2 && m1 == m2) return m1;
    int min = getMinOfTwo(len1, len2);
    if (m1 <= m2) {
      return findMedianSortedArray(A, B, l1 + min, r1, r2, l2 - min);
    } else {
      return findMedianSortedArray(A, B, l1, r1 - min, r2 + min, l2);
    }
  }

  public double findMedianSortedArrays(int A[], int B[]) {
    int len1 = A.length, len2 = B.length;
    if (len1 == 0) return findMedian(B);
    if (len2 == 0) return findMedian(A);
    return findMedianSortedArray(A, B, 0, A.length - 1, 0, B.length - 1);
  }

}
