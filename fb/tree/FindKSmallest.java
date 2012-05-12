package fb.tree;

/**
 * @author jbu
 */
public class FindKSmallest {

  public static int findKSmallest(Node n, int k) {
    int i = 0;
    if (n.left != null) {
      i = findKSmallest(n, k);
    }
    i++;
    System.out.println(n.s + "  " + i);
    if (i == k) {
      System.out.println(n.s);
      return k;
    }
    if (n.right != null) {
      i += findKSmallest(n, k);
    }
    return i;
  }
}
