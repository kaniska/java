package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbu
 */
public class CoreJava {

  List<String> list = new ArrayList<String>();
  String[] a = new String[100];


  public void testArray() {
    int[] i = new int[10];
    String[] s = new String[10];
    String[] d ;
    for (String s1: s) {
      System.out.println(s1);
    }
    for (int i1: i) {
      System.out.println(i1);
      
    }
  }


  public static void main(String args[]) {
    System.out.println((char)('1'+3));
    CoreJava cj = new CoreJava();
    cj.testArray();

    while (true) {
      System.out.println("Sleep...");

      try {
        Thread.sleep(60*1000);
      } catch (InterruptedException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        System.exit(0);
      }
    }
  }
}
