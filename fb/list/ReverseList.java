package fb.list;

import fb.ListNode;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/22/12-9:13 AM
 */
public class ReverseList {
  public ListNode reverse(ListNode h) {
    ListNode prev = null;
    while (h != null) {
      ListNode next = h.next;
      h.next = prev;
      prev = h;
      if (next == null) {
        return h;
      }
      h = next;
    }
    return h;
  }
}
