package fb.tree;

/**
 * @author jbu
 */

class Pair<F, S> {
  public F fst;
  public S snd;

  public Pair(F f, S s) {
    fst = f;
    snd = s;
  }
}

public class Convert2List {

  public static Pair<Node, Node> inOrderConversion(Node n) {
    if (n == null) {
      return null;
    }
    Node head = n, tail = n;
    if (n.left != null) {
      Pair<Node, Node> left = inOrderConversion(n.left);
      n.left = left.snd;
      left.snd.right = n;
      head = left.fst;
    }
    if (n.right != null) {
      Pair<Node, Node> right = inOrderConversion(n.right);
      n.right = right.fst;
      right.fst.left = n;
      tail = right.snd;
    }
    return new Pair<Node, Node>(head, tail);
  }

  public static void main(String args[]) {
    Node root = Tree.initTree();
    Pair<Node, Node> p = inOrderConversion(root);
    Node head = p.fst;
    while (head != null) {
      System.out.println(head.s);
      head = head.right;
    }
  }
}
