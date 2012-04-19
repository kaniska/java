package facebook.math;

/**
 * @author jbu
 */
public class Convert {
  public static float parseFloat(String s) {
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
          if (isNeg) throw new IllegalArgumentException("Wrong number" + s);
          else isNeg = true;
          break;
        case '.':
          if (exp || afterPoint) throw new IllegalArgumentException("Wrong number" + s);
          else afterPoint = true;
          break;
        case 'e':
        case 'E':
          if (exp) throw new IllegalArgumentException("Wrong number" + s);
          else exp = true;
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
          } else if (afterPoint) {
            f += (float)(c - '0') / divider;
            divider *= 10;
          } else {
            f = f * 10 + (c - '0');
          }
          break;
        default:
         throw new IllegalArgumentException("Wrong number" + s);
      }
    }
    while (power > 0) {
      f *= 10;
      if (f>Float.MAX_VALUE) throw new IllegalArgumentException("Wrong number" + s);
      power--;
    }
    return isNeg ? -f : f;

  }

  public static void main(String args[]) {
    String[] s = {"123123e1213","-123123", "099081", "212.21", "-21.2218302", "122.333e21", "-12123.33e5", "--123a3", "12a", "123.123.2", "12.22e123.3"};
    for (String s1 : s) {
      try {
      System.out.println(s1 + "=" + parseFloat(s1));
      } catch (Exception e) {
        System.out.println("Exception="+e.getMessage());
      }
    }
  }
}
