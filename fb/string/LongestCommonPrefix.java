package fb.string;

/**
 * @author jbu
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix0421(String[] strs) {
    StringBuilder sb = new StringBuilder();
    if (strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    int pos = 0;
    char c;
    outer:
    while (true) {
      if (strs[0].length() - 1 < pos) {
        break;
      }
      c = strs[0].charAt(pos);
      for (int i = 1; i < strs.length; i++) {
        if (strs[i] == null || strs[i].length() - 1 < pos || strs[i].charAt(pos) != c) {
          break outer;
        }
      }
      sb.append(c);
      pos++;
    }
    return sb.toString();
  }

  public String longestCommonPrefix(String[] strs) {
    int i = 0;
    if (strs == null || strs.length == 0) {
      return "";
    }
    while (true) {
      if (strs[0].length() <= i) {
        return strs[0].substring(0, i);
      }
      char c = strs[0].charAt(i);
      for (int k = 1; k < strs.length; k++) {
        if (strs[k].length() <= i || strs[k].charAt(i) != c) {
          return strs[k].substring(0, i);
        }
      }
      i++;
    }
  }
}
