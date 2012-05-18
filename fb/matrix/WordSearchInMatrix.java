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

  public boolean exist(char[][] board, String word) {
    int m = board.length,n=board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i=0;i<m;i++)
      for (int j=0;j<n;j++) {
        if (exist(board,i, j, 0, word,visited)) return true;
      }
    return false;
  }

  boolean exist(char[][] board, int i, int j, int pos, String word, boolean[][] visited) {
    if (board[i][j]!=word.charAt(pos)) return false;
    if (pos==word.length()-1) return true;
    visited[i][j]=true;
    if (i>0 && !visited[i-1][j] && exist(board,i-1,j,pos+1,word,visited)) return true;
    if (j>0 && !visited[i][j-1] && exist(board, i, j - 1, pos + 1, word, visited)) return true;
    if (i<board.length-1 && !visited[i+1][j] && exist(board,i+1,j,pos+1,word,visited)) return true;
    if (j<board[0].length-1 && !visited[i][j+1]  && exist(board, i, j + 1, pos + 1, word, visited)) return true;
    visited[i][j]=false;
    return false;
  }
  public static void main(String args[]) {
    WordSearchInMatrix w = new WordSearchInMatrix();
    char[][] m = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    System.out.println("ABCCED in matrix=" + w.exist(m, "ABCCED"));
    System.out.println("ABCB in matrix=" + w.exist(m, "ABCB"));
    System.out.println("SEE in matrix=" + w.exist(m, "SEE"));
  }
}
