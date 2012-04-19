package tc;

import java.util.*;

public class Mixup {
  public static void main(String[] args) {
    Set s = new LinkedHashSet();
    s.add(1);
    s.add("H");
    s.add(new Object());
    System.out.println(s);
  }
}
