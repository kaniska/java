package SCJP6.test;

/**
 * @author jbu
 */
public class TestPrimitives {
  final int a;

  {
    a = 1;
  }

  public static void main(String args[]) {
//    Long v1 = new Byte(2);
//    Byte v2 = new Long(2);
//    Byte v3 = new Byte(3);
    final int x;
    Long v4 = new Long(2);
    Short v5 = 4;
    Integer v6 = 4;
    Long v7 = 4L;
    Long l1 = new Long(112);
    Long l2 = new Long(112L);

    System.out.println(l1 == l2);
    PrimA a[] = new PrimA[3];
    if (a instanceof Object) {

    }

    Float pi = new Float(3.14f);
    Long lll = 3l;
    if (pi>3) {
      System.out.println(">");
    }

    int a1 = ~23;

    System.out.println(Integer.toString(23, 2) +" "+Integer.toString(~23,2));

    System.out.println(Integer.toBinaryString(23) +" "+Integer.toBinaryString(~23));

    if (v4 == 5) {
      x = 3;
   }

    switch (new Integer(a1)) {

    }

  }
}

class PrimA {

}

class PrimB {

}

interface Primable {

}
