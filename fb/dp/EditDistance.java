package fb.dp;

import java.util.*;

/**
 * It seems it will fail 1/1400 test cases when judge large
 *
 * @author: mindpower
 * @created: 4/21/12-7:40 PM
 */
public class EditDistance {
  public int minDistance(String word1, String word2) {
    if (word1.length() == 0 || word2.length() == 0) return Math.max(word1.length(), word2.length());
    int m = word1.length(), n = word2.length();
    int[][] d = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) d[i][0] = i;
    for (int i = 0; i < n; i++) d[0][i] = i;
    for (int i = 1; i <= m; i++)
      for (int j = 1; j <= n; j++)
        if (word1.charAt(i - 1) == word2.charAt(j - 1))
          d[i][j] = d[i - 1][j - 1];
        else d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
    return d[m][n];
  }
}