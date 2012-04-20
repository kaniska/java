package fb.list;

import fb.ListNode;

/**
 * @author jbu
 */
public class RemoveNthFromEnd {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//       ListNode cur = head, nth=head;
//       for (int i=0;i<n;i++) nth=nth.next;
//       if (nth==null) return head.next;
//       ListNode pre = head;
//       while (nth!=null) {
//           pre = cur;
//           cur = cur.next;
//           nth = nth.next;
//       }
//       pre.next = cur.next;
//       return head;
//    }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode pre = head;
    int i;
    for (i = 0; i < n && pre != null; i++) pre = pre.next;
    if (i < n) return head;
    else if (pre == null) return head.next;

    ListNode cur = head;
    while (pre.next != null) {
      pre = pre.next;
      cur = cur.next;
    }

    cur.next = cur.next.next;
    return head;

  }
}
