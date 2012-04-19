package SCJP6;

import java.util.TreeSet;

/**
 * @author jbu
 */
public class Concept {
  public void p() {

  }

  public int p(int...i) {
    return 4;
  }

  public int p(Integer...i) {
    return 3;
  }


  public int p(Integer i) {
    return 2;
  }

  public static void main(String[] args) {
    System.out.println(new Concept().p(3));
    A a = new B();
    a.print();
    ((B)a).print();
    B b = new B();

    TreeSet<A> t = new TreeSet<A>();
    t.add(a);
    t.add(b);
    System.out.println(t);


    try {
      a.ss();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

class A {
   protected void ss() throws Exception, IllegalArgumentException {
     System.out.println("a.ss");
     throw new IllegalArgumentException("Error");
   }

  public static void print() {
    System.out.println("TA");
  }
}

class B extends A {
  public void ss()  {
    System.out.println("b.ss");
     throw new IllegalArgumentException("Error");
  }
  public static void print() {
    System.out.println("B");
  }
}