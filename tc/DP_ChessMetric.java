package tc;

public class DP_ChessMetric {
  public static void main(String[] args) {
    p(howMany(3, new int[]{0, 0}, new int[]{1, 0}, 1) == 1 ? "Right" : "Wrong,Should be 1");
    p(howMany(3, new int[]{0, 0}, new int[]{1, 2}, 1) == 1 ? "Right" : "Wrong,Should be 1");
    p(howMany(3, new int[]{0, 0}, new int[]{2, 2}, 1) == 0 ? "Right" : "Wrong,Should be 0");
    p(howMany(3, new int[]{0, 0}, new int[]{0, 0}, 2) == 5 ? "Right" : "Wrong,Should be 5");
    p(howMany(100, new int[]{0, 0}, new int[]{0, 99}, 50) == 243097320072600l ? "Right" : "Wrong,Should be 243097320072600");
  }

  public static void p(String s) {
    System.out.println(s);
  }

  static int dx[] = {1, 1, 1, -1, -1, -1, 0, 0, 2, 2, -2, -2, 1, 1, -1, -1};
  static int dy[] = {0, -1, 1, 0, -1, 1, 1, -1, -1, 1, -1, 1, -2, 2, -2, 2};

  public static long howMany(int size, int[] start, int[] end, int numMoves) {
    long m[][][] = new long[numMoves + 1][size][size];
    m[0][start[0]][start[1]] = 1;
    for (int i = 1; i <= numMoves; i++)
      for (int x = 0; x < size; x++)
        for (int y = 0; y < size; y++)
          for (int d = 0; d < dx.length; d++) {
            if (x + dx[d] >= 0 && x + dx[d] < size && y + dy[d] >= 0 && y + dy[d] < size)
              m[i][x + dx[d]][y + dy[d]] += m[i - 1][x][y];
          }
    System.out.print("Result=" + m[numMoves][end[0]][end[1]] + "  ");
    return m[numMoves][end[0]][end[1]];
  }
}
