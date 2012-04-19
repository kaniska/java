package facebook.string;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author jbu
 */
public class RegEx {
  private static boolean isMatch(String s, int ls, String p, int lp) {
    if (lp == p.length()) {
      return ls == s.length();
    }
    // when next pattern is not '*', we need match exactly
    if (lp == p.length() - 1 || p.charAt(lp + 1) != '*') {
      return (p.charAt(lp) == '.' || p.charAt(lp) == s.charAt(ls)) && isMatch(s, ls + 1, p, lp + 1);
    }
    // when next pattern is *, we use back tracking to try match
    while (ls <= s.length() - 1 && (p.charAt(lp) == s.charAt(ls) || p.charAt(lp) == '.')) {
      if (isMatch(s, ls, p, lp + 2)) {
        return true;
      }
      ls++;
    }
    return isMatch(s, ls, p, lp+2);
  }

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    if (p.equals("*")) {
      return true;
    }
    try {
      return isMatch(s, 0, p, 0);
    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String args[]) {
    RegEx rg = new RegEx();
    String[] s = {
      "aa", "aa", "aaa", "aa", "aa", "ab", "aab", "aaa", "aaa", "aaa", "aaa",
      "aaa", "", "", "aasdfasdfasdfasdfas"
    };
    String[] p = {
      "a", "aa", "aa", "a*", ".*", ".*", "c*a*b", "aaa", "aa", "aaaa", "a.a",
      "ab*a*c*a", "", ".*", "aasdf.*asdf.*asdf.*asdf.*s"
    };
    boolean[] r = {
      false, true, false, true, true, true, true, true, false, false, true,
      true, true, true, true
    };
    for (int i = 0; i < s.length; i++) {
      assert (rg.isMatch(s[i], p[i]) == r[i]);
    }

  }

}
