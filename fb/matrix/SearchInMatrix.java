package fb.matrix;

import java.util.*;

/**
 * Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * @author: mindpower
 * @created: 4/21/12-12:07 PM
 */
public class SearchInMatrix {

  /**
   * Simple search O(m+n)
   *
   * @param matrix
   * @param target
   * @return
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int i = m - 1, j = 0;
    while (i >= 0 && j < n) {
      if (target == matrix[i][j]) return true;
      if (target < matrix[i][j]) {
        i--;
      }
      else {
        j++;
      }
    }
    return false;
  }

  /**
   * Binary search row first, then col    --  O(log(m)+log(n))
   *
   * @param matrix
   * @param target
   * @return
   */
  public boolean searchMatrixBinary(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    int i = 0, j = matrix.length - 1;
    int p = -1;
    while (true) {
      if (i >= j) {
        if (matrix[i][0] == target) {
          return true;
        }
        else if (matrix[i][0] < target) {
          p = i;
        }
        else {
          p = i - 1;
        }
        break;
      }
      int m = (i + j) / 2;
      if (matrix[m][0] == target) {
        return true;
      }
      if (matrix[m][0] < target) {
        i = m + 1;
      }
      else {
        j = m - 1;
      }
    }
    if (p < 0) {
      return false;
    }
    i = 0;
    j = matrix[0].length - 1;
    while (true) {
      if (i >= j) {
        return (matrix[p][i] == target);
      }
      int m = (i + j) / 2;
      if (matrix[p][m] == target) {
        return true;
      }
      if (matrix[p][m] < target) {
        i = m + 1;
      }
      else {
        j = m - 1;
      }
    }
  }
}
