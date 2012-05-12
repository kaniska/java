package fb.string;

/**
 * @author jbu
 */
public class StrStr {
  // 04/17/2012 Code looks a little bit simpler
  public String strStr(String h, String s) {
    int n = h.length();
    int m = s.length();
    int i = 0, j;
    while (i < n - m + 1) {
      for (j = 0; j < m; j++, i++) {
        if (h.charAt(i) != s.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        return h.substring(i - j);
      }
      i = i - j + 1;
    }
    return null;
  }
}
