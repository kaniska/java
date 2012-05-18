package fb.matrix;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-1:45 PM
 */
public class GenerateSpiralMatrix {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int x1=0,y1=0, x2=n-1, y2=n-1;
    int number = 1;
    while (x1<=x2 && y1<=y2) {
      if (x1==x2) {
        for (int row=y1;row<=y2;row++) matrix[row][x1]=number++;
        break;
      }
      if (y1==y2) {
        for (int col=x1;col<=x2;col++) matrix[y1][col]=number++;
        break;
      }
      for (int col=x1;col<=x2;col++) matrix[y1][col]=number++;
      for (int row=y1+1;row<y2;row++) matrix[row][x2]=number++;
      for (int col=x2;col>=x1;col--) matrix[y2][col]=number++;
      for (int row=y2-1;row>y1;row--) matrix[row][x1]=number++;
      x1++;y1++;x2--;y2--;
    }
    return matrix;

  }
}
