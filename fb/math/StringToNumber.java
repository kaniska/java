package fb.math;

/**
 * @author jbu
 */
public class StringToNumber {

  public int atoi(String str) {
    // ^\\s+[+-]?\\d+\\s+$    overflow?
    // ignore illegal char after a valid number?
    // OK. Hard to handle overflow
    // WHat if it's MIN_VALUE,
    // or > MAX_VALUE OR < MIN_VALUE
    int n = str.length(), i = 0;
    while (i < n && (str.charAt(i) == ' ' || str.charAt(i) == '\t')) {
      i++;
    }
    boolean isNeg = false;
    if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
      isNeg = str.charAt(i++) == '-';
    }
    int num = 0;
    while (i < n && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
      // use x for overflow check
      int x = str.charAt(i) - '0';
      if ((Integer.MAX_VALUE - x) / 10 < num) {
        return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      num = num * 10 + x;
      i++;
    }
    return isNeg ? -num : num;
  }

  public static float atof(String s) {
    boolean isNeg = false;
    boolean afterPoint = false;
    long divider = 10;
    boolean exp = false;
    int power = 0;
    float f = 0;
    char c;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      switch (c) {
        case '-':
          if (isNeg) {
            throw new IllegalArgumentException("Wrong number" + s);
          }
          else {
            isNeg = true;
          }
          break;
        case '.':
          if (exp || afterPoint) {
            throw new IllegalArgumentException("Wrong number" + s);
          }
          else {
            afterPoint = true;
          }
          break;
        case 'e':
        case 'E':
          if (exp) {
            throw new IllegalArgumentException("Wrong number" + s);
          }
          else {
            exp = true;
          }
          break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
          if (exp) {
            power = power * 10 + (c - '0');
          }
          else if (afterPoint) {
            f += (float) (c - '0') / divider;
            divider *= 10;
          }
          else {
            f = f * 10 + (c - '0');
          }
          break;
        default:
          throw new IllegalArgumentException("Wrong number" + s);
      }
    }
    while (power > 0) {
      f *= 10;
      if (f > Float.MAX_VALUE) {
        throw new IllegalArgumentException("Wrong number" + s);
      }
      power--;
    }
    return isNeg ? -f : f;
  }

  public static void main(String args[]) {
    String[] s = {"123123e1213", "-123123", "099081", "212.21", "-21.2218302", "122.333e21", "-12123.33e5", "--123a3", "12a", "123.123.2", "12.22e123.3"};
    for (String s1 : s) {
      try {
        System.out.println(s1 + "=" + atof(s1));
      }
      catch (Exception e) {
        System.out.println("Exception=" + e.getMessage());
      }
    }
  }
}
