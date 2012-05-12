package fb.matrix;

import java.util.*;

/**
 * @author jbu
 */
public class SpiralOrderPrint {

  public ArrayList<Integer> spiralOrderRecursive(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (matrix.length == 0) {
      return result;
    }
    int m = matrix.length, n = matrix[0].length;
    traverse(matrix, 0, 0, m - 1, n - 1, result);
    return result;
  }

  void traverse(int[][] matrix, int si, int sj, int ei, int ej, ArrayList<Integer> result) {
    if (si > ei || sj > ej) {
      return;
    }
    if (si == ei) {
      for (int j = sj; j <= ej; j++) {
        result.add(matrix[si][j]);
      }
      return;
    }
    if (sj == ej) {
      for (int i = si; i <= ei; i++) {
        result.add(matrix[i][sj]);
      }
      return;
    }
    for (int j = sj; j <= ej; j++) {
      result.add(matrix[si][j]);
    }
    for (int i = si + 1; i < ei; i++) {
      result.add(matrix[i][ej]);
    }
    for (int j = ej; j >= sj; j--) {
      result.add(matrix[ei][j]);
    }
    for (int i = ei - 1; i > si; i--) {
      result.add(matrix[i][sj]);
    }
    traverse(matrix, si + 1, sj + 1, ei - 1, ej - 1, result);
  }

  /**
   * @param matrix
   * @return
   * @since 04/21/2012
   */
  public ArrayList<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (matrix.length == 0) {
      return result;
    }
    int m = matrix.length, n = matrix[0].length;
    int si = 0, sj = 0, ei = m - 1, ej = n - 1;
    while (si <= ei && sj <= ej) {
      if (si == ei) {
        for (int j = sj; j <= ej; j++) {
          result.add(matrix[si][j]);
        }
        break;
      }
      if (sj == ej) {
        for (int i = si; i <= ei; i++) {
          result.add(matrix[i][sj]);
        }
        break;
      }
      for (int j = sj; j <= ej; j++) {
        result.add(matrix[si][j]);
      }
      for (int i = si + 1; i < ei; i++) {
        result.add(matrix[i][ej]);
      }
      for (int j = ej; j >= sj; j--) {
        result.add(matrix[ei][j]);
      }
      for (int i = ei - 1; i > si; i--) {
        result.add(matrix[i][sj]);
      }
      si++;
      sj++;
      ei--;
      ej--;
    }
    return result;
  }

  static int[][] m = null;

  public static int[][] getMatrix(int m, int n) {
    Random r = new Random();
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = r.nextInt(100);
      }
    }
    return matrix;
  }

  public static void print(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int printInside(int[][] m) {
    int x1 = 0, y1 = 0, x2 = m.length - 1, y2 = m[0].length - 1;
    int count = 0;
    while (x1 <= x2 && y1 <= y2) {
      for (int col = y1; col < y2; col++) {
        System.out.print(m[x1][col] + " ");
      }
      for (int row = x1; row <= x2; row++) {
        System.out.print(m[row][y2] + " ");
      }
      if (x1 != x2) {
        for (int col = y2 - 1; col > y1; col--) {
          System.out.print(m[x2][col] + " ");
        }
      }
      if (y1 != y2) {
        for (int row = x2; row > x1; row--) {
          System.out.print(m[row][y1] + " ");
        }
      }
      x1++;
      y1++;
      x2--;
      y2--;
    }
    System.out.println("total=" + count);
    return count;
  }

  public static void main(String args[]) {
    int[][] m = getMatrix(7, 3);
    print(m);
    System.out.println();
    printInside(m);
  }
}
