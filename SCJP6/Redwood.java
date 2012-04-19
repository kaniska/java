package SCJP6;

/**
 * @author jbu
 */
public class Redwood extends Tree {
 // static String s = "World";

  static void go(Tree t, Redwood r) {
    Redwood r1 = (Redwood)t;
    Tree t1 = (Tree)r;
  }

  public static void main(String args[]) {
    s += "Hel";
    System.out.println(s);
//    go(new Tree(), new Redwood()) ;
//    go((Redwood)new Tree(), new Redwood());
    StringBuilder sb = new StringBuilder("AAA");


    StringBuffer s = new StringBuffer("BBB");

  }



}

class Tree {
  public static String s = "Hello";
}