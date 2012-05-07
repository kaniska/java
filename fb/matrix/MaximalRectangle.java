package fb.matrix;

import java.util.*;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 * @author mindpower
 * @since 5/6/12 -6:36 PM
 */
public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int m = matrix.length, n = matrix[0].length;
    int[] height = new int[n];
    int max = 0;
    System.out.println("Height == ");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
        System.out.print(height[j]);
      }
      System.out.println();
      if (i == 6)
        System.out.println("AAA");
      int curMax = getHistMax(height);
      if (curMax > max) max = curMax;
    }
    return max;
  }

  int getHistMax(int[] height) {
    Deque<Integer> s = new ArrayDeque<Integer>();
    int[] lsize = new int[height.length];
    int[] rsize = new int[height.length];
    for (int i = 0; i < height.length; i++) {
      while (!s.isEmpty() && height[s.peek()] >= height[i]) s.pop();
      lsize[i] = s.isEmpty() ? i : (i - s.peek() - 1);
      s.push(i);
    }
    s.clear();
    for (int i = height.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && height[s.peek()] >= height[i]) s.pop();
      rsize[i] = s.isEmpty() ? (height.length - i - 1) : (s.peek() - i - 1);
      s.push(i);
    }
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      int cur = height[i] * (1 + lsize[i] + rsize[i]);
      if (cur > max) max = cur;
    }
    return max;
  }

  public int maximalRectangle(String[] matrix) {
    if (matrix.length == 0) return 0;
    char[][] m = new char[matrix.length][matrix[0].length()];
    System.out.println("Matrix == ");
    for (int i = 0; i < matrix.length; i++) {
      m[i] = matrix[i].toCharArray();
      System.out.println(matrix[i]);
    }
    return maximalRectangle(m);
  }

  public static void main(String[] args) {
    MaximalRectangle m = new MaximalRectangle();
    String[] matrix = new String[]{
        "10011011", "10000100", "01110011", "00010001", "00000111", "11111111", "10010110", "01101110"
    };
    System.out.println(m.maximalRectangle(new String[]{"0010", "1111", "1111", "1110", "1100", "1111", "1110"}));
  }
}
