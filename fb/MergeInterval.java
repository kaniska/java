package fb;

import java.util.*;

/**
 * Definition for an interval.
 */
class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}

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


public class MergeInterval {
  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    Point[] points = new Point[intervals.size() * 2];
    int k = 0;
    for (int i = 0; i < intervals.size(); i++) {
      points[k++] = new Point(intervals.get(i).start, true);
      points[k++] = new Point(intervals.get(i).end, false);
    }
    Arrays.sort(points);
    ArrayList<Interval> result = new ArrayList<Interval>();
    Deque<Point> d = new ArrayDeque<Point>();
    for (int i = 0; i < points.length; i++) {
      if (points[i].isStart) {
        d.push(points[i]);
      } else {
        Point p = d.pop();
        if (d.isEmpty()) {
          result.add(new Interval(p.pos, points[i].pos));
        }
      }
    }
    return result;
  }
}