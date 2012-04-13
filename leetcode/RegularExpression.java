package leetcode;

/**
 * why we need the last return isMatch?
 * because: for example s='aa',p='a*', all the previous call is like isValid('aa',''), isValid('a',''), the last one try isValid('','');
 * @author jbu
 */
public class RegularExpression {

  public boolean isMatch(String s, String p) {
    if (p==null && s==null) return true;
    if (p==null || s==null) return false;
    if (p.equals(".*")) return true;
    if (p.equals("")) return s.equals("");
    return doMatch(s,p,0,0);
  }

  boolean doMatch(String s, String p, int ps, int pp) {
      int ls = s.length(), lp=p.length();
      if (pp==lp) return ps==ls;
      // when p reach end OR p next is not *
      if (pp==lp-1 || p.charAt(pp+1)!='*') {
        if (ps>ls-1) return false;
        return (s.charAt(ps)==p.charAt(pp) || p.charAt(pp)=='.') && doMatch(s,p,ps+1,pp+1);
      }
      // when p next is *
      while (ps<ls && (s.charAt(ps)==p.charAt(pp) || p.charAt(pp)=='.')) {
          if (doMatch(s,p,ps,pp+2)) return true;
          ps++;
      }
      return doMatch(s,p,ps,pp+2);
  }
}
