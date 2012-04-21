package fb.dp;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-11:01 AM
 */
public class UniquePathWithObstacle {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] total = new int[m][n];
    if (obstacleGrid[0][0] == 1) return 0;
    total[0][0] = 1;

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] == 1 || (i == 0 && j == 0)) continue;
        total[i][j] = (i > 0 ? total[i - 1][j] : 0) + (j > 0 ? total[i][j - 1] : 0);
      }
    return total[m - 1][n - 1];
  }


}
