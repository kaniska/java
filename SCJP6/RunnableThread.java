package SCJP6;

/**
 * @author jbu
 */
public class RunnableThread {

  public static void main(String args[]) {
    Runnable r = new Runnable() {
      public void run() {
        System.out.println("Runnable");
      }
    };

    Thread t = new Thread(r) {
      public void run() {
        System.out.println("Thread");
      }
    };
    t.start();
  }
}
