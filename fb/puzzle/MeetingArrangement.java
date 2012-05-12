package fb.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author jbu
 */
public class MeetingArrangement {
  static class Segment {
    int start, end;

    Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("[");
      sb.append(start);
      sb.append(", ").append(end);
      sb.append(']');
      return sb.toString();
    }
  }

  static class Point {
    int pos;
    boolean isStart = false;
    Segment s;

    Point(int pos, boolean start, Segment s) {
      this.pos = pos;
      isStart = start;
      this.s = s;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("Point");
      sb.append("{pos=").append(pos);
      sb.append(", isStart=").append(isStart);
      sb.append('}');
      return sb.toString();
    }
  }

  static class PointComparator implements Comparator<Point> {
    public int compare(Point o1, Point o2) {
      if (o1.pos < o2.pos) {
        return -1;
      }
      if (o1.pos == o2.pos) {
        if (o1.isStart && !o2.isStart) {
          return -1;
        }
        if (!o1.isStart && o2.isStart) {
          return 1;
        }
        return 0;
      }
      if (o1.pos > o2.pos) {
        return 1;
      }
      return 0;
    }
  }

  public static List<Integer> getEventDays(List<Segment> list) {
    List<Point> plist = new ArrayList<Point>();
    for (Segment s : list) {
      Point ps = new Point(s.start, true, s);
      Point pe = new Point(s.end, false, s);
      plist.add(ps);
      plist.add(pe);
    }
    Collections.sort(plist, new PointComparator());
    System.out.println(plist);
    Set<Segment> noneSet = new HashSet<Segment>();
    Set<Segment> oneSet = new HashSet<Segment>();
    List<Integer> result = new ArrayList<Integer>();
    for (Point p : plist) {
      if (p.isStart) {
        noneSet.add(p.s);
      }
      else {
        if (oneSet.contains(p.s)) {
          result.add(p.pos);
          oneSet.clear();
          oneSet.addAll(noneSet);
          noneSet.clear();
        }
        else if (noneSet.contains(p.s)) {
          result.add(p.pos);
          result.add(p.pos - 1);
          for (Segment s : noneSet) {
            if (s.start == p.pos) {
              oneSet.add(s);
            }
          }
          noneSet.clear();
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {
    List<Segment> list = new ArrayList<Segment>();
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      int x = 1 + r.nextInt(31);
      int d = 1 + r.nextInt(10);
      if (x + d > 31) {
        continue;
      }
      list.add(new Segment(x, x + d));
    }
    System.out.println(list);
    System.out.println(getEventDays(list));
  }
}
