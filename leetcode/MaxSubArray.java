package leetcode;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 6:35 PM
 */
public class MaxSubArray {
    public int maxSubArray(int[] A) {
       int max =Integer.MIN_VALUE, cur=0;
       for (int i=0;i<A.length;i++) {
           cur = cur<0? A[i]: cur+A[i]>0? cur+A[i]: A[i];
           max = cur>max? cur:max;
       }
       return max;
    }
}
