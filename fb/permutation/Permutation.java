package fb.permutation;

/**
 * @author jbu
 */
public class Permutation {
  private static void swap(char[] s, int i, int j) {
    char t = s[i];
    s[i] = s[j];
    s[j] = t;
  }

  private static void reverse(char[] s, int i, int j) {
    for (int k = i; k <= (i + j) / 2; k++) {
      swap(s, k, i + j - k);
    }
  }

  public static boolean nextPermutation(char[] s) {
    int len = s.length;
    if (len == 1) {
      return false;
    }
    int tail = len - 1, head = tail - 1;
    while (head >= 0 && s[head] >= s[head + 1]) {
      head--;
    }
    if (head < 0) {
      return false;//already max
    }
    while (s[tail] <= s[head]) {
      tail--;
    }
    swap(s, head, tail);
    reverse(s, head + 1, len - 1);
    return true;
  }

  static long count = 0;

  private static void doPermutation(char[] s, int pos, boolean[] used, char[] cur) {
    int len = s.length;
    if (pos == len) {
      count++;
      //     System.out.println(count+++":"+String.valueOf(cur));
      return;
    }
    for (int i = 0; i < len; i++) {
      if (!used[i]) {
        cur[pos] = s[i];
        used[i] = true;
        doPermutation(s, pos + 1, used, cur);
        used[i] = false;
      }
    }
  }

  public static void permutation(char[] s) {
    char[] current = new char[s.length];
    boolean[] used = new boolean[s.length];
    doPermutation(s, 0, used, current);
  }

  public static void main(String args[]) {
    String s = "abcdefgh";
    char[] s1 = s.toCharArray();
    long start = System.currentTimeMillis();
    int cc = 0;
    while (nextPermutation(s1)) {
//      System.out.println(s1);
      cc++;
    }
    System.out.println(cc + ":" + (System.currentTimeMillis() - start));
    start = System.currentTimeMillis();
    permutation(s.toCharArray());
    System.out.println(count + ":" + (System.currentTimeMillis() - start));
  }
}
