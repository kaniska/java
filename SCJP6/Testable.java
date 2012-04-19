package SCJP6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

/**
 * @author jbu
 */
interface Testable {
  public enum AAAAA {A, B}

}

class TB {
  public static void main(String args[]) {
    TA.State a = TA.State.ACTIVE;
  }
}

class TA implements Testable {
  enum State {ACTIVE, DELETED;
    enum AA {D, C}


  }

  static void book(short s) {}
  static void book(Short s) {}
  static void book(Long s) {}
  class N<T extends Number> {
    T t;

    N(T t) {
      this.t = t;
    }

    private double toDouble() {
      return t.doubleValue();
    }
  }

  public void t() {
    TA.State s = TA.State.ACTIVE;

  }

  static void tt() {
  }

  private  int abcde = 1;
  public static void main(String[] args) {
    TA aaaa = new TA();

    int [] pi = new int[0];
    System.out.println(pi.length);
    Object myObj = new String[]{"one", "two", "three"};
    { int xxx =3;
          for (String s : (String[])myObj) System.out.print(s + "."); }

    TA.N<Integer> ii = aaaa.new N(new Integer(3));
    System.out.println(ii.toDouble());
    Properties p = System.getProperties();
    Double f = null;
    TreeSet t = new TreeSet<Number>();
    t.add(12);
    t.add(new Integer("12"));
    t.add(412);
    t.add(new Integer(33));
    if (5 > new Float(1)) {
      System.out.println(">");
    }

    List<String> ls = new ArrayList<String>();
    ls.add("One");
    ls.add("Two");
    Collections.reverse(ls);
    Iterator it = ls.iterator();
    while (it.hasNext())  {
      System.out.println(it.next());
    }
    System.out.println(Boolean.valueOf("truE"));

    String[] as = {"OOO", "OOSS", "SSSO"};
    List<String> ll = Arrays.asList(as);
//    ll.add("T");
//    ll.remove("XX");
//    ll.remove("OOO");
    ll.set(1, "OOX");
    as[0]="HEEE";
    System.out.println(ll);
    as = null;
    as[1] = "SS";

    System.out.println(t);
    HashMap<String, Integer> hh = new HashMap<String, Integer>();


  }

}