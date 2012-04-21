package fb.matrix;

import java.util.*;

/**
 * Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p/>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * » Solve this problem
 *
 * @author: mindpower
 * @created: 4/21/12-12:54 PM
 */
public class SetMatrixZero {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (row[i] || col[j]) matrix[i][j] = 0;

  }
}
