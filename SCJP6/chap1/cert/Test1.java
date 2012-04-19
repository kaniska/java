package SCJP6.chap1.cert;

/**
 * @author jbu
 */
public class Test1 {
  private int a = 3;
  private void goFast() {
    System.out.println("Test1.gofast a="+a);
  }
  public Test1() {}

  final public static void s1() {}

  final protected void A1() {}

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Test1)) {
      return false;
    }

    Test1 test1 = (Test1) o;

    if (a != test1.a) {
      return false;
    }
    if (bb != test1.bb) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = a;
    result = 31 * result + bb;
    return result;
  }

  public int getA() {return a;}

  protected int tt() {return 1111;

  }

  protected void testIt() {
    System.out.println("Other");
  }
  protected int bb = 3;
}

class T3 {
  Test1 t1 = new Test1();
  int a = t1.bb;
  public void a() {
    t1.testIt();
  }
}

