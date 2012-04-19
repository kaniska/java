package scjp;

import java.util.*;

public class TestList {
   public static void add(List<? extends Animal> l) {
      System.out.println(l);
      Animal a = new Cat();
     // l.add(a);
   }

   public static void main(String[] args) {
     List<Dog> d = new ArrayList<Dog>();
     d.add(new Dog());
     d.add(new Dog());
     add(d);
  }
}
