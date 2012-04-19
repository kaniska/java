package careercup;

import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jbu
 */
public class C4_TreeGraph {

  public static TreeNode sortedArrayToBTree(int[] a, int i, int j) {
    if (i>j) return null;
    TreeNode t = new TreeNode();
    t.data = a[i+ (j-i)/2];
    t.left = sortedArrayToBTree(a, i, i+(j-i)/2-1);
    t.right = sortedArrayToBTree(a, i+(j-i)/2+1, j);
    return t;
  }

  public static void main(String args[]) {
    int [] d = {1,3,9,12,24,46,78,122,789,800,890,912,2211,2233};
    TreeNode t = sortedArrayToBTree(d, 0, d.length-1);
    TreeNode.traverse(t);
    System.out.println();
    t.toLinkedList();
    ArrayList a  = new ArrayList();
    a.add(3);
    a.add(5);
    a.add(7);
    System.out.println(a.toString()+ ">>>"+ a.get(0));

  }

}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode parent;

  public static void traverse(TreeNode t)  {
    if (t==null) return;
    if (t.left!=null) traverse(t.left);
    System.out.print(t.data+" ");
    if (t.right!=null) traverse(t.right);
  }

  public List<LinkedList<TreeNode>> toLinkedList() {
    List<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    current.add(this);
    while (current!=null)  {
      list.add(current);
      LinkedList<TreeNode> next = new LinkedList<TreeNode>();
      for (TreeNode t: current)  {
        System.out.print(t.data+";");
        if (t.left!=null) next.add(t.left);
        if (t.right!=null) next.add(t.right);
      }
      System.out.println();
      current = next.size()>0? next:null;
    }
    return list;
  }

  public static TreeNode getSuccessor(TreeNode t) {
    if (t==null) return null;
    if (t.parent==null || t.right!=null) {
      // get left most children of t.right;
      TreeNode c = t.right;
      while (c.left!=null) c=c.left;
      return c;
    } else {
      TreeNode p ;
      while ( (p=t.parent)!=null) {
        if (p.left==t) return p;
        else {
          t = p;
        }
      }
      return p;
    }
  }


}
