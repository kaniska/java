package tc;

import java.util.*;

public class Crossroads {
  public int[] getOut(int[] angles) {
    ArrayList<Integer> out = new ArrayList<Integer>();
    int len = angles.length;
    boolean lose[] = new boolean[len];

    for (int i = 0; i < len; i++) {
      if (lose[i]) continue;
      for (int j = i + 1; j < len; j++) {
        if (angles[i] >= angles[j]) continue;
        if (angles[j] <= 90 || (angles[j] > 90 && (180 - angles[j] > angles[i]))) {
          lose[i] = true;
        } else {
          lose[j] = true;
        }
      }
    }
    for (int i = 0; i < len; i++)
      if (!lose[i]) out.add(i);

    int[] o = new int[out.size()];
    for (int i = 0; i < out.size(); i++) o[i] = out.get(i);
    return o;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int[] p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}");
    System.out.println("]");
    Crossroads obj;
    int[] answer;
    obj = new Crossroads();
    long startTime = System.currentTimeMillis();
    answer = obj.getOut(p0);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p1.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p1[i]);
      }
      System.out.println("}");
    }
    System.out.println("Your answer:");
    System.out.print("\t" + "{");
    for (int i = 0; answer.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(answer[i]);
    }
    System.out.println("}");
    if (hasAnswer) {
      if (answer.length != p1.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p1[i]) {
            res = false;
          }
        }
      }
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
    int[] p1;

    // ----- test 0 -----
    p0 = new int[]{105, 75, 25, 120, 35, 75};
    p1 = new int[]{0, 1, 5};
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[]{1, 1, 1, 1, 1, 1};
    p1 = new int[]{0, 1, 2, 3, 4, 5};
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[]{13};
    p1 = new int[]{0};
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[]{90, 123, 1, 23, 132, 11, 28, 179, 179, 77, 113, 91};
    p1 = new int[]{0};
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new int[]{179, 89, 90, 91, 1};
    p1 = new int[]{0, 2, 4};
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = new int[]{89, 91};
    p1 = new int[]{0};
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = new int[]{140, 118, 54, 166, 151, 44, 90, 5, 14, 6, 64, 129, 74, 33, 134, 25, 11, 95, 65, 145, 29, 162, 24, 147, 45, 103, 63, 97, 120, 156, 167, 170, 19, 28, 100, 144, 161, 13, 157, 148};
    p1 = new int[]{0, 1, 6};
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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
