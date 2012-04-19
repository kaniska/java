package scjp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ListArray {

  Object d;

  static class BBB {
    public void m() {
      p("BBB");
    }
  }
  public void test() {
    BBB bbb = new BBB();
    bbb.m();
    class BBB {
      void m() {
        p("test.BBB");
      }
    }
    final List<String> l = new ArrayList<String>();
    l.add("One");
    l.add("Two");
    l.add("Three");
    class AAA {
      String xy = "HHH";
      public void t() {
        p(l);
      }

      @Override
      public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AAA");
        sb.append("{xy='").append(xy).append('\'');
        sb.append(l);
        sb.append('}');
        return sb.toString();
      }
    }
    AAA a = new AAA();
    a.t();
    d = a;
  }

  public void test2() {
    p(d.getClass());
    p(d.toString());
  }

  public static void main(String args[]) {
    ListArray la = new ListArray();
    la.test();
    la.test2();
    final List<String> l = new ArrayList<String>();
    l.add("One");
    l.add("Two");
    l.add("Three");
    p(l);

    String[] a = new String[1];
    a = l.toArray(a);
    Iterator<String> it = l.iterator();
    while (it.hasNext()) {
      String n = it.next();
      p("Next=" + n);
      if (n.equals("One")) {
        it.remove();
      }
    }
    p(l);
    p(a[0], a[1], a[2]);
    l.set(0, "XXX");

    p(a[0], a[1], a[2]);

    Animal[] animals = new Animal[10];
    p(Arrays.toString(animals));
    Animal[] aaa = new Dog[10];
    Dog[] ddd = (Dog[]) aaa;

    Set t = new TreeSet();
    t.add("3");
    t.add("2");
    t.add("1");
    for (Object oo : t) {
      p(oo);
    }

    Map<String, Integer> m = new HashMap<String, Integer>();
    m.put("Hello", 1);
    p(m.get("SSS"));
//    int a1 = m.get("DD");
//    p(a1);

    PriorityQueue q = new PriorityQueue();
    q.peek();
    q.remove("2");

  }

  class Dog extends Animal {
  }

  class Animal {
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o).append(" ");
    }
    System.out.println(sb.toString());
  }
}
