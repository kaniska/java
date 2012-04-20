package fb.puzzle;

/**
 * @author jbu
 */
public class ValidSudoku {

//      private boolean isValid(char...a) {
//        Set<Character> s = new HashSet<Character>();
//        for (char c:a) {
//            if (c=='.') continue;
//            if (!s.contains(c)) {
//                s.add(c);
//            } else return false;
//        }
//        return true;
//    }
//
//    public boolean isValidSudoku(char[][] board) {
//        for (int i=0;i<9;i++) {
//            if (!isValid(board[i])) return false;
//            if (!isValid(board[0][i],board[1][i],board[2][i],
//                board[3][i],board[4][i],board[5][i],
//                board[6][i],board[7][i],board[8][i])) return false;
//        }
//        for (int i=0;i<3;i++)
//        for (int j=0;j<3;j++)
//        if (!isValid(board[i*3][j*3],board[i*3][j*3+1],board[i*3][j*3+2],
//            board[i*3+1][j*3],board[i*3+1][j*3+1],board[i*3+1][j*3+2],
//            board[i*3+2][j*3],board[i*3+2][j*3+1],board[i*3+2][j*3+2])) return false;
//        return true;
//    }


  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (!isValid(board[i])) return false;
    }

    for (int i = 0; i < 9; i++) {
      char[] s = new char[9];
      for (int j = 0; j < 9; j++)
        s[j] = board[j][i];
      if (!isValid(s)) return false;
    }

    for (int i = 0; i < 9; i++) {
      char[] s = new char[9];
      for (int j = 0; j < 9; j++) {
        int x = (i / 3) * 3 + (j / 3);
        int y = (i % 3) * 3 + (j % 3);
        s[j] = board[x][y];
      }
      if (!isValid(s)) return false;
    }

    return true;

  }

  private boolean isValid(char... line) {
    boolean[] s = new boolean[9];
    for (int i = 0; i < line.length; i++) {
      if (line[i] == '.') continue;
      if (line[i] > '9' || line[i] < '1') return false;
      if (s[line[i] - '1']) return false;
      s[line[i] - '1'] = true;
    }
    return true;
  }
}
