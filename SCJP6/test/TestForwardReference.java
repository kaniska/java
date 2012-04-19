package SCJP6.test;

/**
 * @author jbu
 */
public class TestForwardReference {
  static class AA{
     public void AAA() {
       int x = xx;
     }
  }
  int i =getJ();
  int j = 3;
  int getJ() {return j;}
  static int xx = 0;
  public static void main(String args[]) {
    class DDD {
      public void doX() {
      }
    }
    System.out.println(new TestForwardReference());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();

    sb.append("TestForwardReference");
    sb.append("{i=").append(i);
    sb.append(", j=").append(j);
    sb.append('}');
    return sb.toString();
  }
}
