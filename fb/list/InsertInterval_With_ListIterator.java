package fb.list;

import java.util.*;

/**
 * Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p/>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p/>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p/>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p/>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p/>
 * » Solve this problem
 * <p/>
 * <p/>
 * Following http://www.mitbbs.com/article_t1/JobHunting/32079031_0_1.html , using a ListIterator, which is only around 20 lines of code
 *
 * @author: mindpower
 * @created: 4/21/12-7:58 PM
 */
public class InsertInterval_With_ListIterator {
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ListIterator<Interval> it = intervals.listIterator();
    while (it.hasNext()) {
      Interval cur = it.next();
      if (cur.end < newInterval.start) {
        continue;
      }
      if (cur.start > newInterval.end) {
        it.previous();
        it.add(newInterval);
        return intervals;
      }
      else {
        newInterval.start = Math.min(newInterval.start, cur.start);
        newInterval.end = Math.max(newInterval.end, cur.end);
        it.remove();
      }
    }
    it.add(newInterval);
    return intervals;
  }
}
