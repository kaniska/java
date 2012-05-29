package fb.tree;

/**
 * @author: mindPower
 * @since: 5/19/12-10:55 AM
 */
public class FindSecondLargest {

  public Node findSecondLargest(Node node) {
    Node secondLargest = null;
    Node parent = null;
    Node child = node;
    if (node != null && (node.hasLeftChild() || node.hasRightChild())) {
      if (node.hasRightChild()) {
        while (child.hasRightChild()) {
          parent = child;
          child = child.rightChild();
        }
        secondLargest = parent;
      }
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
