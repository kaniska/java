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
    if (s1.equals(s2)) {
      return true;
    }
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    return isScramble(c1, 0, c1.length, c2, 0, c2.length);
  }

  boolean isScramble(char[] c1, int start1, int end1, char[] c2, int start2, int end2) {
    if (!isSameCharSet(c1, start1, end1, c2, start2, end2)) {
      return false;
    }
    if (end1 - start1 == 1) {
      return c1[start1] == c2[start2];
    }
    for (int i = 1; i < end1 - start1; i++) {
      if (isScramble(c1, start1, start1 + i, c2, start2, start2 + i) &&
          isScramble(c1, start1 + i, end1, c2, start2 + i, end2))
      {
        return true;
      }
      if (isScramble(c1, start1, start1 + i, c2, end2 - i, end2) &&
          isScramble(c1, start1 + i, end1, c2, start2, end2 - i))
      {
        return true;
      }
    }
    return false;
  }

  boolean isSameCharSet(char[] c1, int start1, int end1, char[] c2, int start2, int end2) {
    int[] charCount = new int[256];
    if (end1 - start1 != end2 - start2) {
      return false;
    }
    for (int i = start1; i < end1; i++) {
      charCount[c1[i]]++;
    }
    for (int i = start2; i < end2; i++) {
      charCount[c2[i]]--;
    }
    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
