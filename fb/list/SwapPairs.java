package fb.list;

import fb.ListNode;

/**
 * @author jbu
 */
public class SwapPairs {
  public ListNode swapPairs(ListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head == null || head.next == null) {
      return head;
    }
    ListNode remaining = head.next.next;
    head.next.next = head;
    ListNode result = head.next;
    head.next = swapPairs(remaining);
    return result;
  }
//      public ListNode swapPairs(ListNode head) {
//       if (head==null || head.next==null) return head;
//       ListNode cur = head;
//       head = head.next;
//       cur.next = swapPairs(head.next);
//       head.next = cur;
//       return head;
//    }

  public ListNode swapPairsIterative(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    head = head.next;
    while (cur != null) {
      if (cur.next == null) {
        if (prev != null) {
          prev.next = cur;
        }
        return head;
      }
      if (prev != null) {
        prev.next = cur.next;
      }
      ListNode t = cur.next.next;
      cur.next.next = cur;
      prev = cur;
      cur = t;
    }
    prev.next = null;
    return head;
  }
}
