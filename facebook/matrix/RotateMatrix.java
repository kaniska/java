package facebook.matrix;

/**
 * @author jbu
 */
public class RotateMatrix {

  public static int[][] rotate90(int[][] m, int algorithm) {
    switch (algorithm) {
      case 0: return rotate90a(m);
      case 1: return rotate90b(m);
      case 2: return rotate90c(m);
    }
    return null;
  }
  /**
   * use another matrix (O(nxm) space
   * @param m
   * @return
   */
  public static int[][] rotate90a(int[][] m) {
    int rows = m.length;
    int cols = m[0].length;
    int r[][] = new int[cols][rows];

    for (int i=0;i<cols;i++)
      for (int j=0;j<rows;j++) {
        r[i][j]=m[rows-1-j][i];
      }
    return r;
  }

  /**
   * in place transpose + reverse
   * -- only works when width=height
   * @param m
   * @return
   */
  public static int[][] rotate90b(int[][] m) {
    int rows = m.length;
    int cols = m[0].length;
    if (rows!=cols) return null;
    assert(rows==cols): "cols need to equal to ros: cols="+cols+"; rows="+rows;
   int t;
    for (int i=0;i<rows;i++)
      for (int j=i+1;j<cols;j++) {
        t = m[i][j];
        m[i][j]=m[j][i];
        m[j][i]= t;
      }
    for (int i=0;i<rows;i++) {
      for (int j=0;j<cols/2+1;j++) {
        t = m[i][j];
        m[i][j]=m[i][rows-1-j];
        m[i][rows-1-j] = t;
      }
    }
    return m;
  }

  /**
   * in place rotate, using 1/4 of the whole matrix to exchange
   * only when n==m
   * @param m
   * @return
   */

  public static int[][] rotate90c(int[][] m) {
    int rows = m.length;
    int cols = m[0].length;
    if (rows!=cols) return null;
    int n =rows;
    for (int i=0;i<n/2+1;i++)
      for (int j=0;j<n/2;j++) {
        int t=m[i][j];

        m[i][j] = m[n-j-1][i];
        m[n-j-1][i] = m[n-i-1][n-j-1];
        m[n-i-1][n-j-1] = m[j][n-i-1];
        m[j][n-i-1] = t;
      }
    return m;
  }

  public static boolean isEqual(int[][] m1, int[][] m2) {
    if (m1==null && m2==null) return true;
    if (m1==null || m2==null) return false;
    if (m1.length!=m2.length || m1[0].length!=m2[0].length) return false;
    for (int i=0;i<m1.length;i++)
      for (int j=0;j<m1[0].length;j++) {
        if (m1[i][j]!=m2[i][j]) return false;
      }
    return true;
  }

    public static void print(int[][] m1) {
      if (m1==null || m1[0]==null) return ;
    for (int i=0;i<m1.length;i++)     {
      for (int j=0;j<m1[0].length;j++) {
        System.out.print(m1[i][j]+",");
      }
      System.out.println();
    }
  }

  enum Type {
    NON_INPLACE(0),
    INPLACE_TRANSPOSE(1),
    INPLACE_ROTATE(2);
    int id;

    Type(int id) {
      this.id = id;
    }

    public int getId() {
      return id;
    }
  }

  public static void main(String args[]) {

    int[][] expected = new int[][]{
      {21,16,11,6,1},
      {22,17,12,7,2},
      {23,18,13,8,3},
      {24,19,14,9,4},
      {25,20,15,10,5}
    };

    for (Type t:Type.values())    {
      int[][] m = new int[][]{
        {1,2,3,4,5},
        {6,7,8,9,10},
        {11,12,13,14,15},
        {16,17,18,19,20},
        {21,22,23,24,25}
      };
      int[][] r= rotate90(m, t.getId());
      print(r);
      if (isEqual(r,expected)) System.out.println("CORRECT "+t.name());
      else System.out.println("WRONG "+t.name());
    }
  }

}
