package fb.array;

/**
 * @author mindpower
 */
public class SearchRotated {
  public int search(int[] A, int target) {
    if (A==null || A.length==0) return -1;
    return search(A,target,0,A.length-1);
  }

  int search(int[] A, int target, int l, int r) {
    if (l>=r) return  (A[l]==target)?l:-1;
    int m = (l+r)/2;
    if (A[m]==target) return m;
    if (A[l]<=A[m]) {
      if (A[l]<=target && target<A[m]) return search(A,target,l,m-1);
      else return search(A,target,m+1,r);
    } else {
      if (A[m]<target && target<=A[r]) return search(A,target,m+1,r);
      else return search(A,target,l,m-1);
    }
  }
}
