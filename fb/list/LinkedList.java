package fb.list;

/**
 * @author jbu
 */
class Node<T> {
  T t;
  Node<T> next;
}

public class LinkedList<T> {
  Node<T> head = null;

  public void add(T t) {
    Node<T> n = new Node<T>();
    n.t = t;
    n.next = head;
    head = n;
  }

  public  void print() {
    Node<T> n = head;
    while (n!=null) {
      System.out.print(n.t+"->");
      n=n.next;
    }
    System.out.println(" ///");
  }

  public void reverse() {
    if (head == null || head.next == null) return;
    Node<T> pre = null;
    Node<T> cur = head;
    Node<T> temp = null;
    while (cur!=null) {
      temp =  cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    head = pre;
  }

  public static void main(String args[]) {
    LinkedList<String> head = new LinkedList<String>();
    head.add("AAA");
    head.add("BBB");
    head.add("DDDD");
    head.add("FFF");
    head.add("GGGkl");
    head.print();
    head.reverse();
    head.print();
  }
}


