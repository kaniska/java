package fb.list;

import fb.ListNode;

/**
 * Remove Duplicates from Sorted List
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 * @author: mindpower
 * @since: 5/13/12-6:14 PM
 */
public class RemoveDuplicatesFromList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head==null || head.next==null) return head;
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur!=null) {
      if (cur.val==pre.val) {
        pre.next = cur.next;
        cur = cur.next;
      } else {
        pre = cur;
        cur = cur.next;
      }
    }
    return head;
  }
}
