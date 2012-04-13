package leetcode;

/**
 * @author jbu
 */
public class TrapRunningWater {
    public int trap(int[] A) {
       if (A==null || A.length<=1) return 0;
       int len = A.length;
       int[] lmax = new int[len];
       int[] rmax = new int[len];

       lmax[0]=A[0];
       rmax[len-1]=A[len-1];
       for (int i=1;i<len;i++) {
          lmax[i]= (A[i]>lmax[i-1]? A[i]:lmax[i-1]);
       }
       for (int i=len-2;i>=0;i--) {
          rmax[i]= (A[i]>rmax[i+1]? A[i]:rmax[i+1]);
       }
       int total =0;
       for (int i=0;i<len;i++) {
          int v = Math.min(lmax[i],rmax[i]);
          total+= (v>A[i]? v-A[i]:0);
       }
       return total;

    }
}
