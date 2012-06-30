package fb.tree;

/**
 * @author: mindPower
 * @since: 5/19/12-10:55 AM
 */
public class FindSecondLargest {
  Node findSceondLargest(Node root) {
    // If tree is null or is single node only, return null (no second largest)
    if (root == null || (root.left == null && root.right == null)) return null;
    Node parent = null, child = root;
    // find the right most child
    while (child.right != null) {
      parent = child;
      child = child.right;
    }
    // if the right most child has no left child, then it's parent is second largest
    if (child.left == null) return parent;
    // otherwise, return left child's rightmost child as second largest
    child = child.left;
    while (child.right != null) child = child.right;
    return child;
  }

  public Node findSecondLargest_dep(Node node) {
    Node secondLargest = null;
    Node parent = null;
    Node child = node;
    if (node != null && (node.hasLeftChild() || node.hasRightChild())) {
      // if has right child, keep gettings its children and return parent of the last child
      if (node.hasRightChild()) {
        child = node.rightChild(); // this will make it correct
        while (child.hasRightChild()) {
          parent = child;
          child = child.rightChild();
        }
        secondLargest = parent;
      }
      // if it only has left child, then return the right most one (largest of the left tree)
      else if (node.hasLeftChild()) {
        child = node.leftChild();
        while (child.hasRightChild()) {
          child = child.rightChild();
        }
        secondLargest = child;
      }
    }
    return secondLargest;
  }
}
