package scjp.test;

/**
 * @author jbu
 */
public class ThreadClass extends Thread{

     public ThreadClass(int x){
          this.x=x;
       System.out.println("x="+this.x);
     }

     static String s="";
     static volatile int x=5;

     public static void doVIP(){
       System.out.println("doVIP:x="+x);
          s=s+x;
          try{
               Thread.sleep(500);
          }catch(Exception e){
            System.out.println("Exception in thread");
               s=s+x;
          }
     }

     public void run(){
       System.out.println("run:x="+x);
          synchronized(s){
               doVIP();
          }
     }

     public static void doDelay(long g){
          try{Thread.sleep(g);}catch(Exception e){}
     }

     public static void main(String args[]){

          ThreadClass tc1=new ThreadClass(2);
          ThreadClass tc2=new ThreadClass(1);
          ThreadClass tc3=new ThreadClass(0);

          tc1.start(); doDelay(100); System.out.print(s+" ");
          tc2.start(); doDelay(100); System.out.print(s+" ");
          tc3.start(); doDelay(100); System.out.print(s);

     }
}