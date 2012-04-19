package SCJP6.test;

/**
 * @author jbu
 */
public class A extends Thread{

     public static void doDelay(long t){

          try{
               Thread.sleep(t);
          }catch(InterruptedException e){
               System.out.print("Ex-A ");
          }

     }

     public void run(){
       System.out.println("Run-before-sleep");
          doDelay(2000);
       System.out.println("Run-after-sleep");
          halt();
     }

     public void halt(){

          try{
               this.wait();
          }catch(Exception e){
               System.out.print("Ex-B ");
          }

     }

     public static void main(String args[])throws Exception{
          A a=new A();
          Thread t=new Thread(a);
          t.start();
          doDelay(100);
          a.interrupt();
          doDelay(2000);
          t.notifyAll();
     }
}