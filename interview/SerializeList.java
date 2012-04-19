package interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author jbu
 */
public class SerializeList implements Serializable{
  private int[] intArray;
  private Integer[] iArray;
  private String[] sArray;
  private List<String> list;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("SerializeList");
    sb.append("{intArray=").append(intArray == null ? "null" : "");
    for (int i = 0; intArray != null && i < intArray.length; ++i) {
      sb.append(i == 0 ? "" : ", ").append(intArray[i]);
    }
    sb.append(", iArray=").append(iArray == null ? "null" : Arrays.asList(iArray).toString());
    sb.append(", sArray=").append(sArray == null ? "null" : Arrays.asList(sArray).toString());
    sb.append(", list=").append(list);
    sb.append('}');
    return sb.toString();
  }

  public static void main(String args[]) {
    SerializeList s = new SerializeList();
    s.intArray = new int[] {1, 23, 324};
    s.iArray = new Integer[] {1, 899234, 324};
    s.sArray = new String[] {"Hello", "World"};
    s.list = Arrays.asList("Good", "Morning");

    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.ser"));
      oos.writeObject(s);
      oos.close();
      s.intArray = new int[]{7,8};
      System.out.println(s);

      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.ser"));
      SerializeList l2 = (SerializeList) ois.readObject();
      System.out.println(l2);
    } catch (IOException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (ClassNotFoundException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }



}
