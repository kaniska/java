package fb.puzzle;

import java.util.Stack;

/**
 * @author: mindpower
 * @since: 5/12/12-4:08 PM
 */
public class LargestRectangle {
  public int largestRectangleArea(int[] height) {
    Stack<Integer> s = new Stack<Integer>();
    int len = height.length;
    int [] left = new int[len];
    int [] right = new int[len];
    int index =0;
    for (int i=0;i<len;i++) {
      while (!s.isEmpty() && height[s.peek()]>=height[i]) s.pop();
      left[i]= i- (s.isEmpty()? -1: s.peek()) -1;
      s.push(i);
    }
    s.clear();
    for (int i=len-1;i>=0;i--) {
      while (!s.isEmpty() && height[s.peek()]>=height[i]) s.pop();
      right[i]=  (s.isEmpty()? len : s.peek()) -i-1;
      s.push(i);
    }
    int max = 0;
    for (int i=0;i<len;i++) {
      int total = height[i]*(left[i]+right[i]+1);
      max = Math.max(total,max);
    }
    return max;


  }
}
