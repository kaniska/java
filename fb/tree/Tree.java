package fb.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jbu
 */
public class Tree {

  /**
   * H
   * / \
   * E   G
   * /\  / \
   * A B  F  D
   * /
   * C
   */

  public static Node initTree() {
    Node n1 = new Node("A");
    Node n2 = new Node("B");
    Node n3 = new Node("C");
    Node n4 = new Node("D");
    Node n5 = new Node("E", n1, n2);
    Node n6 = new Node("F", n3, null);
    Node n7 = new Node("G", n6, n4);
    return new Node("H", n5, n7);
  }

  public static void printTree(Node root) {
    Deque<Node> q = new ArrayDeque<Node>();
    q.add(root);
    int nodesCurrent = 1, nodesNext = 0;
    while (!q.isEmpty()) {
      nodesCurrent--;
      Node c = q.remove();
      System.out.print(c.s + "   ");
      if (c.left != null) {
        q.add(c.left);
        nodesNext++;
      }
      if (c.right != null) {
        q.add(c.right);
        nodesNext++;
      }
      if (nodesCurrent == 0) {
        System.out.println();
        nodesCurrent = nodesNext;
        nodesNext = 0;
      }
    }
  }
}

class Node {
  String s;
  Node left, right;

  Node(String s, Node left, Node right) {
    this.s = s;
    this.left = left;
    this.right = right;
  }

  Node(String s) {
    this.s = s;
  }

  boolean hasLeftChild() {
    return left != null;
  }

  boolean hasRightChild() {
    return right != null;
  }

  Node leftChild() {
    return left;
  }

  Node rightChild() {
    return right;
  }
}

