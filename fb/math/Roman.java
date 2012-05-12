package fb.math;

/**
 * @author jbu
 */
public class Roman {
  final static int[] N = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  final static String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String intToRoman(int num) {
    assert (num <= 3999 && num >= 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N.length && num > 0; i++) {
      while (num >= N[i]) {
        sb.append(ROMAN[i]);
        num -= N[i];
      }
    }
    return sb.toString();
  }

  public int romanToInt(String s) {
    int r = 0, cur = 0;
    for (int i = 0; i < ROMAN.length; i++) {
//          if (cur==s.length()) break;
      while (cur < s.length() && s.substring(cur).startsWith(ROMAN[i])) {
        r += N[i];
        cur += ROMAN[i].length();
      }
    }
    return r;
  }
}
