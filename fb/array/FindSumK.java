package fb.array;

import java.util.Stack;

/**
 * @author jbu
 */
public class FindSumK {

  static class EdgeSum {
    private Stack<Integer> v = new Stack<Integer>();
    private int sum;

    public int add(int i) {
      v.push(i);
      sum = sum + i;
      return sum;
    }

    public int removeLast() {
      int a = v.pop();
      sum = sum - a;
      return sum;
    }

    public void print() {
      System.out.println(v.toString());
    }
  }

  private static void doFindSumK(int[] s, int k, int pos, int start, EdgeSum edge) {
    for (int i = start; i < s.length; i++) {
      int sum = edge.add(s[i]);
      if (sum < k) {
        doFindSumK(s, k, pos + 1, i + 1, edge);
      }
      else if (sum == k) {
        edge.print();
      }
      edge.removeLast();
    }
  }

  public static void findSumK(int[] s, int k) {
    EdgeSum edge = new EdgeSum();
    doFindSumK(s, k, 0, 0, edge);
  }
//  static char[] currentCombination=null;
//  public static char[] nextCombination(char[] s) {
//
//  }

  public static void main(String args[]) {
    findSumK(new int[]{10, 7, 5, 18, 12, 12, 15}, 35);
  }
}
