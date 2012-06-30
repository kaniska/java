package fb.tree;

import java.util.Stack;

/**
 * http://www.careercup.com/question?id=13262681
 *
 * @author: mindpower
 * @since: 5/29/12-8:35 AM
 */
public class BinaryTreeString {
  public static int findDepth(String s) {
    if (s == null || s.length() < 4) return -1;
    int maxDepth = 0;
    int countLeft = 0;
    Stack<Character> st = new Stack<Character>();
    for (char c : s.toCharArray()) {
      switch (c) {
        case '(':
          countLeft++;
          maxDepth = maxDepth < countLeft ? countLeft : maxDepth;
          st.push('(');
          break;
        case ')':
          if (st.isEmpty() || st.pop() != '0') return -1;
          if (st.isEmpty() || st.pop() != '0') return -1;
          if (st.isEmpty() || st.pop() != '(') return -1;
          st.push('0');
          countLeft--;
          break;
        case '0':
          st.push('0');
          break;
        default:
          return -1;
      }
    }
    return (!st.isEmpty() && st.size() == 1 && st.pop() == '0') ? maxDepth - 1 : -1;
  }

  public static void main(String[] args) {
    String s1 = "(00)";         //0
    String s2 = "((00)0)";       // 1
    String s3 = "((00)(00))";     // 1
    String s4 = "((00)(0(00)))";  // -> 2
    String s5 = "((00)(0(0(00))))";  // -> 3
    String s6 = "x";        // -> -1
    String s7 = "0";        // -> -1
    String s8 = "()";         // -> -1
    String s9 = "(0)";        // -> -1
    String s10 = "(00)x";      // -> -1
    String s11 = "(0p)";      // -> -1*/
    System.out.println(findDepth(s1));
    System.out.println(findDepth(s2));
    System.out.println(findDepth(s3));
    System.out.println(findDepth(s4));
    System.out.println(findDepth(s5));
    System.out.println(findDepth(s6));
    System.out.println(findDepth(s7));
    System.out.println(findDepth(s8));
    System.out.println(findDepth(s9));
    System.out.println(findDepth(s10));
    System.out.println(findDepth(s11));
  }
}
