package leetcode;

import java.util.ArrayDeque;

/**
 * @author jbu
 */
public class ContainerWithMostWater {
  public static void main(String args[]) {
    System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2, 1}));
  }

    private int getArea(int[] h, int i,int j) {
        return (j-i)*Math.min(h[i],h[j]);
    }


    public int maxArea(int[] height) {
       int i=0,j=height.length-1;
       int max = getArea(height,i,j);
       int hi,hj;
       while (i<j) {
          hi=height[i];hj=height[j];
          int v = getArea(height,i,j);
          max = max<v? v:max;
          if (hi<=hj) {
              while (i<j && height[i]<=hi) i++;
              if (i==j || height[i]==hi) break;
          } else {
              while (i<j && height[j]<=hj) j--;
              if (i==j || height[j]==hj) break;
          }
       }

       return max;
    }

  public int maxAreaBruteForce(int[] height) {
    int len = height.length;
    int max = 0;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        int area = Math.min(height[i], height[j]) * (j - i);
        max = max > area ? max : area;
      }
    }
    return max;
  }

  public int maxAreaWRONG(int[] height) {
    int len = height.length;
    int[] left = new int[len];
    int[] right = new int[len];

    ArrayDeque<Integer> q = new ArrayDeque<Integer>();

    for (int i = 0; i < len; i++) {
      while (!q.isEmpty() && height[q.peekLast()] < height[i]) {
        q.removeLast();
      }
      left[i] = q.isEmpty() ? 0 : (i - q.peekFirst());
      q.addLast(i);
    }

    q.clear();
    for (int i = len - 1; i >= 0; i--) {
      while (!q.isEmpty() && height[q.peekLast()] < height[i]) {
        q.removeLast();
      }
      right[i] = q.isEmpty() ? 0 : (q.peekFirst() - i);
      q.addLast(i);
    }
    int max = 0, area;
    for (int i = 0; i < len; i++) {
      area = (left[i] + right[i]) * height[i];
      max = max > area ? max : area;
    }

    return max;
  }
}
