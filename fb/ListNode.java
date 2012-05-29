package fb;

/**
 * @author jbu
 */
// Definition for singly-linked list.
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public static ListNode createList(int[] a) {
    ListNode head = null, pre = null;
    for (int i : a) {
      if (head == null) {
        head = new ListNode(i);
        pre = head;
      }
      else {
        pre.next = new ListNode(i);
        pre = pre.next;
      }
    }
    ListNode cur = head;
    return head;
  }

  public static void print(ListNode head) {
    ListNode cur = head;
    int i = 0;
    while (cur != null) {
      System.out.print(cur.val + " ->");
      cur = cur.next;
      i++;
      if (i % 20 == 0) System.out.println();
    }
    System.out.println();
  }
}
