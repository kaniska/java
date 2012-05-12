package fb.permutation;

/**
 * @author jbu
 */
public class CombinationKChars {
  private static void doCombination(char[] s, int k, int pos, int start, StringBuilder sb) {
    if (pos >= k) {
      System.out.println(sb.toString());
      return;
    }
    for (int i = start; i < s.length; i++) {
      sb.append(s[i]);
      doCombination(s, k, pos + 1, i + 1, sb);
      sb.setLength(sb.length() - 1);
    }
  }

  public static void combination(char[] s, int k) {
    StringBuilder sb = new StringBuilder();
    doCombination(s, k, 0, 0, sb);
  }

  public static void main(String args[]) {
    combination("ABCDEF".toCharArray(), 4);
  }
}
