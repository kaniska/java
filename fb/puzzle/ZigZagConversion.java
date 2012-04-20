package fb.puzzle;

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
    int cols = 0;
    int r1 = len / (nRows - 1);
    int r2 = len % (nRows - 1);
    if (r1 % 2 == 0) {
      cols = (nRows - 1) * (r1 >> 1) + 1;
    } else {
      cols = (nRows - 1) * (r1 >> 1) + (r2 > 1 ? r2 : 1);
    }

    char[][] r = new char[nRows][cols];

    int i = 0, cRow = 0, cCol = 0;
    while (i < len) {
      while (i < len && cRow < nRows - 1) r[cRow++][cCol] = s.charAt(i++);
      while (i < len && cRow > 0) r[cRow--][cCol++] = s.charAt(i++);
    }

    StringBuilder sb = new StringBuilder();
    for (int a = 0; a < nRows; a++)
      for (int b = 0; b < cols; b++) {
        if (r[a][b] != 0) sb.append(r[a][b]);
      }
    return sb.toString();
  }

}
