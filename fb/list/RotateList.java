package fb.list;

import fb.ListNode;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-9:59 AM
 */
public class RotateList {

  public ListNode rotateList(ListNode head, int n) {
    if (n == 0) return head;
    if (head == null || head.next == null) return head;
    // number of nodes >=2 and n>=1
    // take n mod [list]
    ListNode cur = head;
    int total = 0;
    ListNode last = null;
    while (cur != null) {
      total++;
      last = cur;
      cur = cur.next;
    }
    n = n % total;
    if (n == 0) return head;
    int i = 0;
    cur = head;
    while (++i < total - n) cur = cur.next;
    last.next = head;
    head = cur.next;
    cur.next = null;
    return head;
  }
}
