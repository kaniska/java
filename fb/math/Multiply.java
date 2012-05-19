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
    int n1 = num1.length(), n2 = num2.length();
    int[] result = new int[n1 + n2];
    for (int i = n1 - 1; i >= 0; i--) {
      int carry = 0, j, t;
      for (j = n2 - 1; j >= 0; j--) {
        t = carry + result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        result[i + j + 1] = t % 10;
        carry = t / 10;
      }
      result[i + j + 1] = carry;
    }
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < result.length - 1 && result[i] == 0) i++;
    while (i < result.length) sb.append((char) (result[i++] + '0'));
    return sb.toString();
  }
}
