package fb.dp;

/**
 * @author: mindpower
 * @created: 4/21/12-7:40 PM
 */
public class EditDistance {
  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dist = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) dist[i][0] = i;
    for (int j = 0; j < n + 1; j++) dist[0][j] = j;
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dist[i][j] = dist[i - 1][j - 1];
        }
        else {
          dist[i][j] = 1 + Math.min(Math.min(dist[i - 1][j], dist[i][j - 1]), dist[i - 1][j - 1]);
        }
      }
    }
    return dist[m][n];
  }
}