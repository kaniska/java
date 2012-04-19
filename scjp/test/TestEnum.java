package scjp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbu
 */
public class TestEnum {
  enum Types {AA, BA, CA}

  ;

  public static void main(String args[]) {
    Types t = Types.AA;
    int A = 99;
    int B = 98;

    Runnable r = new Runnable() {
      public void run() {

      }
    };

    TestEnum t1 = (TestEnum) r;
    XX x = new BB();
    TestEnum t2 = (TestEnum)x;
    List l = new ArrayList();
    TestEnum t3 = (TestEnum)l;
    String s = "AA";
    TestEnum t4 = (TestEnum)(Comparable)s;

  }

}

class BB implements  XX {

}

interface XX {

}