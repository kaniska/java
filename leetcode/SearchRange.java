package leetcode;

/**
 * @author jbu
 */
public class SearchRange {

  private static final int[] NF = new int[]{-1, -1};

  public int[] searchRange(int[] A, int target) {
    if (A.length == 0) return NF;
    if (A.length == 1) {
      if (A[0] == target) {
        return new int[]{0, 0};
      } else {
        return NF;
      }
    }
    return search(A, 0, A.length - 1, target);
  }

  private int[] search(int[] A, int i, int j, int target) {
    if (i > j) return NF;
    if (i == j) {
      if (A[i] == target) {
        return new int[]{i, i};
      } else {
        return NF;
      }
    }
    int m = (i + j) / 2;
    if (target == A[m]) {
      int left = m, right = m;
      int[] r1 = search(A, i, m - 1, target);
      int[] r2 = search(A, m + 1, j, target);
      if (r1[0] != -1) left = r1[0];
      if (r2[1] != -1) right = r2[1];
      return new int[]{left, right};
    } else if (target < A[m]) {
      return search(A, i, m - 1, target);
    } else {
      return search(A, m + 1, j, target);
    }
  }

//    public int[] searchRange(int[] A, int target) {
//      if (A.length<2) return new int[]{-1,-1};
//
//      return searchRange(A, 0,A.length-1, target);
//    }
//
//    int[] searchRange(int[]A, int l, int u, int target) {
//        if (l+1==u) {
//            if (target<A[l] || target>A[u]) return new int[]{-1,-1};
//            else return new int[]{l,u};
//        }
//        int m = (l+u)/2;
//        if (target==A[m]) {
//            int left=m, right=m;
//          //  if (target==A[m+1]) right=searchRange(
//
//            if (target!=A[m+1] && target!=A[m-1]) return new int[]{m,m};
//            else if (target==A[m+1] && target!=A[m-1]) return new int[]{m,m+1};
//            else return new int[]{m-1,m};
//        }
//        if (target<A[m]) return searchRange(A,l,m,target);
//        else return searchRange(A,m,u,target);
//
//    }
}
