package fb.string;

/**
 * @author jbu
 */
public class LongestPalindrome {

  /**
   * O(n^2) space and O(n^2) time
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    int len = s.length();
    boolean[][] p = new boolean[len][len];
    int max = 1;
    int start = 0;
    for (int i = 0; i < len; i++) {
      p[i][i] = true;
    }
    for (int i = 0; i < len - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        max = 2;
        start = i;
        p[i][i + 1] = true;
      }
    }
    for (int k = 3; k <= len; k++) {
      for (int i = 0; i < len - k + 1; i++) {
        int j = i + k - 1;
        if (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
          p[i][j] = true;
          max = k;
          start = i;
        }
      }
    }
    return s.substring(start, start + max);
  }

  /**
   * O(n^2) time but O(1) space
   *
   * @param s
   * @return
   */
  public String longestPalindrome2(String s) {
    int len = s.length();
    int max = 0;
    String maxString = "";
    for (int i = 0; i <= len - 1; i++) {
      String n1 = exploreAround(s, i, i);
      if (n1.length() > max) {
        max = n1.length();
        maxString = n1;
      }
      n1 = exploreAround(s, i, i + 1);
      if (n1.length() > max) {
        max = n1.length();
        maxString = n1;
      }
    }
    return maxString;
  }

  private String exploreAround(String s, int i, int j) {
    int len = s.length();
    while (i >= 0 && j < len && s.charAt(i) != s.charAt(j)) {
      i--;
      j++;
    }
    return s.substring(i + 1, j);
  }
}
