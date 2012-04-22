package fb.string;

/**
 * why we need the last return isMatch?
 * because: for example s='aa',p='a*', all the previous call is like isValid('aa',''), isValid('a',''), the last one try isValid('','');
 *
 * @author jbu
 */
public class RegularExpression {
  public boolean isMatch(String s, String p) {
    if (s == null && p == null) return true;
    if (s == null || p == null) return false;
    if (p.equals(".*")) return true;
    if (p.equals("")) return s.equals("");
    return doMatch(s, p, 0, 0);
  }

  boolean doMatch(String s, String p, int ls, int lp) {
    if (lp == p.length()) return ls == s.length();
    if (lp == p.length() - 1 || p.charAt(lp + 1) != '*') { // not wildcard
      return ls < s.length() && (p.charAt(lp) == '.' || s.charAt(ls) == p.charAt(lp))
          && doMatch(s, p, ls + 1, lp + 1);
    }
    // if next char is *
    // first we try simply skip the next char+'*', (matches 0 chars in s)
    if (doMatch(s, p, ls, lp + 2)) return true;
    // then we try to match 1 and more chars in s and see if the remaining can be matched
    while (ls < s.length() && (p.charAt(lp) == '.' || s.charAt(ls) == p.charAt(lp))) {
      if (doMatch(s, p, ls + 1, lp + 2)) return true;
      ls++;
    }
    // if none can be matched, return false
    // this changes a little over leetcode, but I think it's easier to understand, which
    // inside the while, uses ls instead of ls+1.
    // For example, if .* matches 0..5 in s, that will match 0..4 first and then the last case;
    // However the code is a little hard to understand
    return false;
  }
}
