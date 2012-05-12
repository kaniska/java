package fb.string;

/**
 * @author jbu
 * @since 3/19/12 7:15 PM
 */
public class RobinKarp {
  private String pat;
  private int patHash;
  private int M;
  private int Q = 8335967;
  private int R;
  private int RM;

  public RobinKarp(String needle) {
    this.pat = needle;
    this.R = 256;
    this.M = pat.length();
    RM = 1;
    for (int i = 1; i < M; i++) {
      RM = (R * RM) % Q; // R^(M-1)
    }
    System.out.println("RM=" + RM);
    patHash = hash(pat);
  }

  private int hash(String text) {
    int h = 0;
    for (int i = 0; i < M; i++) {
      h = (h * R + text.charAt(i)) % Q;
    }
    return h;
  }

  public int search(String txt) {
    int N = txt.length();
    if (N < M) {
      return N;
    }
    int offset = hashSearch(txt);
    if (offset == N) {
      return N;
    }
    for (int i = 0; i < M; i++) {
      if (pat.charAt(i) != txt.charAt(offset + i)) {
        return N;
      }
    }
    return offset;
  }

  private int hashSearch(String txt) {
    int N = txt.length();
    int txtHash = hash(txt);
    if (patHash == txtHash) {
      return 0;
    }
    for (int i = M; i < N; i++) {
      txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
      txtHash = (txtHash * R + txt.charAt(i)) % Q;
      if (patHash == txtHash) {
        return i - M + 1;
      }
    }
    return N;
  }

  public static void main(String args[]) {
    RobinKarp r = new RobinKarp("love ");
    String hay = "Hello World, I love you";
    int i = r.hashSearch(hay);
    System.out.println(i == hay.length() ? null : hay.substring(i));
  }
}
