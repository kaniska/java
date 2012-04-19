package scjp;

/**
 * @author jbu
 */
class MyThread extends Thread{
  public void run() {
    for (int i=0;i<100;i++) {
    //  System.out.print("#");
      System.out.println(Thread.currentThread().getName()+"  "+i);
    }
  }
}
