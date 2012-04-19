package topcoder;

public class ChicksYack implements Runnable {
  Chicks c = new Chicks();;
  public static void main(String[] args) {
//    Chicks c = new Chicks();
    System.out.println(Thread.currentThread().getId());;
    new Thread(new ChicksYack()).start();
    new Thread(new ChicksYack()).start();
  }
  
  public void run() {
   c.yack(Thread.currentThread().getId());
  }
}
