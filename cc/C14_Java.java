package cc;

import java.lang.reflect.Field;

/**
 * @author jbu
 */
public class C14_Java {
  private int a;
  private long b;

  public C14_Java() {
  }

  public C14_Java(int a, long b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof C14_Java)) {
      return false;
    }

    C14_Java c14_java = (C14_Java) o;


    if (a != c14_java.a) {
      return false;
    }
    if (b != c14_java.b) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = a;
    result = 31 * result + (int) (b ^ (b >>> 32));
    return result;
  }

  public static void main(String args[]) {
    AA aa = new AA();
    System.out.println(aa);
    try {
      Class clazz = Class.forName("careercup.AA");
      Field[] fs = clazz.getDeclaredFields();
      Field f = clazz.getDeclaredField("a1");
      f.setAccessible(true);
      f.set(aa, 1221312);
      System.out.println(aa);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (NoSuchFieldException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (IllegalAccessException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }
}


class AA {
  private int a1= 1;
  private int a2 = 2;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AA");
    sb.append("{a1=").append(a1);
    sb.append(", a2=").append(a2);
    sb.append('}');
    return sb.toString();
  }
}


