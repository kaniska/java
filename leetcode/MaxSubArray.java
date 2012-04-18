package leetcode;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 6:35 PM
 */
public class MaxSubArray {
	public int maxSubArray(int[] A) {
		int current = A[0], max = A[0];
		for (int i=1;i<A.length;i++) {
			current = current<0? A[i]: (current+A[i]);
			max = max<current? current:max;
		}
		return max;
	}
}
