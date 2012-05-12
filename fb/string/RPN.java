package fb.string;

import java.util.Stack;

/**
 * @author jbu
 */
public class RPN {
  public static int RPN(String s) {
    String[] ops = s.split("\\s+");
    Stack<String> st = new Stack<String>();
    int i1, i2;
    for (String op : ops) {
      if (op.length() == 1) {
        char c = op.charAt(0);
        switch (c) {
          case '+':
            if (st.size() < 2) {
              throw new IllegalArgumentException("Illegal Notation");
            }
            i1 = Integer.parseInt(st.pop());
            i2 = Integer.parseInt(st.pop());
            st.push(String.valueOf(i1 + i2));
            continue;
          case '-':
            if (st.size() < 2) {
              throw new IllegalArgumentException("Illegal Notation");
            }
            i1 = Integer.parseInt(st.pop());
            i2 = Integer.parseInt(st.pop());
            st.push(String.valueOf(i2 - i1));
            continue;
          case '/':
            if (st.size() < 2) {
              throw new IllegalArgumentException("Illegal Notation");
            }
            i1 = Integer.parseInt(st.pop());
            i2 = Integer.parseInt(st.pop());
            st.push(String.valueOf(i2 / i1));
            continue;
          case '*':
            if (st.size() < 2) {
              throw new IllegalArgumentException("Illegal Notation");
            }
            i1 = Integer.parseInt(st.pop());
            i2 = Integer.parseInt(st.pop());
            st.push(String.valueOf(i1 * i2));
            continue;
          case '^':
            if (st.size() < 2) {
              throw new IllegalArgumentException("Illegal Notation");
            }
            i1 = Integer.parseInt(st.pop());
            i2 = Integer.parseInt(st.pop());
            st.push(String.valueOf((int) Math.pow(i2, i1)));
            continue;
          default:
        }
      }
      st.push(op);
    }
    if (st.size() != 1) {
      throw new IllegalArgumentException("Illegal Notation");
    }
    return Integer.parseInt(st.pop());
  }

  public static void main(String args[]) {
    System.out.println(RPN("2 1 +"));
    System.out.println(RPN("3 1 - 2 *"));
//    System.out.println(RPN("3 + 1 - 2 *"));
    System.out.println(RPN("31 28 - 21 * 77 + 66 2 * -"));
    System.out.println(RPN("8 2 ^ 2 5 * 7 * - 5 2 ^ + 122 22 - *")); //1900       19 100
  }
}
