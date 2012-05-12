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
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i==0 || s.charAt(i)==s.charAt(i-1)) {
        count++;
      } else {
        sb.append(count).append(s.charAt(i-1));
        count=1;
      }
    }
    sb.append(count).append(s.charAt(s.length()-1));
    return sb.toString();
  }
}
