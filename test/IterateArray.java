package test;

import java.io.Console;

/**
 * @author Junjie Bu
 */
public class IterateArray {

  /**
   * Print two dimension array in a clockwise inward spiral
   * <p/>
   * we iteratively print the array as following:
   * we print out most rectangle first, then we print the inner one, and continue until we already prints all elements.
   * Suppose the (width,height) is the array size,
   * and (h,w) is index of the top left element of the current inner array (rectangle as shown below)
   * we are going to print A row first, then B col, then C row, then D col.
   * And after that we will increase h, w by one and continue.
   * <p/>
   * (h,w)               (h,width-w-1)
   * AAAAAAAAAAAAAAAAAAAAAAAA
   * D                      B
   * D                      B
   * D                      B
   * CCCCCCCCCCCCCCCCCCCCCCCC
   * (height-h-1,w)     (height-h-1,width-w-1)
   *
   * @param a two dimension object array
   */
  public static void PrintArray(Object[][] a) {
    if (a==null || a.length==0 || a[0].length==0) {
      return;
    }
    int width = a[0].length;
    int height = a.length;

    System.out.print("Output: ");

    // each round we print A row,B column,then C row,D column, and then increase w, h, and continue
    // w, h is the array index of the top left most element of the inner array for each round
    int w = 0, h = 0, i = 0;
    while (w < (width + 1) / 2 && h < (height + 1) / 2) {
      // print A row
      for (i = w; i < width - w; i++) {
        System.out.printf("%s ", a[h][i]);
      }
      // print B column
      for (i = h + 1; i < height - h - 1; i++) {
        System.out.printf("%s ",a[i][width - w - 1]);
      }
      // print C row, we need check whether it's same as A row
      for (i = width - w - 1; i >= w && height - h - 1 > h; i--) {
        System.out.printf("%s ",a[height - h - 1][i]);
      }
      // print D column, we need check whether it's same as B column
      for (i = height - h - 2; i > h && w < width - w - 1; i--) {
        System.out.printf("%s ",a[i][w]);
      }
      w++;
      h++;
    }
    System.out.println();
  }

  public static void main(String args[]) {
    Console c = System.console();
    if (c == null) {
      System.out.println("can't get console instance, exit");
      return;
    }
    // assume all inputs are valid
    while (true) {
      String s = c.readLine("Input array size as: <# rows> <# cols>\n");
      String[] s1 = s.split("\\s");
      if (s1.length != 2) {
        break; //exit
      }
      int rows, cols;
      rows = Integer.parseInt(s1[0]);
      cols = Integer.parseInt(s1[1]);
      if (rows<=0 || cols<=0) {
        continue;
      }
      String[][] input = new String[rows][];
      System.out.println("Input array data row by row:");
      for (int i = 0; i < rows; i++) {
        s = c.readLine();
        input[i] = s.split("\\s");
        if (input[i].length != cols) {
          System.out.println("Wrong input, pleas try again:");
          i--;
        }
      }
      PrintArray(input);
    }
  }
}
