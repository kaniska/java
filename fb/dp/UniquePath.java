package fb.dp;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-10:47 AM
 */
public class UniquePath {
  public int uniquePaths(int m, int n) {
    int[][] total = new int[m][n];
    for (int i = 0; i < m; i++) {
      total[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      total[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        total[i][j] = total[i - 1][j] + total[i][j - 1];
      }
    }
    return total[m - 1][n - 1];
  }
}
