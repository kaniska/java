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
 * » Solve this problem  :
 * !! In place is very tricky and the order to apply 0 is important
 *
 * @author: mindpower
 * @created: 4/21/12-12:54 PM
 */
public class SetMatrixZero {
  public static void main(String[] args) {
    int[][] matrix = {
        {-5, 7, 2147483647, 3}, {0, 3, 6, -2147483648}, {8, 3, -3, -6}, {-9, -9, 8, 0}
    };
    SetMatrixZero s = new SetMatrixZero();
    s.setZeroesWithConstantSpace(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + "\t\t");
      }
      System.out.println();
    }
  }

  public void setZeroesWithConstantSpace(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return;
    int m = matrix.length;
    int n = matrix[0].length;
    int extra = 1;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        extra = 0;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      boolean isZero = false;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          isZero = true;
          break;
        }
      }
      matrix[i][0] = isZero ? 0 : matrix[i][0];
    }
    for (int i = 1; i < n; i++) {
      boolean isZero = false;
      for (int j = 0; j < m; j++) {
        if (matrix[j][i] == 0) {
          isZero = true;
          break;
        }
      }
      matrix[0][i] = isZero ? 0 : matrix[0][i];
    }
    for (int j = 1; j < n; j++) {
      for (int i = 1; i < m; i++) {
        boolean isZero = (matrix[i][0] == 0 || matrix[0][j] == 0);
        matrix[i][j] = (isZero ? 0 : matrix[i][j]);
      }
    }
    if (matrix[0][0] == 0) {
      for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }
    if (extra == 0) {
      for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
  }

  public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] || col[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
