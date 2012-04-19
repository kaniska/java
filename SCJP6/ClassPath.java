package SCJP6;

/**
 * @author jbu
 */
public class ClassPath {
  static class B {
    static int a =5;
    static {
      a = 6;
      a = p();
    }
    static int p() {
      return a;
    }
    {
      int b = 9;
    }
  }
  class C {
    int a=5;
    final static int b =5;
    void p() {}
  }

  public static void main(String args[]) {

   System.out.printf("%02.2f%s%b",new Double(7),new StringBuffer("set"),"fAlSE");
    System.out.println(Boolean.valueOf("fAlSE"));
  }


}
