package fb.math;

/**
 * @author jbu
 */
public class ATOI {

  /**
   * HANDLE overflow by check total/10 is less than pre
   *
   * @param str
   * @return
   */
  public int atoi(String str) {
    int i = 0;
    int len = str.length();
    while (i < len && str.charAt(i) == ' ') i++;
    boolean isNeg = false;

    if (i < len && str.charAt(i) == '+') i++;
    if (i < len && str.charAt(i) == '-') {
      i++;
      isNeg = true;
    }
    int total = 0, pre = 0;
    boolean overflow = false;
    for (int k = i; k < len; k++) {
      char c = str.charAt(k);
      if (c > '9' || c < '0') break;
      total = total * 10 + (c - '0');
      if (total / 10 < pre) {
        overflow = true;
        break;
      }
      pre = total;
    }
    if (overflow) return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    return isNeg ? -total : total;
  }

  public static void main(String args[]) {
    System.out.println(Integer.MAX_VALUE / 2);
    int b = Integer.MAX_VALUE / 2 + 100000000;

    int a = b + Integer.MAX_VALUE / 2;
    System.out.printf("%d, %d, %d\n", b, a, a - 10000);
    System.out.println(Integer.MAX_VALUE);
  }

}
