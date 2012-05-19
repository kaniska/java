package fb.string;

/**
 * @author jbu
 */
public class ZigZagConversion {
  public static void main(String args[]) {
    System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 2));
    System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
  }

  public String convert(String s, int nRows) {
    if (nRows == 1) return s;
    int len = s.length();
    int cols = len / (2 * nRows - 2) * (nRows - 1);
    int remain = len % (2 * nRows - 2);
    cols += (remain < nRows ? 1 : (remain - nRows + 1));
    char[][] lines = new char[nRows][cols];
    int i = 0, j = 0, row = 0, col = 0;
    while (i < s.length()) {
      while (i < s.length() && row < nRows - 1) lines[row++][col] = s.charAt(i++);
      while (i < s.length() && row > 0) lines[row--][col++] = s.charAt(i++);
    }
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < nRows; i++) {
      for (j = 0; j < cols; j++) {
        if (lines[i][j] != 0) sb.append(lines[i][j]);
      }
    }
    return sb.toString();
  }
}
