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
    ArrayList<String[]> result = new ArrayList<String[]>();
    int[] current = new int[n];
//        Arrays.fill(index,-1);
    solve(current, result, 0);
    return result.size();
  }

  private void solve(int[] current, ArrayList<String[]> result, int row) {
    int n = current.length;
    if (row == n) {
      result.add(getNQueenString(current));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (valid(current, row, i)) {
        current[row] = i;
        solve(current, result, row + 1);
      }
    }
  }

  private boolean valid(int[] current, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (current[i] == col) return false;
      if (Math.abs(row - i) == Math.abs(col - current[i])) return false;
    }
    return true;
  }

  private String[] getNQueenString(int[] current) {
    int n = current.length;
    String[] r = new String[n];
    char[] one = new char[n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(one, '.');
      one[current[i]] = 'Q';
      r[i] = new String(one);
    }
    return r;
  }
}
