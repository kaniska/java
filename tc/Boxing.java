package tc;

import java.util.*;

public class Boxing {
  public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
    int p[][] = {a, b, c, d, e};
    int min = -1;
    int iMin = -1;
    int i[] = new int[5];
    for (int x = 0; x < p.length; x++) {
      i[x] = p[x].length > 0 ? 0 : 100;
    }
    int credit = 0;
    int last = -1;
    while (true) {
      min = 1800000;
      iMin = -1;
      for (int x = 0; x < p.length; x++) {
        if (i[x] < p[x].length && p[x][i[x]] < min) {
          min = p[x][i[x]];
          iMin = x;
        }
      }
      if (min == 1800000) break;
      int count = 0;
      int n = 0;
      int mm[] = new int[5];
      for (int x = 0; x < p.length; x++) {
        if (i[x] < p[x].length && p[x][i[x]] <= min + 1000) {
          count++;
          mm[n++] = p[x][i[x]];
        }
      }
      if (count >= 3) {
        credit++;
        Arrays.sort(mm, 0, n - 1);
        last = mm[2];
        for (int x = 0; x < p.length; x++) {
          while (i[x] < p[x].length && p[x][i[x]] <= last) i[x]++;
        }
      } else {
        i[iMin]++;
      }

    }
    return credit;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, int[] p3, int[] p4, boolean hasAnswer, int p5) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p0[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p1.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p1[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p2.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p2[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p3.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p3[i]);
    }
    System.out.print("}" + "," + "{");
    for (int i = 0; p4.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print(p4[i]);
    }
    System.out.print("}");
    System.out.println("]");
    Boxing obj;
    int answer;
    obj = new Boxing();
    long startTime = System.currentTimeMillis();
    answer = obj.maxCredit(p0, p1, p2, p3, p4);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p5);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == p5;
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
    int[] p2;
    int[] p3;
    int[] p4;
    int p5;

    // ----- test 0 -----
    p0 = new int[]{1, 2, 3, 4, 5, 6};
    p1 = new int[]{1, 2, 3, 4, 5, 6, 7};
    p2 = new int[]{1, 2, 3, 4, 5, 6};
    p3 = new int[]{0, 1, 2};
    p4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    p5 = 6;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, true, p5) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[]{100, 200, 300, 1200, 6000};
    p1 = new int[]{};
    p2 = new int[]{900, 902, 1200, 4000, 5000, 6001};
    p3 = new int[]{0, 2000, 6002};
    p4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    p5 = 3;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, true, p5) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[]{5000, 6500};
    p1 = new int[]{6000};
    p2 = new int[]{6500};
    p3 = new int[]{6000};
    p4 = new int[]{0, 5800, 6000};
    p5 = 1;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, true, p5) && all_right;
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