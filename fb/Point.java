package fb;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-7:58 PM
 */
class Point implements Comparable<Point> {
  int pos;
  boolean isStart;

  public Point(int pos, boolean isStart) {
    this.pos = pos;
    this.isStart = isStart;
  }

  public int compareTo(Point p) {
    if (this.pos != p.pos) return this.pos - p.pos;
    else if (this.isStart && !p.isStart) return -1;
    else if (!this.isStart && p.isStart) return 1;
    else return 0;
  }
}
