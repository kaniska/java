package leetcode;

/**
 * @author jbu
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
       if (A.length<2) return A.length;
       int cur = 1;
       for (int i=1;i<A.length;i++) {
         if (A[i]==A[i-1]) continue;
         else A[cur++]=A[i];
       }
       return cur;
    }
}
