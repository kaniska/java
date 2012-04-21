package fb.matrix;

/**
 * Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p/>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p/>
 * For example,
 * Given board =
 * <p/>
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * @author jbu
 */
public class WordSearchInMatrix {

  public static boolean stringMatch(char[][] m, String s) {
    boolean visited[][] = new boolean[m.length][m[0].length];
    boolean found = false;
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (searchDFS(m, i, j, s, 0, visited)) found = true;
      }
    }
    return found;
  }

  public static boolean searchDFS(char[][] m, int x, int y, String s, int pos, boolean[][] v) {
    if (pos == s.length()) return true;
    if (m[x][y] != s.charAt(pos)) return false;
    v[x][y] = true;
    boolean valid = false;
    if (x > 0 && !v[x - 1][y] && searchDFS(m, x - 1, y, s, pos + 1, v)) valid = true;
    if (valid) return valid;
    if (y > 0 && !v[x][y - 1] && searchDFS(m, x, y - 1, s, pos + 1, v)) valid = true;
    if (valid) return valid;
    if (x < m.length - 1 && !v[x + 1][y] && searchDFS(m, x + 1, y, s, pos + 1, v)) valid = true;
    if (valid) return valid;
    if (y < m[0].length - 1 && !v[x][y + 1] && searchDFS(m, x, y + 1, s, pos + 1, v)) valid = true;
    if (valid) return valid;
    v[x][y] = false;
    return valid;
  }


  public static void main(String args[]) {
    char[][] m = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    System.out.println("ABCCED in matrix=" + stringMatch(m, "ABCCED"));
    System.out.println("ABCB in matrix=" + stringMatch(m, "ABCB"));
    System.out.println("SEE in matrix=" + stringMatch(m, "SEE"));
  }
}
