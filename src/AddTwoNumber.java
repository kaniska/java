/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        int v1=l1.val, v2=l2.val, carry=(v1+v2)/10;
        ListNode head = new ListNode((v1+v2)%10);
        ListNode prev = head;
        l1 = l1.next;
        l2 = l2.next;
        while (l1!=null || l2!=null) {
            if (l1==null) v1=0;
            else {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2==null) v2=0;
            else {
                v2 = l2.val;
                l2 = l2.next;
            }
            
            ListNode n = new ListNode((v1+v2+carry)%10);
            carry = (v1+v2+carry)/10;
            prev.next = n;
            prev = n;
        }
        if (carry>0) prev.next = new ListNode(carry);
        return head;
    }
}