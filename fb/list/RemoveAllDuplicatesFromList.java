package fb.list;

import fb.ListNode;

/**
 * Check both pre node and next node,
 * If only check pre, it won't work
 *
 * @author: mindpower
 * @since: 5/19/12-8:51 AM
 */
public class RemoveAllDuplicatesFromList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head, pre = null, distinct = null, distinctTail = null;
    while (cur != null) {
      if ((pre != null && pre.val == cur.val) ||
          (cur.next != null && cur.val == cur.next.val))
      {
        pre = cur;
        cur = cur.next;
      }
      else {// distinct found
        if (distinct == null) {
          distinct = cur;
        }
        else {
          distinctTail.next = cur;
        }
        distinctTail = cur;
        pre = null;
        cur = cur.next;
        distinctTail.next = null;
      }
    }
    return distinct;
  }
}
