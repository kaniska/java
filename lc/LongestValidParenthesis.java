package lc;

/**
 * @author jbu
 */
public class LongestValidParenthesis {
  // put into index of the left parenthesis into stack,
  // and pop up when meet right parenthesis
  // everytime pop up, peek the top of the stack (which is the one hasn't been processed yet,
  // and calcuate the current length, if stack is empty, take as -1,
  public int longestValidParentheses(String s) {
    Deque<Integer> d = new ArrayDeque<Integer>();
    int max = 0, cur;
    for (int i = 0; i < s.length(); i++) {
      if (d.isEmpty() || s.charAt(i) == '(' || s.charAt(d.peek()) != '(') d.push(i);
      else {
        d.pop();
        cur = d.isEmpty() ? i + 1 : i - d.peek();
        max = max < cur ? cur : max;
      }
    }
    return max;
  }

}
