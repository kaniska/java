package fb.string;

import java.util.ArrayList;

/**
 * @author jbu
 */
public class GenerateParentheses {

  public static void main(String args[]) {
    for (int i = 2; i < 10; i++)
      new GenerateParentheses().generateParenthesis(i);
  }

  public ArrayList<String> generateParenthesis(int n) {
    ArrayList<String> result = new ArrayList<String>();
    generate(result, new char[n * 2], 0, n, 0);
    return result;
  }

  public void generate(ArrayList<String> result, char[] s, int pos, int open, int close) {
    if (open == 0 && close == 0) {
      result.add(new String(s));
      return;
    }
    if (open > 0) {
      s[pos] = '(';
      generate(result, s, pos + 1, open - 1, close + 1);
    }
    if (close > 0) {
      s[pos] = ')';
      generate(result, s, pos + 1, open, close - 1);
    }

  }
}


///////////// 04/17/2012 below uses StringBuffer to hold intermediate value 
class GenerateParentheses2 {
  public ArrayList<String> generateParenthesis2(int n) {
    ArrayList<String> result = new ArrayList<String>();
    doGenerate2(n, 0, new StringBuffer(), result);
    return result;
  }

  void doGenerate2(int open, int close, StringBuffer sb, ArrayList<String> result) {
    if (open == 0 && close == 0) result.add(sb.toString());
    if (open > 0) {
      sb.append("(");
      doGenerate2(open - 1, close + 1, sb, result);
      sb.setLength(sb.length() - 1);
    }
    if (close > 0) {
      sb.append(")");
      doGenerate2(open, close - 1, sb, result);
      sb.setLength(sb.length() - 1);
    }

  }
}