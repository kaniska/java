package SCJP6.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jbu
 */
public class TestComparable {

  public static void main(String...args) {
    Set<Drink> h = new HashSet<Drink>();
    h.add(new Drink("One"));
    h.add(new Drink("Two"));
    System.out.println("HashSet");
    System.out.println(h);

    System.out.println("TreeSet");
    Set<Drink> t = new TreeSet<Drink>();
    t.add(new Drink("One"));
    t.add(new Drink("Two"));
    System.out.println(t);

    Map<Drink, Drink> hm = new HashMap<Drink, Drink>();
    hm.put(new Drink("Tea"), new Drink("Tea"));
    hm.put(new Drink("Coffee"), new Drink("Coffee"));
    System.out.println(hm);

    Map<Drink, Drink> tm = new TreeMap<Drink, Drink>();
    tm.put(new Drink("Tea"), new Drink("Tea"));
    tm.put(new Drink("Coffee"), new Drink("Coffee"));
    System.out.println(tm);
    System.out.println(tm.get(new Drink("Tea")));
    System.out.println(tm.get(new Drink("Coffee")));



  }
}



class Drink implements  Comparable<Drink> {
  String name;
  final int x[];

  Drink(String name) {
    x = new int[3];
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    x[0] = 5;
  }

  @Override
  public int hashCode() {
    System.out.println("Hashcode called");
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    System.out.println("Equals called");
    if (obj instanceof Drink && ((Drink)obj).name.equals(name) ) {
      return true;
    }
    return false;
  }

  public int compareTo(Drink o) {
    System.out.println("CompareTo called");
    return 0;  //TODO: Implement method here
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Drink");
    sb.append("{name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}