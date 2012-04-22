package fb.puzzle;

/**
 * @author jbu
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      // check each row
      if (!isValid(board[i])) return false;
      // check each column
      char[] s = new char[9];
      for (int j = 0; j < 9; j++) s[j] = board[j][i];
      if (!isValid(s)) return false;
      // check each small grid
      for (int j = 0; j < 9; j++) s[j] = board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)];
      if (!isValid(s)) return false;
    }
    return true;
  }

  boolean isValid(char... x) {
    boolean s[] = new boolean[9];
    for (int i = 0; i < x.length; i++) {
      if (x[i] == '.') continue;
      if (x[i] < '1' || x[i] > '9') return false;
      if (s[x[i] - '1']) return false;
      s[x[i] - '1'] = true;
    }
    return true;
  }
}
