package SCJP6;

/**
 * @author jbu
 */
class TestE implements TestC {
  static final int[] c = {100, 200};
  static final int[] b = new int[]{100, 200};
  static final int[] a;

  static {
    a = new int[2];
    a[0] = 100;
    a[1] = 200;
  }

  public void doSomething() {

    System.out.println("TestE");
  }
}
