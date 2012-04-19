package topcoder;

import java.util.*;
public class Ferry {
  public static void main(String[] args) {
    TreeSet<Integer> times = new TreeSet<Integer>();
    times.add(1205);
    times.add(1505);
    times.add(1545);
    times.add(1600);
    times.add(1830);
    times.add(2000);
    times.add(2100);
    TreeSet<Integer> subset = (TreeSet)times.subSet(1600,2100);
    System.out.println(subset);
    times.add(1100);
    times.add(1822);
    System.out.println(subset);
    System.out.println("first="+subset.pollFirst());
    System.out.println(subset +"   "+times);
    List<Integer> l = new ArrayList<Integer>();
    l.add(12);
    l.add(18);
    l.add(122);
    l.add(12);
    System.out.println(l);
    l.remove(new Integer(12));
    System.out.println(l);
  }
}
