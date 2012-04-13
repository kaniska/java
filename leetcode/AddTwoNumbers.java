package leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if (l1==null) return l2;
       if (l2==null) return l1;
       ListNode pre = null;
       ListNode head = null;
       int carry = 0;
       while (l1!=null || l2!=null) {
         int val = (l1==null? 0:l1.val) +(l2==null?0:l2.val) + carry;
         ListNode n = new ListNode(val%10);
         carry = val/10;
         if (pre == null) {
             pre = n;
             head = n;
         } else {
             pre.next = n;
             pre = n;
         }
         l1= (l1==null)? null:l1.next;
         l2= (l2==null)? null:l2.next;
       }
       if (carry>0) {
           ListNode l = new ListNode(carry);
           pre.next = l;
       }
       return head;
    }
}