package scjp;

import java.util.*;

public class TestIterator {
  public static void main(String[] args) {
     List<String> list = new ArrayList<String>();
     list.add("Hello");
     list.add("World");
     list.add("Yesa");
     for (String s: list) {
//       if (s.equals("Hello")) list.remove("World"); 
       System.out.println(s);
     }
     Iterator<String> i = list.iterator();
     
     while (i.hasNext()) {
       String x = i.next();
       System.out.println(x);
//       if (x.equals("Hello")) list.remove(2);
     }
  }
}
