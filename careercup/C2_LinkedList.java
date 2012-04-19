package careercup;

import java.util.HashSet;

/**
 * @author jbu
 */
class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Node");
    sb.append("{d=").append(data);
    sb.append('}');
    sb.append(next==null? "":"==>");
    return sb.toString();
  }
}

public class C2_LinkedList {
  Node head;

  public C2_LinkedList() {
  }

  public C2_LinkedList(int i) {
    head = new Node(i);
  }

  public C2_LinkedList(int[] data) {
    if (data==null || data.length==0) return;
    head = new Node(data[0]);
    Node pre = head;
    for (int i=1;i<data.length;i++) {
      pre.next = new Node(data[i]);
      pre = pre.next;
    }
  }

  public void removeDuplicate() {
    if (head==null || head.next==null) return;
    HashSet<Integer> h = new HashSet<Integer>();
    Node prev = null;
    Node cur = head;
    while (cur!=null) {
      if (h.contains(cur.data)) {
        prev.next = cur.next;
      } else {
        h.add(cur.data);
        prev = cur;
      }
      cur = cur.next;
    }
  }

  public static Node addDigits(Node n1, Node n2) {
    Node h =null, pre=null;
    int carry = 0;

    while (n1!=null)  {
       int d = n1.data + n2.data + carry;
       if (d>9) {
         d -=10;
         carry = 1;
       } else{
         carry = 0;
       }
      if (h==null) {
        h = new Node(d);
        pre = h;
      }
      else {
        pre.next = new Node(d);
        pre = pre.next;
      }
      n1 = n1.next; n2=n2.next;
    }
    if (carry==1) {
      pre.next = new Node(1);
    }
    return h;
  }

  public void print() {
    Node c = head;
    while (c!=null) {
      System.out.print(c);
      c = c.next;
    }
    System.out.println();
  }

  public static void print(Node n) {
    while (n!=null) {
      System.out.print(n);
      n = n.next;
    }
    System.out.println();
  }

  public static void main(String args[]) {
    C2_LinkedList list = new C2_LinkedList(new int[] {1, 3, 5, 2,3,6,8,6});
    list.print();
    list.removeDuplicate();
    list.print();

    C2_LinkedList l1 = new C2_LinkedList(new int[] {3, 1,5});
    C2_LinkedList l2 = new C2_LinkedList(new int[] {5, 9,2});
    Node n = addDigits(l1.head, l2.head);
    print(n);
    print(n);
    print(l1.head);
    print(l2.head);




  }

}
