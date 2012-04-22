package fb;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-7:57 PM
 */
public class InsertInterval {
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    intervals.add(newInterval);
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