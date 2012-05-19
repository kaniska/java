package fb.string;

/**
 * www.leetcode.com
 * <p/>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p/>
 * Below is one possible representation of s1 = "great":
 * <p/>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p/>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p/>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p/>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p/>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p/>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * @author mindpower
 * @since 5/6/12 -4:58 PM
 */
public class ScrambleString {
  public boolean isScramble(String s1, String s2) {
    //       if (s1.equals(s2)) return true;
    return isScramble(s1, 0, s1.length(), s2, 0, s2.length());
  }

  boolean isScramble(String s1, int l1, int r1, String s2, int l2, int r2) {
    if (!isSameCharSet(s1, l1, r1, s2, l2, r2)) return false;
    if (r1 == l1 + 1) return true;
    for (int i = 1; i < r1 - l1; i++) {
      if (isScramble(s1, l1, l1 + i, s2, l2, l2 + i) && isScramble(s1, l1 + i, r1, s2, l2 + i, r2)) return true;
      // the second compare range are very tricky and I got it wrong several times
      // better draw picture
      if (isScramble(s1, l1, l1 + i, s2, r2 - i, r2) && isScramble(s1, l1 + i, r1, s2, l2, r2 - i)) return true;
    }
    return false;
  }

  boolean isSameCharSet(String s1, int l1, int r1, String s2, int l2, int r2) {
    if ((r1 - l1) != (r2 - l2)) return false;
    int[] c = new int[256];
    for (int i = l1; i < r1; i++) c[s1.charAt(i)]++;
    for (int i = l2; i < r2; i++) c[s2.charAt(i)]--;
    for (int i = 0; i < c.length; i++) {
      if (c[i] != 0) return false;
    }
    return true;
  }
}
