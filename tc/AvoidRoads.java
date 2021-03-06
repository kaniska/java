package tc;

import java.util.*;

public class AvoidRoads {
  boolean isBadRow(HashSet<String> b, int i, int j) {
    String path1a = (i - 1) + " " + j + " " + i + " " + j;
    String path1b = (i) + " " + j + " " + (i - 1) + " " + j;
    return b.contains(path1a) || b.contains(path1b);
  }

  boolean isBadCol(HashSet<String> b, int i, int j) {
    String path2a = (i) + " " + (j - 1) + " " + i + " " + j;
    String path2b = (i) + " " + (j) + " " + i + " " + (j - 1);
    return b.contains(path2a) || b.contains(path2b);
  }

  public long numWays(int width, int height, String[] bad) {
    HashSet<String> b = new HashSet<String>();
    for (String s : bad) b.add(s);

    long total[][] = new long[width + 1][height + 1];
    for (int i = 0; i <= width; i++) {
      for (int j = 0; j <= height; j++) {
        if (i == 0 && j == 0) total[i][j] = 1;
        else if (i == 0)
          total[i][j] = isBadCol(b, i, j) ? 0 : total[i][j - 1];
        else if (j == 0)
          total[i][j] = isBadRow(b, i, j) ? 0 : total[i - 1][j];
        else
          total[i][j] = (isBadRow(b, i, j) ? 0 : total[i - 1][j]) + (isBadCol(b, i, j) ? 0 : total[i][j - 1]);
      }
    }
    System.out.println("power of 2 N=" + Math.log(total[width][height]) / Math.log(2));
    return total[width][height];
  }


  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, String[] p2, boolean hasAnswer, long p3) {
    System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
    for (int i = 0; p2.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p2[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    AvoidRoads obj;
    long answer;
    obj = new AvoidRoads();
    long startTime = System.currentTimeMillis();
    answer = obj.numWays(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.println("\t" + p3);
    }
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    if (hasAnswer) {
      res = answer == (p3);
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

    int p0;
    int p1;
    String[] p2;
    long p3;

    // ----- test 0 -----
    p0 = 6;
    p1 = 6;
    p2 = new String[]{"0 0 0 1", "6 6 5 6"};
    p3 = 252L;
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = 1;
    p1 = 1;
    p2 = new String[]{};
    p3 = 2L;
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = 35;
    p1 = 31;
    p2 = new String[]{};
    p3 = 6406484391866534976L;
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = 2;
    p1 = 2;
    p2 = new String[]{"0 0 1 0", "1 2 2 2", "1 1 2 1"};
    p3 = 0L;
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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
