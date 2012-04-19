package fb.matrix;

import java.util.Random;

/**
 * @author jbu
 */
public class MatrixPrint {
  static int[][] m = null;

  public static int[][] getMatrix(int m, int n) {
    Random r = new Random();
    int[][] matrix = new int[m][n];
    for (int i=0;i<m;i++)
      for (int j=0;j<n;j++)
        matrix[i][j] =  r.nextInt(100);
    return matrix;
  }

  public static void print(int[][] m) {
    for (int i=0;i<m.length;i++) {
      for (int j=0;j<m[0].length;j++)
        System.out.print(m[i][j]+" ");
      System.out.println();
    }
  }

  public static int printInside(int[][] m) {
    int x1=0,y1=0,x2=m.length-1,y2=m[0].length-1;
    int count=0;
    while (x1<=x2 && y1<=y2) {
       for (int col=y1;col<y2;col++) System.out.print(m[x1][col]+" ");
      for (int row=x1;row<=x2;row++) System.out.print(m[row][y2]+" ");
      if (x1!=x2)
        for (int col=y2-1;col>y1;col--) System.out.print(m[x2][col]+" ");
      if (y1!=y2)
        for (int row=x2;row>x1;row--) System.out.print(m[row][y1]+" ");
      x1++;y1++; x2--;y2--;
    }
    System.out.println("total="+count);
    return count;
  }

  public static void main(String args[]) {
    int[][] m = getMatrix(7, 3);
    print(m); System.out.println();
    printInside(m);
  }

}
