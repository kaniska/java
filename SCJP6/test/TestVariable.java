package SCJP6.test;

/**
 * @author jbu
 */
public class TestVariable {
  static {
    System.out.println("TestVariable");
    a = 5;
  }
  {
    i =5;
  }
  int i =3;
  int j =i;
  int x = 1;

  static int a = 5;


}
