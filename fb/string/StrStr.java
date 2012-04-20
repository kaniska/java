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
        if (h.charAt(i) != s.charAt(j)) break;
      }
      if (j == m) return h.substring(i - j);
      i = i - j + 1;
    }
    return null;
  }


  public String strStr(String haystack, String needle) {
    int i = 0, j = 0;
    if (haystack == null || needle == null) return null;
    while (i < haystack.length() - needle.length() + 1) {
      j = 0;
      while (j < needle.length()) {
        if (haystack.charAt(i) == needle.charAt(j)) {
          i++;
          j++;
        } else {
          i = i - j + 1;
          break;
        }
      }
      if (j == needle.length()) return haystack.substring(i - j);
    }
    return null;
  }


}
