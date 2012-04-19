package SCJP6.test;

/**
 * @author jbu
 */
public class TestGC {
  String name;

  public TestGC(String name) {
    this.name = name;
  }

  static void setNull(TestGC...s) {
    try {
      for (TestGC t: s){
        t = null;
      }
    } catch (RuntimeException r){

    }
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();    //To change body of overridden methods use File | Settings | File Templates.
    System.out.println("finalize called for"+name);
  }

  public static void main(String args[]) {
    TestGC s1 = new TestGC("A");
    TestGC s2 = s1;
    TestGC s3 = s2;
    TestGC s4 = s3;
    s3 = new TestGC("B");
    setNull(s1,s2,s3,s4);
    s4 = null;
    s3 = null;
    s1 = null;
    s2 = null;

    System.gc();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }
}
