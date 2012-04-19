package topcoder;

import java.util.*;

import static java.util.Arrays.*;

/**
 * Problem Statement
 * ����
 * Johnny has to walk home from school, and wants to map out the best route to take, so that he has to cross as few streets as possible.
 * You are given a String[] map that maps the roadway layout of Johnny's town. The location of Johnny's school is designated with a 'S' character, and the location of Johnny's home is designated with a 'H' character. North-South roads are denoted by a '|' character, while East-West roads are denoted by a '-' character. Intersections, which can never be crossed, are indicated by '*' characters. Fences, indicated by a 'F' character, can also never be crossed. All other areas are indicated by '.' characters; Johnny can walk freely over these areas.
 * For maximum safety, Johnny may only walk directly across a road, perpendicular to the traffic, never diagonally. All of Johnny's movements, onto and off of a road, and walking around town, should be in one of the four cardinal directions. Johnny may, however, cross roads that are multiple lanes wide, and doing so only counts as a single crossing. Two or more adjacent || characters are always considered to be a single road, and this works similarly for '-' characters that appear adjacent vertically.
 * For instance, the following requires only a single crossing, since it's a single two-lane road:
 * S.||.H
 * Also, a situation such as the following leaves Johnny with no safe way to walk home, since he cannot cross the road diagonally, and can only step onto and off a road in a direction perpendicular to the road:
 * S||
 * ||H
 * Also notice that because Johnny can never move diagonally, in the following case, Johnny cannot get home:
 * S.F
 * .F.
 * F.H
 * You are to return an int indicating the fewest number of times Johnny must cross the street on his way home. If there is no safe way for Johnny to get home, return -1.
 * Definition
 * ����
 * Class:
 * WalkingHome
 * Method:
 * fewestCrossings
 * Parameters:
 * String[]
 * Returns:
 * int
 * Method signature:
 * int fewestCrossings(String[] map)
 * (be sure your method is public)
 * ����
 * <p/>
 * Notes
 * -
 * If a street is more than one unit wide, it still only counts as a single crossing.
 * Constraints
 * -
 * map will contain between 1 and 50 elements, inclusive.
 * -
 * Each element of map will contain between 1 and 50 characters, inclusive.
 * -
 * Each element of map will contain only the characters '.', '-', '|', '*', 'F', 'S', 'H'.
 * -
 * There will be exactly one occurrence each of 'S' and 'H' in map.
 * -
 * Each element of map will contain the same number of characters.
 * Examples
 * 0)
 * <p/>
 * ����
 * {"S.|..",
 * "..|.H"}
 * Returns: 1
 * Here, Johnny lives right across the street from the school, so inevitably, he's crossing the street once to get home.
 * 1)
 * <p/>
 * ����
 * {"S.|..",
 * "..|.H",
 * "..|..",
 * "....."}
 * Returns: 0
 * Similar to above, but since the road has a dead end (maybe even a cul-de-sac at the end), Johnny can get home without actually having to cross the road.
 * 2)
 * <p/>
 * ����
 * {"S.||...",
 * "..||...",
 * "..||...",
 * "..||..H"}
 * Returns: 1
 * Notice here that even though it's a 2-lane highway, it only counts as a single crossing.
 * 3)
 * <p/>
 * ����
 * {"S.....",
 * "---*--",
 * "...|..",
 * "...|.H"}
 * Returns: 1
 * Here, Johnny could go down across the street and then right across another street to his house. However, if he first goes to the right before crossing down, he will only cross 1 street.
 * 4)
 * <p/>
 * ����
 * {"S.F..",
 * "..F..",
 * "--*--",
 * "..|..",
 * "..|.H"}
 * Returns: 2
 * Similar to above, but because there's a fence around the school, Johnny has no choice but to cross twice.
 * 5)
 * <p/>
 * ����
 * {"H|.|.|.|.|.|.|.|.|.|.|.|.|.",
 * "F|F|F|F|F|F|F|F|F|F|F|F|F|-",
 * "S|.|.|.|.|.|.|.|.|.|.|.|.|."}
 * Returns: 27
 * Poor Johnny lives so close to school, but that fence makes him cross the street quite a bit just to get home.
 * 6)
 * <p/>
 * ����
 * {"S-H"}
 * Returns: -1
 * <p/>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */

public class WalkingHome {

  class Point implements Comparable {
    int x, y;
    int steps = -1;

    Point(int x, int y, int steps) {
      this.x = x;
      this.y = y;
      this.steps = steps;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("(").append(x);
      sb.append(",").append(y);
      sb.append(") steps=").append(steps);
      return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Point point = (Point) o;

      if (x != point.x) {
        return false;
      }
      if (y != point.y) {
        return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }

    public int compareTo(Object o) {
      Point n = (Point) o;
      if (steps < n.steps) {
        return -1;
      } else if (steps == n.steps) {
        return 0;
      } else {
        return 1;
      }
    }
  }

  int width, height;

  public int fewestCrossings1(String[] map) {
    height = map.length;
    width = map[0].length();
    int[] s = getStart(map);
    System.out.println("width=" + width + ";height=" + height + "Started=" + s[0] + ";" + s[1]);
    PriorityQueue<Point> queue = new PriorityQueue<Point>();
    HashSet<Point> visited = new HashSet<Point>();

    queue.offer(new Point(s[0], s[1], 0));
    visited.add(new Point(s[0], s[1], 0));
    while (!queue.isEmpty()) {
      Point p = queue.poll();
      System.out.println("P=" + p);
      List<Point> nextMoves = getNextMoves(map, p);
      for (Point m : nextMoves) {
        if (queue.contains(m) || visited.contains(m)) {   // already in queue or visited
          continue;
        }
        char cur = getChar(map, m), prev = getChar(map, p);
        if ((cur == '.' && (prev == '.' || prev == 'S'))
          || (cur == '|' && (prev == '|' || prev == 'S' || prev == '.'))
          || (cur == '-' && (prev == '-' || prev == 'S' || prev == '.'))) { // free move
          queue.add(m);
          visited.add(m);
        } else if ((cur == '.' && prev == '|') || (cur == '.' && prev == '-')) { // crossed road
          m.steps++;
          queue.add(m);
          visited.add(m);
        } else if (cur == 'H') {  // end met
          return (prev == '|' || prev == '-') ? m.steps + 1 : m.steps;
        } else {
          visited.add(m);
        }
      }
    }
    return -1;
  }

  private char getChar(String[] m, Point p) {
    return m[p.y].charAt(p.x);
  }

  int[] X = new int[]{1, -1, 0, 0};
  int[] Y = new int[]{0, 0, -1, 1};
  String[] valids = new String[]{"|SH.", "|SH.", "-SH.", "-SH."};

  boolean isValid(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  private List<Point> getNextMoves(String[] m, Point p) {
    List<Point> next = new LinkedList<Point>();
    for (int i = 0; i < 4; i++) {
      if (isValid(p.x + X[i], p.y + Y[i]) && valids[i].indexOf((getChar(m, p))) >= 0) {
        next.add(new Point(p.x + X[i], p.y + Y[i], p.steps));
      }
    }
    return next;
  }

  private int[] getStart(String[] map) {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (map[y].charAt(x) == 'S') {
          return new int[]{x, y};
        }
      }
    }
    return new int[]{-1, -1};
  }

  ///////////////////////////////////////////////////////////////

  int B[][], w, h;

  int pos(int x, int y) {
    return x + y * w;
  }

  int pos(String[] map, char c) {
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (map[y].charAt(x) == c) {
          return pos(x, y);
        }
      }
    }
    return -1;
  }

  public int fewestCrossings2(String[] map) {
    w = map[0].length();
    h = map.length;
    int t = w * h;
    B = new int[t][t];
    for (int[] b : B) {
      fill(b, 10000);
    }

    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        for (int d = 0; d < 4; d++) {
          int x = i + X[d];
          int y = j + Y[d];
          if (x < 0 || y < 0 || x > w - 1 || y > h - 1 || valids[d].indexOf(map[y].charAt(x)) < 0) {
            continue;
          }
          if (".SH".indexOf(map[y].charAt(x)) >= 0) {
            B[pos(i, j)][pos(x, y)] = 0;
          } else {
            char c = map[y].charAt(x);
            do {
              x = x + X[d];
              y = y + Y[d];
            } while (x >= 0 && y >= 0 && x < w && y < h && map[y].charAt(x) == c);
            if (x < 0 || y < 0 || x > w - 1 || y > h - 1 || ".SH".indexOf(map[y].charAt(x)) < 0) {
              continue;
            }
            B[pos(i, j)][pos(x, y)] = 1;
          }
        }
      }
    }

    for (int k = 0; k < t; k++) {
      for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
          B[i][j] = Math.min(B[i][j], B[i][k] + B[k][j]);
        }
      }
    }
    int s = pos(map, 'S');
    int h = pos(map, 'H');

    return B[s][h]==10000? -1: B[s][h];
  }

  public int fewestCrossings(String[] map) {
    return fewestCrossings2(map);
  }

  // BEGIN KAWIGIEDIT TESTING
  // Generated by KawigiEdit 2.1.4 (beta) modified by pivanof

  private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
    System.out.print("Test " + testNum + ": [" + "{");
    for (int i = 0; p0.length > i; ++i) {
      if (i > 0) {
        System.out.print(",");
      }
      System.out.print("\"" + p0[i] + "\"");
    }
    System.out.print("}");
    System.out.println("]");
    WalkingHome obj;
    int answer;
    obj = new WalkingHome();
    long startTime = System.currentTimeMillis();
    answer = obj.fewestCrossings(p0);
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

    String[] p0;
    int p1;

    // ----- test 0 -----
    p0 = new String[]{"S.|..", "..|.H"};
    p1 = 1;
    all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
    // ------------------

    // ----- test 1 -----
    p0 = new String[]{"S.|..", "..|.H", "..|..", "....."};
    p1 = 0;
    all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
    // ------------------

    // ----- test 2 -----
    p0 = new String[]{"S.||...", "..||...", "..||...", "..||..H"};
    p1 = 1;
    all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
    // ------------------   */

    // ----- test 3 -----
    p0 = new String[]{"S.....", "---*--", "...|..", "...|.H"};
    p1 = 1;
    all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
    // ------------------

    // ----- test 4 -----
    p0 = new String[]{"S.F..", "..F..", "--*--", "..|..", "..|.H"};
    p1 = 2;
    all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
    // ------------------

    // ----- test 5 -----
    p0 = new String[]{"H|.|.|.|.|.|.|.|.|.|.|.|.|.", "F|F|F|F|F|F|F|F|F|F|F|F|F|-", "S|.|.|.|.|.|.|.|.|.|.|.|.|."};
    p1 = 27;
    all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
    // ------------------

    // ----- test 6 -----
    p0 = new String[]{"S-H"};
    p1 = -1;
    all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
    // ------------------  */

    if (all_right) {
      System.out.println("You're a stud (at least on the example cases)!");
    } else {
      System.out.println("Some of the test cases had errors.");
    }
  }
  // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
