package leetcode;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 6:56 PM
 */
public class MergeKSortedList {
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    ListNode head = null, pre = null;

    while (true) {
      int k = -1;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < lists.size(); i++) {
        if (lists.get(i) == null) continue;
        if (lists.get(i).val <= min) {
          min = lists.get(i).val;
          k = i;
        }

      }
      if (k == -1) break;
      if (head == null) { // head = null as well
        head = lists.get(k);
        pre = head;
        lists.set(k, lists.get(k).next);
      } else {
        pre.next = lists.get(k);
        pre = pre.next;
        lists.set(k, lists.get(k).next);
      }
    }
    return head;

  }
}
