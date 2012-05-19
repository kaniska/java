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
    ListNode cur = head;
    int count = 0;
    while (cur.next != null) {
      cur = cur.next;
      count++;
    }
    count++;
    ListNode tail = cur;
    n = n % count;
    if (n == 0) return head;
    cur = head;
    for (int i = 0; i < count - n - 1; i++) {
      cur = cur.next;
    }
    tail.next = head;
    head = cur.next;
    cur.next = null;
    return head;
  }
}
