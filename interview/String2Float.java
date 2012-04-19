package interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jbu
 */
public class String2Float {
  public static Pattern p = Pattern.compile("[+-]?\\d+(\\.\\d*)?([e|E][+-]?\\d+)?");

  public static boolean isValid(String s) {
    Matcher m = p.matcher(s);
    return m.matches();
  }

  public static float string2float(String s) throws NumberFormatException {
    if (!isValid(s)) {
      throw new NumberFormatException("Invalid Number=" + s);
    }

    float f = 0;
    int exp = 0;
    char[] a = s.toCharArray();
    boolean afterE = false;
    boolean positiveNum = true;
    boolean positiveE = true;
    boolean floatingPoint = false;
    float floatingFactor = 0.1f;

    for (char c : a) {
      switch (c) {
        case '+':
          continue;
        case '-':
          if (afterE) {
            positiveE = false;
          } else {
            positiveNum = false;
          }
          break;
        case '.':
          floatingPoint = true;
          break;
        case 'e':
        case 'E':
          afterE = true;
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
          if (afterE) {
            exp = 10 * exp + (c - '0');
          } else if (!floatingPoint) {
            f = 10 * f + (c - '0');
          } else {
            f = f + (c - '0') * floatingFactor;
            floatingFactor /= 10;
          }
      }
    }

    while (exp>0) {
      f = positiveE? f*10: f/10;
      exp--;
    }
    f = positiveNum? f: f*(-1);
    return f;
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o);
    }
    System.out.println(sb.toString());
  }

 public static float string2float(String s, boolean exception) throws NumberFormatException {
   if (exception) return string2float(s);
   try {
     return string2float(s);
   } catch (NumberFormatException e) {
     p(e);
   }
   return 0;
 }

  public static void main(String args[]) {
    p(string2float("SS", false));
    p(string2float("12.567", false));
    p(string2float("12312456.32424", false));
    p(string2float("-123123.e", false));
    p(string2float("12123.e-1", false));
    p(string2float("123123.43545e12",false));

  }

}
