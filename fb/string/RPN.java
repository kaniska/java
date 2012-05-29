package fb.string;

import java.util.*;

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

  public static Double RPN2(String s) {
    String[] ops = s.split("\\s+");
    Deque<Double> d = new ArrayDeque<Double>();
    for (String op : ops) {
      if (op.length() == 1) {
        char c = op.charAt(0);
        Operation o = OperationFactory.getOperation(c);
        if (o != null) {
          if (d.size() < 2) throw new IllegalArgumentException("Illegal Input");
          double d2 = d.pop();
          double d1 = d.pop();
          d.push(o.calculate(d1, d2));
          continue;
        }
      }
      d.push(Double.parseDouble(op));
    }
    if (d.size() != 1) throw new IllegalArgumentException("Illegal Input");
    return d.getFirst();
  }

  static class OperationFactory {
    static Map<Character, Operation> operations = new HashMap<Character, Operation>();

    public static Operation getOperation(char c) {
      if (operations.get(c) == null) {
        Operation o = null;
        switch (c) {
          case '+':
            o = new AddOperation();
            break;
          case '-':
            o = new MinusOperation();
            break;
          case '*':
            o = new MultiplyOperation();
            break;
          case '/':
            o = new DivideOperation();
            break;
          case '^':
            o = new PowOperation();
            break;
        }
        if (o == null) return null;
        operations.put(c, o);
        return o;
      }
      else {
        return operations.get(c);
      }
    }
  }

  static interface Operation {
    public abstract Double calculate(Double t1, Double t2);
  }

  static class AddOperation implements Operation {
    public Double calculate(Double t1, Double t2) {
      return t1 + t2;
    }
  }

  static class MinusOperation implements Operation {
    public Double calculate(Double t1, Double t2) {
      return t1 - t2;
    }
  }

  static class MultiplyOperation implements Operation {
    public Double calculate(Double t1, Double t2) {
      return t1 * t2;
    }
  }

  static class DivideOperation implements Operation {
    public Double calculate(Double t1, Double t2) {
      return t1 / t2;
    }
  }

  static class PowOperation implements Operation {
    public Double calculate(Double t1, Double t2) {
      return Math.pow(t1, t2);
    }
  }

  public static void main(String args[]) {
    System.out.println(RPN("2 1 +"));
    System.out.println(RPN("3 1 - 2 *"));
//    System.out.println(RPN("3 + 1 - 2 *"));
    System.out.println(RPN("31 28 - 21 * 77 + 66 2 * -"));
    System.out.println(RPN("8 2 ^ 2 5 * 7 * - 5 2 ^ + 122 22 - *")); //1900       19 100
    System.out.println(RPN2("2 1 +"));
    System.out.println(RPN2("3 1 - 2 *"));
//    System.out.println(RPN("3 + 1 - 2 *"));
    System.out.println(RPN2("31 28 - 21 * 77 + 66 2 * -"));
    System.out.println(RPN2("8 2 ^ 2 5 * 7 * - 5 2 ^ + 122 22 - *")); //1900       19 100
  }
}
