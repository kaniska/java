package fb.math;

/**
 * @author jbu
 */
public class Multiplication {
  public static String multiply(String s1, String s2) {
    char[] m1 = s1.toCharArray();
    char[] m2 = s2.toCharArray();
    int[] result = new int[s1.length() + s2.length()];
    for (int i = m2.length - 1; i >= 0; i--) {
      int[] carry = new int[m1.length + 1];
      for (int j = m1.length - 1; j >= 0; j--) {
        int x = result[i + j + 1] + (m1[j] - '0') * (m2[i] - '0') + carry[j + 1];
        result[i + j + 1] = x % 10;
        carry[j] = x / 10;
      }
      result[i] += carry[0];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      if (i == 0 && result[i] == 0) {
        continue;
      }
      sb.append((char) (result[i] + '0'));
    }
    return sb.toString();

  }

  public static void main(String args[]) {
    System.out.println(multiply("0", "6891012"));
  }

}
