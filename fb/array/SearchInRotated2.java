package fb.array;

/**
 *
 * Search in Rotated Sorted Array II
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 » Solve this problem

 * @author: mindpower
 * @since: 5/17/12-7:19 AM
 */
public class SearchInRotated2 {
  public boolean search(int[] A, int target) {
    if (A==null || A.length==0) return false;
    return search(A,target,0,A.length-1);
  }

  boolean search(int[] A, int target, int l, int r) {
    if (l>=r) return  (A[l]==target);
    int m = (l+r)/2;
    if (A[m]==target) return true;
    boolean left = false, right=false;
    if (A[l]<=A[m]) {
      if (A[l]<=target && target<A[m] && search(A,target,l,m-1)) return true;
      else if (search(A,target,m+1,r)) return true;
    }
    if (A[m]<=A[r]) {
      if (A[m]<target && target<=A[r] && search(A,target,m+1,r)) return true;
      else if (search(A,target,l,m-1)) return true;
    }
    return false;
  }

}
