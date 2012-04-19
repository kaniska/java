package facebook.permutation;

public class Combination {
  static void doCombination(char[] s, int pos, int start, StringBuilder sb) {
    for (int i = start; i < s.length; i++) {
      sb.append(s[i]);
      System.out.println(sb.toString());
      doCombination(s, pos + 1, i + 1, sb);
      sb.setLength(sb.length() - 1);
    }
  }

  public static void combination(char[] s) {
    StringBuilder sb = new StringBuilder();
    Combination.doCombination(s, 0, 0, sb);
  }

    public static void main(String args[]) {
    String s = "abcdefgh";
    char[] s1 = s.toCharArray();
    long start = System.currentTimeMillis();

    combination("wxyz".toCharArray());

  }
}