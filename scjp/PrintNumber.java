package scjp;

public class PrintNumber {
  public static void main(String[] args)  {
    Thread t0 = new MyThread();
    Thread t1 = new MyThread();
    t1.setName("H");
    t1.setPriority(1);
    Thread t2 = new MyThread();
    t2.setName("L");
    t2.setPriority(10);
    t0.start();
    t1.start();
    t2.start();
  }
}  
