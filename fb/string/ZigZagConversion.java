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
    int n = s.length();
    int nCols = n / (2 * (nRows - 1)) * (nRows - 1);
    int remaining = n % (2 * (nRows - 1));
    nCols = nCols + (remaining > (nRows - 1) ? remaining - (nRows - 1) : 1);
    char[][] z = new char[nRows][nCols];
    int i = 0, j = 0, col = 0, row = 0;
    while (i < n) {
      while (i < n && row < nRows - 1) z[row++][col] = s.charAt(i++);
      while (i < n && row > 0) z[row--][col++] = s.charAt(i++);
    }
    StringBuilder sb = new StringBuilder();
    for (i = 0; i < nRows; i++)
      for (j = 0; j < nCols; j++)
        if (z[i][j] != 0) sb.append(z[i][j]);
    return sb.toString();
  }
}
