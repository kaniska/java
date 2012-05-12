package fb.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jbu
 */
public class minDepth {
  public static int minDepth(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  public static int minDepthUsingBFS(Node root) {
    if (root == null) {
      return 0;
    }
    Deque<Node> queue = new ArrayDeque<Node>();
    queue.add(root);
    int level = 1, nodesCurrent = 1, nodesNext = 0;
    while (!queue.isEmpty()) {
      Node n = queue.remove();
      nodesCurrent--;
      if (n.left == null || n.right == null) {
        return level;
      }
      if (n.left != null) {
        queue.add(n.left);
        nodesNext++;
      }
      if (n.right != null) {
        queue.add(n.right);
        nodesNext++;
      }
      if (nodesCurrent == 0) {
        nodesCurrent = nodesNext;
        nodesNext = 0;
        level++;
      }
    }
    return level;
  }

  public static void main(String args[]) {
    Node root = Tree.initTree();
    System.out.println(minDepth(root));
    System.out.println(minDepthUsingBFS(root));
  }
}
