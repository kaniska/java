package fb.dp;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 8:11 PM
 */
public class SolveNQueenTotal {
  public static void main(String args[]) {
    for (int i = 1; i < 20; i++)
      System.out.println(i + " =" + new SolveNQueenTotal().totalNQueens(i));
  }

  public int totalNQueens(int n) {
    int[] current = new int[n];
    return solve(0, n, current);
  }

  int solve(int row, int n, int[] current) {
    if (row == n) return 1;
    int total = 0;
    for (int i = 0; i < n; i++) {
      if (isValid(current, row, i)) {
        current[row] = i;
        total += solve(row + 1, n, current);
      }
    }
    return total;
  }

  boolean isValid(int[] current, int row, int pos) {
    for (int i = 0; i < row; i++) {
      if (current[i] == pos || Math.abs(current[i] - pos) == (row - i)) return false;
    }
    return true;
  }
}
