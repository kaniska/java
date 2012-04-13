package leetcode;

/**
 * @author jbu
 */
public class Overflow {
  public static void main(String args[]) {
    int a=Integer.MAX_VALUE-10;
    System.out.println("a+100="+(a+100));
    if (a+100>Integer.MAX_VALUE) System.out.println("Overflow");
  }

}
