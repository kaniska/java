package fb.array;

import java.util.*;

/**
 * Sort Colors
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p/>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p/>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p/>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * <p/>
 * Could you come up with an one-pass algorithm using only constant space?
 *
 * @author: mindpower
 * @created: 4/19/12-7:38 PM
 */
public class SortColor {
  public void sortColors(int[] A) {
    int[] c = new int[3];
    for (int i : A) {
      c[i]++;
    }
    int j = 0, k = 0;
    for (int i = 0; i < 3; i++) {
      j = 0;
      while (j++ < c[i]) A[k++] = i;
    }
  }
}
