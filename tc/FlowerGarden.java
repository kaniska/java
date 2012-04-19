package tc;

import java.util.*;

public class FlowerGarden {
  public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
    int n = height.length;
    List<Integer> order = new ArrayList<Integer>();
    int p[] = new int[n]; // position for each height;
    int h[] = new int[n];
    System.arraycopy(height, 0, h, 0, n);
    Arrays.sort(height);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (height[i] == h[j]) {
          p[i] = j;
        }
      }
    }

    order.add(0);
    for (int i = 1; i < n; i++) {
      int j;
      for (j = i - 1; j >= 0; j--) {
        int c = order.get(j);
        if (height[i] > height[c] && !(bloom[p[i]] > wilt[p[c]] || bloom[p[c]] > wilt[p[i]])) {
          order.add(j + 1, i);
          break;
        }
      }
      if (j < 0) order.add(j + 1, i);
    }
    int[] r = new int[n];
    System.out.println("Order=" + order);
    for (int i = 0; i < order.size(); i++) r[i] = height[order.get(i)];
    return r;
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
  private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, int[] p3) {
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
    System.out.print("}");
    System.out.println("]");
    FlowerGarden obj;
    int[] answer;
    obj = new FlowerGarden();
    long startTime = System.currentTimeMillis();
    answer = obj.getOrdering(p0, p1, p2);
    long endTime = System.currentTimeMillis();
    boolean res;
    res = true;
    System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
    if (hasAnswer) {
      System.out.println("Desired answer:");
      System.out.print("\t" + "{");
      for (int i = 0; p3.length > i; ++i) {
        if (i > 0) {
          System.out.print(",");
        }
        System.out.print(p3[i]);
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
      if (answer.length != p3.length) {
        res = false;
      } else {
        for (int i = 0; answer.length > i; ++i) {
          if (answer[i] != p3[i]) {
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
    int[] p2;
    int[] p3;

    // ----- test 0 -----
    p0 = new int[]{5, 4, 3, 2, 1};
    p1 = new int[]{1, 1, 1, 1, 1};
    p2 = new int[]{365, 365, 365, 365, 365};
    p3 = new int[]{1, 2, 3, 4, 5};
    all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new int[]{5, 4, 3, 2, 1};
    p1 = new int[]{1, 5, 10, 15, 20};
    p2 = new int[]{4, 9, 14, 19, 24};
    p3 = new int[]{5, 4, 3, 2, 1};
    all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new int[]{5, 4, 3, 2, 1};
    p1 = new int[]{1, 5, 10, 15, 20};
    p2 = new int[]{5, 10, 15, 20, 25};
    p3 = new int[]{1, 2, 3, 4, 5};
    all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 3 -----
    p0 = new int[]{5, 4, 3, 2, 1};
    p1 = new int[]{1, 5, 10, 15, 20};
    p2 = new int[]{5, 10, 14, 20, 25};
    p3 = new int[]{3, 4, 5, 1, 2};
    all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new int[]{1, 2, 3, 4, 5, 6};
    p1 = new int[]{1, 3, 1, 3, 1, 3};
    p2 = new int[]{2, 4, 2, 4, 2, 4};
    p3 = new int[]{2, 4, 6, 1, 3, 5};
    all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = new int[]{3, 2, 5, 4};
    p1 = new int[]{1, 2, 11, 10};
    p2 = new int[]{4, 3, 12, 13};
    p3 = new int[]{4, 5, 2, 3};
    all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
    // ------------------

    p0 = new int[]{310, 856, 224, 225, 895, 731, 68, 164, 243, 862, 492, 423, 628, 500, 883, 4, 615, 223, 627, 65, 361, 123, 884, 427, 636, 618, 812, 37, 44, 325, 555};
    p1 = new int[]{235, 73, 255, 10, 280, 9, 8, 333, 24, 74, 141, 226, 1, 89, 8, 319, 226, 139, 247, 212, 226, 356, 144, 359, 241, 77, 158, 28, 237, 362, 173};
    p2 = new int[]{331, 236, 326, 283, 342, 268, 55, 359, 214, 329, 287, 237, 172, 229, 142, 355, 304, 324, 251, 291, 247, 362, 228, 365, 365, 109, 299, 246, 341, 365, 196};
    p3 = new int[]{123, 325, 37, 68, 4, 44, 164, 427, 65, 223, 224, 225, 310, 361, 423, 243, 492, 500, 618, 628, 615, 627, 636, 555, 731, 812, 856, 862, 895, 884, 883};
    all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;


    if (all_right) {
      System.out.println("You're a stud (at least on the example cases)!");
    } else {
      System.out.println("Some of the test cases had errors.");
    }
  }
  // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!