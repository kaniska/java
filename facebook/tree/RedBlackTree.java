package facebook.tree;

import java.util.*;

/**
 * @author jbu
 * @since 3/18/12 1:31 PM
 */
public class RedBlackTree {
  enum Color {RED, BLACK}

  class RBT {
    int val;
    RBT left, right;
    Color color;

    RBT(int val, Color color) {
      this.val = val;
      this.color = color;
    }
  }

  public RBT copyRed(RBT root) {
    if (root == null) return null;
    RBT left = root.left == null ? null : copyRed(root.left);
    RBT right = root.right == null ? null : copyRed(root.right);
    RBT rbt = null;
    if (left != null || right != null || root.color == Color.RED) {
      rbt = new RBT(root.val, root.color);
      rbt.left = left;
      rbt.right = right;
    }
    return rbt;
  }

}
