package SCJP6.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author jbu
 */
public class TestIterator {

  public static Collection reverse(List l) {
    Collections.reverse(l);
    return l;
  }

  public static void main(String args[]) {
    List list = new ArrayList();
    list.add("1");
    list.add("2");
    list.add("3");
    for (Object o: reverse(list)) {
      System.out.println(o);
    }
  }

}
