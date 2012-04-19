package SCJP6.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author jbu
 */

class Tree {

  }

public class TestSer implements Serializable{
  private static int i = 5;
  private int a = 6;
  private  String s = "Hello";
  private String sn ;

  private Tree t = null;// new Tree();

  public TestSer(int a, String s) {
    this.a = a;
    this.s = s;
    sn += "Test";
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TestSer");
    sb.append("{a=").append(a);
    sb.append(", s='").append(s).append('\'');
    sb.append(", t=").append(t);
    sb.append('}');
    return sb.toString();
  }

  public static void main(String args[]) {
    try {
      TestSer t = new TestSer(12, "AAA");
      System.out.println(t.sn);
      TestSer.i = 123;
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my.ser"));
      oos.writeObject(t);
      TestSer.i = 124;
      oos.close();
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("my.ser"));

      TestSer nt = (TestSer) (ois.readObject());
      System.out.println(nt);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

}
