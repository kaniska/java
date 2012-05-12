package fb.string;

import java.util.Stack;

/**
 * @author jbu
 */
public class ValidParentheses {

  public boolean isValid(String s) {
    // two condition:
    // 1. always find match on top of stack
    // 2. no remainings in stack after
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '(':
        case '{':
        case '[':
          st.push(c);
          break;
        case ')':
          if (st.size() == 0 || st.peek() != '(') {
            return false;
          }
          st.pop();
          break;
        case '}':
          if (st.size() == 0 || st.peek() != '{') {
            return false;
          }
          st.pop();
          break;
        case ']':
          if (st.size() == 0 || st.peek() != '[') {
            return false;
          }
          st.pop();
          break;
        default:
          return false;
      }
    }
    return st.size() == 0;
  }
}
