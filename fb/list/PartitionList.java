package fb.list;

import fb.ListNode;

import java.util.Random;

/**
 * @author: mindpower
 * @since: 5/18/12-9:16 PM
 */
public class PartitionList {

  public static void main(String[] args) {
//    int[] a = new int[]{8, 10, 1, 4, 3, 2, 5, 2};
    int[] a = new int[1000];
    int max = 100000;//Integer.MAX_VALUE;
    int n = max / 2;
    Random r = new Random();
    for (int i = 0; i < a.length; i++) a[i] = r.nextInt(max);
    ListNode head = ListNode.createList(a);
    ListNode.print(head);
    head = new PartitionList().partition(head, n);
    ListNode.print(head);
  }

  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) return head;
    ListNode pre = null;
    ListNode largerList = null;
    ListNode largerTail = null;
    ListNode cur = head;
    // skip all larger val and move into larger list
    while (cur != null && cur.val >= x) {
      if (largerList == null) largerList = cur;
      largerTail = cur;
      cur = cur.next;
    }
    head = cur;
    if (cur == null) return largerList;
    while (cur != null) {
      if (cur.val < x) {
        pre = cur;
        cur = cur.next;
      }
      else {
        if (largerList == null) {
          largerList = cur;
          largerTail = cur;
        }
        else {
          largerTail.next = cur;
          largerTail = cur;
        }
        pre.next = cur.next;
        cur = cur.next;
        largerTail.next = null;
      }
    }
    pre.next = largerList;
    return head;
  }
}
