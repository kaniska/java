package SCJP6.test;

/**
 * @author jbu
 */
public class TestInnerEnum {
  enum IEunm {
    Beginer,
    Intermediate {
      protected void doNow() { System.out.println("Intermediate.DoNow");}
    },
    Expert;
    void doNow() {
      System.out.println("doNow");
    }
  }

  public static void main(String args[]) {
    IEunm ie = IEunm.valueOf("Intermediate");
    ie.doNow();
    System.out.println(ie);
  }

}

class TestEnum2 {
  public static void main(String args[]) {
    TestInnerEnum.IEunm ie = TestInnerEnum.IEunm.Expert;
    System.out.println(ie);
  }
}
