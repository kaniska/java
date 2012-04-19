package SCJP6;

import java.util.HashSet;
import java.util.Set;

public class TestEqual {
  public static void main(String args[]) {
    Set<MyTestObject> s = new HashSet<MyTestObject>();
    s.add(new MyTestObject(1));
    s.add(new MyTestObject(2));
    s.add(new MyTestObject(3));
    System.out.println(s.size());

Integer i=new Integer("1");
System.out.println(i<<1);

    System.out.println("AAA"+new MyTestObject(1).equals(new MyTestObject(2)));

  }

}
