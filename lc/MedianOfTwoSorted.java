package lc;

/**
 * @author jbu
 */
public class MedianOfTwoSorted {

  /** not working below , run time exception, too complicated **/
//      private double findMedian(int A[]) {
//        int len=A.length;
//        if (len%2==0) return (A[len/2-1]+A[len/2])/2.0d;
//        else return A[len/2];
//    }
//
//    public double findMedianSortedArrays(int A[], int B[]) {
//        int n1=A.length, n2=B.length;
//        if (n1==0) return findMedian(B);
//        if (n2==0) return findMedian(A);
//         if (true) return 0;
//
//        int m=(n1+n2)/2;
//        int i=0,i1=0,i2=0;
//        while (i<m-1 && i1<n1 && i2<n2) {
//            if (A[i1]<=B[i2]) i1++;
//            else i2++;
//            i++;
//        }
//        while (i<m-1 && i1>=n1-1) {i++;i2++;}
//        while (i<m-1 && i2>=n2-1) {i++;i1++;}
//        int m1, m2;
//        if (i1>=n1-1) {
//            m1=B[0];
//            m2=B[1];
//        } else if (i2>=n2-1) {
//            m1=A[0];
//            m2=A[1];
//        } else {
//            if (A[i1]<=B[i2]) {
//                m1=A[i1++];
//            } else {
//                m1=B[i2++];
//            }
//            if (i1>=n1-1) m2=B[0];
//            else if (i2>=n2-1) m2=A[0];
//            else {
//                if (A[i1]<=B[i2]) {
//                    m2=A[i1++];
//                } else {
//                    m2=B[i2++];
//                }
//            }
//        }
//        return (n1+n2)%2==1? m1: (m1+m2)/2;
//
//    }

  /**
   * Mit solution improvement
   *
   * @param A
   * @param B
   * @param l
   * @param r
   * @param nA
   * @param nB
   * @return
   */
  double findMedian(int A[], int B[], int l, int r, int nA, int nB) {
    if (l > r) return findMedian(B, A, Math.max(0, (nA + nB) / 2 - nA), Math.min(nB, (nA + nB) / 2), nB, nA);
    int i = (l + r) / 2;
    int j = (nA + nB) / 2 - i - 1;
    if (j >= 0 && A[i] < B[j]) {
      return findMedian(A, B, i + 1, r, nA, nB);
    } else if (j < nB - 1 && A[i] > B[j + 1]) {
      return findMedian(A, B, l, i - 1, nA, nB);
    } else {
      if ((nA + nB) % 2 == 1) {
        return A[i];
      } else if (i > 0) {
        return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
      } else {
        return (A[i] + B[j]) / 2.0;
      }
    }
  }


  public double findMedianSortedArrays(int A[], int B[]) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (A.length == 0 && B.length == 0) return 0;
    if (A.length == 1 && B.length == 1) return (A[0] + B[0]) / 2.0;
    return findMedian(A, B, 0, 0, A.length - 1, B.length - 1);
  }


  private double median(int[] A) {
    if (A.length == 0) return 0.0;
    if (A.length % 2 == 1) return A[A.length / 2];
    else return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0;
  }

  public double findMedianSortedArrays1(int A[], int B[]) {
    int m = A.length, n = B.length;
    return find(A, B, Math.max(0, (m - n) / 2), Math.min(A.length - 1, (m + n) / 2));
  }


  private double find(int A[], int B[], int l, int r) {
    int m = A.length, n = B.length;
    if (l > r) return find(B, A, Math.max(0, (n - m) / 2), Math.min(B.length - 1, (m + n) / 2));
    int i = (l + r) / 2;
    int j = (m + n) / 2 - i - 1;
    int Bj = j < 0 ? Integer.MIN_VALUE : B[j];
    int Bj1 = j >= n - 1 ? Integer.MAX_VALUE : B[j + 1];
    if (A[i] < Bj) return find(A, B, i + 1, r);
    if (A[i] > Bj1) return find(A, B, l, i - 1);
    if ((m + n) % 2 == 1) return A[i];
    int second = (i > 0 && j >= 0) ? Math.max(A[i - 1], Bj) : i > 0 ? A[i - 1] : Bj;
    return (A[i] + second) / 2.0;
  }

}
