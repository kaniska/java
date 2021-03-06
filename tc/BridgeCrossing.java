package tc;

import java.util.*;

import static java.lang.Math.*;

/**
 * 1. From LinkedList<Integer>, removing(int) is removing Item at Index int, not removing item int;
 * 2. Remove (0), then remove (1) is DIFFERENT from Remove (1), then remove (0);
 */
public class BridgeCrossing {
  int minTime = 100000;

  void move(List<Integer> left, List<Integer> right, int x, int y, int currentTime) {
    currentTime += max(left.get(x), left.get(y));
    if (left.size() == 2) {
      if (currentTime < minTime) {
        minTime = currentTime;
        System.out.println("New minTime=" + minTime);
      }
      return;
    }

    List<Integer> cleft = new ArrayList<Integer>();
    List<Integer> cright = new ArrayList<Integer>();
    for (int i : left) cleft.add(i);
    for (int i : right) cright.add(i);
    Integer r2 = cleft.remove(y);
    Integer r1 = cleft.remove(x);
    cright.add(r1);
    cright.add(r2);

    Collections.sort(cright);
    Integer min = cright.get(0);
    cright.remove(0);
    cleft.add(min);
    currentTime += min;
    if (currentTime >= minTime) return;
    for (int i = 0; i < cleft.size(); i++) {
      for (int j = i + 1; j < cleft.size(); j++) {
        move(cleft, cright, i, j, currentTime);
      }
    }
  }

  public int minTime(int[] times) {
    int n = times.length;
    if (n == 1) {
      return times[0];
    }
    if (n == 2) {
      return times[0] > times[1] ? times[0] : times[1];
    }
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    for (int i : times) {
      left.add(i);
    }

    int currentTime = 0;
    for (int i = 0; i < left.size(); i++) {
      for (int j = i + 1; j < left.size(); j++) {
        move(left, right, i, j, currentTime);
      }
    }

    return minTime;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}");
    System.out.println("]");
    BridgeCrossing obj;
    int answer;
    obj = new BridgeCrossing();
    long startTime = System.currentTimeMillis();
    answer = obj.minTime(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p1);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p1;
    }
    if (!res) {
      System.out.println("DOESN'T MATCH!!!!");
    } else if ((endTime - startTime) / 1000.0 >= 2) {
      System.out.println("FAIL the timeout");
      res = false;
    } else if (hasAnswer) {
      System.out.println("Match :-)");
    } else {
      System.out.println("OK, but is it right?");
    }
    System.out.println("");
    return res;
  }

  public static void main(String[] args) {
    boolean all_right;
    all_right = true;

    int[] p0;
    int p1;

    // ----- test 0 -----
    p0 = new int[]{1, 2, 5, 10};
    p1 = 17;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[]{1, 2, 3, 4, 5};
    p1 = 16;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[]{100};
    p1 = 100;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[]{1, 2, 3, 50, 99, 100};
    p1 = 162;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    if (all_right) {
      System.out.println("You're a stud (at least on the example cases)!");
    } else {
      System.out.println("Some of the test cases had errors.");
    }
  }
  // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
