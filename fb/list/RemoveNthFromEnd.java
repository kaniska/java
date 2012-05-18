package fb.list;

import fb.ListNode;

/**
 * @author jbu
 */
public class RemoveNthFromEnd {

  // looks a little simpler
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode nPre = head;
    for (int i=1;i<n && nPre!=null;i++) nPre = nPre.next;
    if (nPre==null) return head;
    if (nPre.next==null) return head.next;
    ListNode cur = head;
    while (nPre.next.next!=null) {
      nPre = nPre.next;
      cur = cur.next;
    }
    cur.next = cur.next.next;
    return head;
  }

//  public ListNode removeNthFromEnd(ListNode head, int n) {
//    ListNode pre = head;
//    int i;
//    for (i = 0; i < n && pre != null; i++) {
//      pre = pre.next;
//    }
//    if (i < n) {
//      return head;
//    }
//    else if (pre == null) {
//      return head.next;
//    }
//    ListNode cur = head;
//    while (pre.next != null) {
//      pre = pre.next;
//      cur = cur.next;
//    }
//    cur.next = cur.next.next;
//    return head;
//  }
}
