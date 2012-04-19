package SCJP6.test;

import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jbu
 */
public class TestTreeSet {
  public static void testSet() {
    TreeSet<String> t = new TreeSet<String>();
    t.add("A");
    t.add("E");
    t.add("F");
    SortedSet<String> nvs = t.subSet("A", "Z");
    System.out.println("t="+t);
    System.out.println("nvs="+nvs);
  }

  public static void testMap() {
    TreeMap<String, String> t = new TreeMap<String,String>(Collections.<Object>reverseOrder());
    t.put("A", "Apple");
    t.put("B", "Banana");
    t.put("N", "Nike");
    SortedMap<String,String> s = t.subMap("a", "F");
    t.put("C", "Cat");
    t.put("Z", "Zebra");
    SortedMap<String, String> s1 = s.subMap("G", "b");
    System.out.println(t);
    System.out.println(s);
    System.out.println(s1);

  }
  public static void main(String args[]) {
    testMap();
  }

}
