package fb.math;

/**
 * (1) char array need to be initialized to '0';
 * (2) convert int to char need to be explicitly
 * (3) skip 0s in the begining of the result
 * (4) but also need to consider all 0s
 * (5) carry need to be cleared every run (j=0)
 * (6) when adding the last carry, remember j is already -1,
 * XXXXXXXXX
 * YYYY
 * --------------------
 * NZZZZZZZZZ
 * NZZZZZZZZZ
 * NZZZZZZZZZ
 * NZZZZZZZZZ
 * total lens between i+j-1, i+j
 *
 * @author jbu
 */
public class Multiply {
  public String multiply(String num1, String num2) {
    int len1 = num1.length(), len2 = num2.length();
    char[] r = new char[len1 + len2];
    for (int i = 0; i < r.length; i++) {
      r[i] = '0';
    }
    for (int i = len1 - 1; i >= 0; i--) {
      int j = 0, carry = 0;
      for (j = len2 - 1; j >= 0; j--) {
        int x = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + (r[1 + i + j] - '0') + carry;
        r[1 + i + j] = (char) (x % 10 + '0');
        carry = x / 10;
      }
      r[i] = (char) (carry + '0');
    }
    int s = 0;
    while (s < r.length && r[s] == '0') {
      s++;
    }
    if (s == r.length) {
      return "0";
    }
    return new String(r).substring(s);
  }
}
