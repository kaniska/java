package careercup;

/**
 * @author jbu
 */
public class C5_Bits {

  public static int setAllBits(int n, int m, int i, int j) {
    // make an int x with i-j bit as 1 only;
    int max = ~0;
    int left = max - ((1 << j) - 1);
    int right = (1 << i) - 1;
    int mask = left | right;
    return (n & mask) | (m << i);
  }

  public static String printBinary(String n) {
    int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
    double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));
    String int_string = "";
    while (intPart > 0) {
      int r = intPart % 2;
      intPart >>= 1;
      int_string = r + int_string;
    }
    StringBuffer dec_string = new StringBuffer();
    while (decPart > 0) {
      if (dec_string.length() > 32) {
        return "ERROR";
      }
      if (decPart == 1) {
        dec_string.append((int) decPart);
        break;
      }
      double r = decPart * 2;
      if (r >= 1) {
        dec_string.append(1);
        decPart = r - 1;
      } else {
        dec_string.append(0);
        decPart = r;
      }
    }
    return int_string + "." + dec_string.toString();
  }

  public static String printBinary(double d) {
    String s = "";
    if (d < 0) {
      s = "-";
    }
    long l = (long)Math.floor(d);
    while (l > 0) {
      if (l % 2 > 0) {
        s = '1' + s;
      } else {
        s = '0' + s;
      }
      l >>= 1;
    }
    s += '.';
    d -= (long)Math.floor(d);
    int c =0;
    while (d > 0) {
      d = d *2;
      if (++c>64) return "ERROR";
      if (d  >= 1) {
        s = s + '1';
        d -= 1;
      } else {
        s = s + '0';
      }
    }
    return s;
  }

  public static int bitsConvert(int a, int b) {
    int n =0;
    for (int c= a^b;c!=0;c=c>>1) if (c%2==1) n++;
    return n;
  }

  public static int bitsSwap(int n) {

    return n;
  }

  public static void main(String args[]) {
    int n = Integer.parseInt("10001111100", 2);
    int m = Integer.parseInt("10101", 2);
    int r = setAllBits(n, m, 2, 6);
    System.out.println(Integer.toBinaryString(r));
    System.out.println(printBinary("3.12312"));
    System.out.println(printBinary(3.92312));

    System.out.println(bitsConvert(31,14));
  }
}
