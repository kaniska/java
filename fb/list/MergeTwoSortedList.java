package fb.list;

import fb.ListNode;

/**
 * @author jbu
 */

public class MergeTwoSortedList {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode head = l1.val <= l2.val ? l1 : l2;
    ListNode pre = head;
    if (l1.val <= l2.val) {
      l1 = l1.next;
    } else {
      l2 = l2.next;
    }

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        pre.next = l1;
        pre = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        pre = l2;
        l2 = l2.next;
      }
    }
    if (l1 != null) pre.next = l1;
    if (l2 != null) pre.next = l2;
    return head;
  }
}