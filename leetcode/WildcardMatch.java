package leetcode;

import java.util.*;

/**
 * @author jbu
 * @since 3/17/12 7:34 PM
 */
public class WildcardMatch {
  public boolean isMatch(String s, String p) {
    if (p == null && s == null) return true;
    if (p == null || s == null) return false;
    if (p.equals("*")) return true;
    return match(s, p, 0, 0);
  }

  boolean match(String s, String p, int ls, int lp) {
    if (lp == p.length()) return ls == s.length();
    if (p.charAt(lp) != '*') {
      return (ls < s.length() && (s.charAt(ls) == p.charAt(lp) || p.charAt(lp) == '?') &&
        match(s, p, ls + 1, lp + 1));
    }
    while (ls < s.length()) {
      if (match(s, p, ls, lp + 1)) return true;
      ls++;
    }
    return match(s, p, ls, lp + 1);
  }
}
