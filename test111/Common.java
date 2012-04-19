package test111;

/**
 * @author jbu
 */
public class Common {
  public static void pl(Object... msg) {
    p(msg);
    p("\n");
  }

  public static void p(Object... msg) {
    StringBuilder sb = new StringBuilder("");
    for (Object o : msg) {
      if (o != null) {
        sb.append(o);
      } else {
        sb.append("null");
      }
    }
    System.out.print(sb.toString());
  }
}
