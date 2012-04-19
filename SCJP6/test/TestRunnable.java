package SCJP6.test;

/**
 * @author jbu
 */
public class TestRunnable {

  public static void main(String args[]) {
    Runnable r = new Runnable() {
      public void run() {
        System.out.println("Runnable");
      }
    };

    Thread t = new Thread(r) {
      public void run() {
        super.run();
        System.out.println("Thread");
      }
    };

    t.start();
  }
}
