package fb.math;

import fb.ListNode;

public class AddTwoNumbers {

  public ListNode addTwoNumbers0418(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    int v1 = l1.val, v2 = l2.val, carry = (v1 + v2) / 10;
    ListNode head = new ListNode((v1 + v2) % 10);
    ListNode prev = head;
    l1 = l1.next;
    l2 = l2.next;
    while (l1 != null || l2 != null) {
      if (l1 == null) v1 = 0;
      else {
        v1 = l1.val;
        l1 = l1.next;
      }
      if (l2 == null) v2 = 0;
      else {
        v2 = l2.val;
        l2 = l2.next;
      }

      ListNode n = new ListNode((v1 + v2 + carry) % 10);
      carry = (v1 + v2 + carry) / 10;
      prev.next = n;
      prev = n;
    }
    if (carry > 0) prev.next = new ListNode(carry);
    return head;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode pre = null;
    ListNode head = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
      ListNode n = new ListNode(val % 10);
      carry = val / 10;
      if (pre == null) {
        pre = n;
        head = n;
      } else {
        pre.next = n;
        pre = n;
      }
      l1 = (l1 == null) ? null : l1.next;
      l2 = (l2 == null) ? null : l2.next;
    }
    if (carry > 0) {
      ListNode l = new ListNode(carry);
      pre.next = l;
    }
    return head;
  }
}