package lc;

import fb.ListNode;

/**
 * @author jbu
 */
public class ReverseKGroup {
  /**
   * this kind of problem is more suited for a recursive solution and avoid a lot of check
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup_recursive(ListNode head, int k) {
    ListNode cur = head, nodeK = head;
    int i = 0;
    while (nodeK != null && ++i < k) {
      nodeK = nodeK.next;
    }
    if (nodeK == null) {
      return head;
    }
    ListNode prev = reverseKGroup(nodeK.next, k);
    head = nodeK;
    i = 0;
    while (i++ < k) {
      ListNode t = cur.next;
      cur.next = prev;
      prev = cur;
      cur = t;
    }
    return head;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode cur = head;
    ListNode nodeK = cur;
    ListNode prev = null;
    ListNode last = null;
    int i = 0;
    boolean first = true;
    do {
      i = 0;
      while (nodeK != null && ++i < k) {
        nodeK = nodeK.next;
      }
      if (i < k) {
        break;
      }
      i = 0;
      if (first) {
        head = nodeK;
        first = false;
      }
      prev = nodeK.next;
      nodeK = prev;
      ListNode f = cur;
      while (++i < k) {
        ListNode t = cur.next;
        cur.next = prev;
        prev = cur;
        cur = t;
      }
      if (last != null) {
        last.next = cur;
      }
      cur.next = prev;
      last = f;
      cur = nodeK;

    } while (true);

    return head;
  }

}
