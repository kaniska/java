package fb.math;

/**
 * @author jbu
 */
public class CountAndSay {
  public String countAndSay(int n) {
    String s = "1";
    for (int i = 1; i < n; i++) {
      s = rem(s);
    }
    return s;

  }

  String rem(String s) {
    StringBuffer sb = new StringBuffer();
    char pre = s.charAt(0);
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != pre) {
        sb.append(count).append(pre);
        count = 1;
        pre = s.charAt(i);
      } else {
        count++;
      }
    }
    sb.append(count).append(pre);
    return sb.toString();
  }
}
