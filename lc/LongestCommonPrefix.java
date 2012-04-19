package lc;

/**
 * @author jbu
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    int i = 0;
    if (strs == null || strs.length == 0) return "";

    while (true) {
      if (strs[0].length() <= i) return strs[0].substring(0, i);
      char c = strs[0].charAt(i);
      for (int k = 1; k < strs.length; k++) {
        if (strs[k].length() <= i || strs[k].charAt(i) != c) return strs[k].substring(0, i);
      }
      i++;
    }
  }
}
