package tc;

import java.util.*;

public class Magellan {
  public static void main(String[] args) {
    TreeMap<String, String> map = new TreeMap<String, String>();
    map.put("a", "apple");
    map.put("d", "date");
    map.put("f", "fig");
    map.put("p", "pear");
    System.out.println("1st" + map.higherKey("f"));
    System.out.println(map.ceilingKey("f"));
    System.out.println(map.floorKey("f"));
    SortedMap<String, String> sub = map.tailMap("f");
    System.out.println("submap=" + sub);
    System.out.println(sub.firstKey());
  }
}
