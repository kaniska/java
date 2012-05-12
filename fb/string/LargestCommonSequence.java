package fb.string;

/**
 * @author jbu
 */
public class LargestCommonSequence {
  public static int find(String a, String b) {
    return find(a.toCharArray(), 0, b.toCharArray(), 0);
  }

  public static int find(char[] a, int i, char[] b, int j) {
    if (i == a.length || j == b.length) {
      return 0;
    }
    if (a[i] == b[j]) {
      return 1 + find(a, i + 1, b, j + 1);
    }
    else {
      return Math.max(find(a, i + 1, b, j), find(a, i, b, j + 1));
    }
  }

  public static String findUsingDP(String a, String b) {
    int[][] L = new int[a.length()][b.length()];
    int max = -1;
    for (int i = a.length() - 1; i >= 0; i--) {
      for (int j = b.length() - 1; j >= 0; j--) {
        if (a.charAt(i) == b.charAt(j)) {
          if (i == a.length() - 1 || j == b.length() - 1) {
            L[i][j] = 1;
          }
          else {
            L[i][j] = 1 + L[i + 1][j + 1];
          }
        }
        else {
          if (i == a.length() - 1 || j == b.length() - 1) {
            L[i][j] = 0;
          }
          else {
            L[i][j] = Math.max(L[i + 1][j], L[i][j + 1]);
          }
        }
        if (L[i][j] > max) {
          max = L[i][j];
        }
      }
    }
    System.out.println(max);
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while (i < a.length() && j < b.length()) {
      if (a.charAt(i) == b.charAt(j)) {
        sb.append(a.charAt(i));
        i++;
        j++;
      }
      else if (L[i + 1][j] >= L[i][j + 1]) {
        i++;
      }
      else {
        j++;
      }
    }
    return sb.toString();
  }

  public static void main(String args[]) {
    long t = System.currentTimeMillis();
    System.out.println(find("NemAtode kNOwledge", "nematode knowledge"));
    System.out.println((System.currentTimeMillis() - t) + "ms");
    t = System.currentTimeMillis();
    System.out.println(findUsingDP("NemAtode kNOwledge", "nematode knowledge"));
    System.out.println((System.currentTimeMillis() - t) + "ms");
  }
}
