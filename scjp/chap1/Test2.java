package scjp.chap1;

class MyException extends Exception {
}

class OurException extends MyException {
}

interface AAA {
  int A1 = 3;

  CharSequence aa() throws MyException;

}

class CC implements AAA {

  public StringBuilder aa() throws OurException {
    //TODO: Implement method here
    return null;
  }
}

/**
 * @author jbu
 */
public class Test2 extends Test1 {
  public static final int a;

  private enum Size {Large, Huge}

  private class AA {
  }

  static {
    a = 3;
  }


  private void goFast() {
    System.out.println("Test2.gofast a=" + a);
    Test1 t1 = new Test1();
    testIt();

  }

  public void A2() {
  }

  public static void main(String args[]) {
    Test2 t = new Test2();
    System.out.println("a=" + t.a);
    System.out.println("aa=" + t.getA());

    Test1 t1 = new Test2();
    ((Test2) t1).goFast();

    Test1 t3 = new Test1();

  }

  private int aa;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Test2 test2 = (Test2) o;

    if (aa != test2.aa) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + aa;
    return result;
  }
}
