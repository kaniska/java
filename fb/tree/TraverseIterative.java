package fb.tree;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author jbu
 */
public class TraverseIterative {

  public static void preOrderIterative(Node root) {
    Stack<Node> s = new Stack<Node>();
    s.push(root);
    while (!s.isEmpty()) {
      Node p = s.pop();
      if (p == null) {
        continue;
      }
      System.out.print(p.s+" ");
      s.push(p.right);
      s.push(p.left);
    }
    System.out.println();
  }

  /**
   * can remove using of set, instead, push all left node until null
   * @param root
   */
  public static void inOrderIterative(Node root) {
    Stack<Node> s = new Stack<Node>();
    HashSet<Node> h = new HashSet<Node>();
    s.push(root);
    while (!s.isEmpty()) {
      Node p = s.pop();
      if (p==null) {
        continue;
      }
      if (h.contains(p)) {
        System.out.print(p.s +" ");
        s.push(p.right);
      } else {
        h.add(p);
        s.push(p);
        s.push(p.left);
      }

    }
    System.out.println();

  }

    /**
   * remove using of set, instead, push all left node until null
   * @param root
   */
  public static void inOrderIterativeWithoutSet(Node root) {
    Stack<Node> s = new Stack<Node>();

    while (root!=null) {
      s.push(root);
      root = root.left;
    }

    while (!s.isEmpty()) {
      Node p = s.pop();
      System.out.print(p.s +" ");
      while (p.right!=null) {
        Node pr = p.right;
        while (pr!=null) {
          s.push(pr);
          pr = pr.left;
        }
      }
    }
    System.out.println();

  }

  /**
   * can remove h, use pre Node
   * @param root
   */
  public static void postOrderIterative(Node root) {
    Stack<Node> s = new Stack<Node>();
    HashSet<Node> h = new HashSet<Node>();
    s.push(root);
    while (!s.isEmpty()) {
      Node p = s.peek();
      if (p == null) {
        s.pop();
        continue;
      }
      if (h.contains(p)) {
        System.out.print(p.s +" ");
        s.pop();
      } else {
        h.add(p);
        s.push(p.right);
        s.push(p.left);
      }
    }
    System.out.println();
  }

    /**
   *  remove h, use pre Node
   * @param root
   */
  public static void postOrderIterativeWithNoSet(Node root) {
    Stack<Node> s = new Stack<Node>();
    Node pre  = null;
    s.push(root);
    while (!s.isEmpty()) {
      Node p = s.peek();
      if ((p.left==null && p.right==null) ||  (pre!=null && (p.left==pre || p.right==pre))) {
        System.out.print(p.s +" ");
        s.pop();
      } else {
        if (p.right!=null) s.push(p.right);
        if (p.left!=null)  s.push(p.left);
      }
      pre = p;
    }
    System.out.println();
  }

  public static void main(String args[]) {
//    p.printTree();
    Node root = Tree.initTree();
    System.out.println("Print Tree by level :");
    Tree.printTree(root);
    System.out.print("\nPre Order  ==> ");
    preOrderIterative(root);
    System.out.print("\nIn Order  ==> ");
    inOrderIterative(root);
    System.out.print("\nIn Order withou set ==> ");
    inOrderIterative(root);
    System.out.print("\nPost Order  ==> ");
    postOrderIterative(root);
    System.out.print("\nPost Order without set  ==> ");
    postOrderIterativeWithNoSet(root);

  }

}
