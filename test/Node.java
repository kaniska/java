package test;

/**
 * @author jbu
 */
class Node<T> {
  T element;
  Node<T> next = null;

  Node(T element) {
    this.element = element;
  }

  Node() {
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Node");
    sb.append("{element=").append(element);
    sb.append(", next=").append(next == null ? "null" : "NODE");
    sb.append('}');
    return sb.toString();
  }
}