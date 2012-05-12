package fb.string;

/**
 * @author jbu
 * @updated 04/22/2012
 * @since 3/17/12 7:34 PM
 */
public class WildcardMatch {
  public boolean isMatch(String s, String p) {
    if (s == null && p == null) {
      return true;
    }
    if (s == null || p == null) {
      return false;
    }
    if (p.equals("*")) {
      return true;
    }
    if (p.equals("")) {
      return s.equals("");
    }
    return doMatch(s, p, 0, 0);
  }

  /**
   * This will work however it will time out on large judge cases
   */
  boolean doMatch(String s, String p, int ls, int lp) {
    if (lp == p.length()) {
      return ls == s.length();
    }
    if (p.charAt(lp) != '*') { // not wildcard
      return ls < s.length() && (p.charAt(lp) == '?' || s.charAt(ls) == p.charAt(lp))
          && doMatch(s, p, ls + 1, lp + 1);
    }
    if (doMatch(s, p, ls, lp + 1)) {
      return true;
    }
    while (ls < s.length()) {
      if (doMatch(s, p, ls + 1, lp + 1)) {
        return true;
      }
      ls++;
    }
    return false;
  }

  /**
   * This did some improvement by looking at the character after * to avoid exponential check,
   * but will still time out on large test
   * Check suggestion here:  http://www.weiming.info/zhuti/JobHunting/32089239/
   */
  boolean doMatch_improved(String s, String p, int ls, int lp) {
    if (lp == p.length()) {
      return ls == s.length();
    }
    if (p.charAt(lp) != '*') {
      return (ls < s.length() && (s.charAt(ls) == p.charAt(lp) || p.charAt(lp) == '?') &&
          doMatch(s, p, ls + 1, lp + 1));
    }
    // it's * and it's also the last one in p
    if (lp == p.length() - 1) {
      return true;
    }
    while (lp < p.length() && p.charAt(lp) == '*') {
      lp++;
    }
    if (lp == p.length()) {
      return ls == s.length();
    }
    char next = p.charAt(lp);
    if (next == '?') {
      if (doMatch(s, p, ls, lp)) {
        return true;
      }
      while (ls < s.length()) {
        if (doMatch(s, p, ls + 1, lp)) {
          return true;
        }
        ls++;
      }
      return false;
    }
    else {
      if (ls < s.length() && s.charAt(ls) == next && doMatch(s, p, ls, lp)) {
        return true;
      }
      while (ls < s.length()) {
        while (ls < s.length() && s.charAt(ls) != next) {
          ls++;
        }
        if (ls == s.length()) {
          return false;
        }
        if (doMatch(s, p, ls, lp)) {
          return true;
        }
        ls++;
      }
      return false;
    }
  }

  // try using DP however seems code very messy
  public boolean isMatch_DP(String s, String p) {
    int l = s.length(), m = p.length();
    if (p.equals("*")) {
      return true;
    }
    if (m == 0) {
      return l == 0;
    }
    boolean[][] match = new boolean[l][m];
    match[0][0] = p.charAt(0) == '*' || p.charAt(0) == '?' || p.charAt(0) == s.charAt(0);
    for (int i = 1; i < l; i++) {
      if (p.charAt(0) == '*') {
        match[i][0] = true;
      }
      else {
        match[i][0] = false;
      }
    }
    for (int i = 0; i < l; i++) {
      for (int j = 1; j < m; j++) {
        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
          match[i][j] = (i == 0 ? match[0][j - 1] : match[i - 1][j - 1]);
        }
        else if (p.charAt(j) == '*') {
          match[i][j] = (i == 0 ? match[0][j - 1] : match[i - 1][j - 1]) || match[i][j - 1];
        }
        else {
          match[i][j] = false;
        }
      }
    }
    return match[l - 1][m - 1];
  }
}
