package fb.matrix;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-1:45 PM
 */
public class GenerateSpiralMatrix {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int k = 1;
    int x1 = 0, y1 = 0, x2 = n - 1, y2 = n - 1;
    while (x1 <= x2 && y1 <= y2) {
      if (x1 == x2) {
        for (int j = y1; j <= y2; j++) {
          matrix[x1][j] = k++;
        }
        break;
      }
      if (y1 == y2) {
        for (int i = x1; i <= x2; i++) {
          matrix[i][y1] = k++;
        }
        break;
      }
      for (int j = y1; j <= y2; j++) {
        matrix[x1][j] = k++;
      }
      for (int i = x1 + 1; i < x2; i++) {
        matrix[i][y2] = k++;
      }
      for (int j = y2; j >= y1; j--) {
        matrix[x2][j] = k++;
      }
      for (int i = x2 - 1; i > x1; i--) {
        matrix[i][y1] = k++;
      }
      x1++;
      y1++;
      x2--;
      y2--;
    }
    return matrix;
  }
}
