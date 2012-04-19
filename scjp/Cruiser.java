package scjp;

/**
 * @author jbu
 */
public class Cruiser implements Runnable {
  @Override
  public void run() {
    p("Run");
  }

  public static void main(String args[])  throws InterruptedException{
    Thread t = new Thread(new Cruiser());
    t.start();
    p("Start");
    t.join();
    p("End");
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o);
    }
    System.out.println(sb.toString());
  }
}
