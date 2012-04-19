package facebook.matrix;

/**
 * @author jbu
 */
public class FindStringInMatrix {

  public static boolean stringMatch(char[][] m, String s) {
    StringBuffer sb = new StringBuffer();
    boolean visited[][] = new boolean[m.length][m[0].length];
    boolean found = false;
    for (int i=0;i<m.length;i++) {
      for (int j=0;j<m[0].length;j++) {
        if (searchDFS(m, i, j, s, 0, visited, sb)) found = true;
      }
    }

    return found;
  }


  public static boolean searchDFS(char[][] m, int x, int y, String s, int pos, boolean[][] v, StringBuffer sb) {
    if (pos==s.length()) return true;
    if (m[x][y]!=s.charAt(pos)) return false;
    sb.append(m[x][y]);
    v[x][y]=true;
    boolean valid=false;
    if (x>0 && !v[x-1][y] && searchDFS(m, x - 1, y, s, pos + 1, v, sb)) valid=true;
    if (y>0 && !v[x][y-1]&& searchDFS(m, x, y - 1, s, pos + 1, v, sb)) valid=true;
    if (x<m.length-1 && !v[x+1][y] && searchDFS(m, x + 1, y, s, pos + 1, v, sb)) valid=true;
    if (y<m[0].length-1 && !v[x][y+1]&& searchDFS(m, x, y + 1, s, pos + 1, v, sb)) valid=true;
    sb.setLength(sb.length()-1);
    v[x][y]=false;
    return valid;
  }


  public static void main(String args[]) {
    char[][] m = new char[][]{
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    };
    System.out.println("ABCCED in matrix="+ stringMatch(m, "ABCCED"));
    System.out.println("ABCB in matrix="+ stringMatch(m, "ABCB"));
    System.out.println("SEE in matrix="+ stringMatch(m, "SEE"));
  }
}
