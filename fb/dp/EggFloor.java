package fb.dp;

import java.util.*;

/**
 * @author jbu
 * @since 3/17/12 10:38 PM
 */
public class EggFloor {

  public static int minTries(int eggs, int floors) {
    int[][] f = new int[eggs + 1][floors + 1];
    for (int i = 1; i <= floors; i++) {
      f[1][i] = i;
    }
    for (int i = 1; i <= floors; i++) {
      for (int j = 1; j <= eggs; j++) {
        f[j][i] = f[j - 1][i - 1] + 1 + f[j][i - 1];
        if (f[j][i] >= floors) {
          return i;
        }
      }
    }
    int x = Arrays.binarySearch(f[eggs], floors);
//    System.out.println(Arrays.toString(f[eggs]));
    return x;
  }

  public static void main(String args[]) {
    System.out.println(minTries(2, 100));
  }
}
