package SCJP6;

import java.util.TreeSet;

/**
 * @author jbu
 */

public class TestTreeSet implements Comparable {
  public String name;

  public int compareTo(Object o) {
    return 0;
  }



  public static void main(String args[]) {
  TestTreeSet one = new TestTreeSet();
  TestTreeSet two = new TestTreeSet();
  one.name="Coffee";
  two.name="Tea";
  TreeSet set = new TreeSet();
  set.add(one);
  set.add(two);
    for (Object s: set) {
  System.out.println(((TestTreeSet)s).name);
    }
  }
}
