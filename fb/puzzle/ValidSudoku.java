package fb.puzzle;

/**
 * @author mindpower
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    char[] s = new char[9];
    for (int i = 0; i < 9; i++) {
      if (!isValid(board[i])) return false;
      for (int j = 0; j < 9; j++) s[j] = board[j][i];
      if (!isValid(s)) return false;
      for (int j = 0; j < 9; j++) s[j] = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
      if (!isValid(s)) return false;
    }
    return true;
  }

  boolean isValid(char[] s) {
    boolean[] n = new boolean[9];
    for (char c : s) {
      if (c == '.') continue;
      if (c < '0' || c > '9') return false;
      int num = c - '1';
      if (n[num]) return false;
      n[num] = true;
    }
    return true;
  }
}
