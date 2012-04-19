package facebook;

import java.util.Stack;

/**
 * @author jbu
 * http://www.mitbbs.com/article_t/JobHunting/31970619.html
 */
public class BalancedParentheses {
  public static void main(String args[]) {
    balance("(ab(xy)u)2)");
    balance(")))(((");
//    assert(balance("(ab(xy)u)2)").equals("(ab(xy)u)2")): "Not equal";
//    assert(balance(")))(((").equals("")): "Not equal";
  }

  public static String balance(String s) {
    StringBuilder sb = new StringBuilder();
    boolean valid[]= new boolean[s.length()];
    char[] str = s.toCharArray();
    Stack<Integer> st = new Stack<Integer>();
    for (int i=0;i<str.length;i++) {
      if (str[i]=='(') {
        st.push(i);
      } else if (str[i]==')') {
        if (!st.isEmpty() && str[st.peek()]=='(') {
          valid[st.pop()]=true;
          valid[i]=true;
        }
      }
    }
    for (int i=0;i<str.length;i++) {
      if ( (str[i]!='(' && str[i]!=')')|| valid[i] ) sb.append(str[i]);
    }
    System.out.println(s+" -->"+sb.toString());
    return sb.toString();
  }

}
