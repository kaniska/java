package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jbu
 */
public class TestBits {
  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o);
    }
    System.out.println(sb.toString());
  }

  public static void main(String args[]) {
    p(Integer.toString(~2));
    p(Integer.toString((-16 >> 2 ) + ( 2 << ~2 )));

    Double d = 8e-4;
    p(d);

  }
}
