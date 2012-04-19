package interview;

/**
 * @author jbu
 */
public class ReverseLinkList {
  public static void main(String args[]) {
    Node n = Node.getSampleList();
    Node.print(n);
    Node.print(Node.reverse(n));
  }
}

class Node {
  String s;
  Node next;

  Node(String s, Node next) {
    this.s = s;
    this.next = next;
  }

  public static Node getSampleList() {
    String[] l = {"Hello", "This", "Is", "A", "Beautiful", "World"};
    Node prev = null;
    for (String s : l) {
      Node n = new Node(s, prev);
      prev = n;
    }
    return prev;
  }

  public static void print(Node h) {
    while (h != null) {
      System.out.print(h.s + " ==> ");
      h = h.next;
    }
    System.out.println();
  }

  public static Node reverse(Node h) {
    Node prev = null;
    while (h != null) {
      Node next = h.next;
      h.next = prev;
      prev = h;
      if (next == null) {
        return h;
      }
      h = next;
    }
    return h;
  }
}
