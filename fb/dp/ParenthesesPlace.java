package fb.dp;

/**
 * @author: mindpower
 * @since: 6/5/12-6:51 AM
 */
public class ParenthesesPlace {

  private static int cal(int v1, int v2, char o) {
    switch (o) {
      case '+':
        return v1 + v2;
      case '-':
        return v1 - v2;
      case '*':
        return v1 * v2;
      case '/':
        return v1 / v2;
    }
    throw new IllegalArgumentException("Invalid operator" + o);
  }

  public static int maxSum(int[] V, char[] O) {
    int n = V.length;
    assert (O.length == n - 1);
    int S[][] = new int[n][n];
    for (int i = 0; i < n; i++) S[i][i] = V[i];
    int max, cur;
    for (int len = 1; len <= n - 1; len++) {
      for (int j = 0; j < n - len; j++) {
        max = 0;
        for (int k = 0; k < len; k++) {
          cur = cal(S[j][j + k], S[j + k + 1][j + len], O[j + k]);
          if (cur > max) max = cur;
        }
        S[j][j + len] = max;
      }
    }
    return S[0][n - 1];
  }

  public static void main(String[] args) {
    int[] V = {3, 6, 9, 8, 10};
    char[] O = {'+', '*', '+', '*'};
    System.out.println(maxSum(V, O));
  }
}
