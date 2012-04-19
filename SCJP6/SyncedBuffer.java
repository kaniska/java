package SCJP6;

public class SyncedBuffer {
  public static synchronized void main(String[] args) {
    class PrintBuffer implements Runnable {
      StringBuffer sb = null;
       public PrintBuffer(StringBuffer sb) {
         this.sb = sb;
       }
   
       public void run() {
           for (int i=0;i<100;i++) {
             System.out.print(sb.toString());
             try {
               Thread.sleep(10);
             } catch (InterruptedException e) {
               e.printStackTrace();
             }
           }
           System.out.println();
           sb.replace(0,1,String.valueOf((char)(sb.charAt(0)+1)));  

       }

    }
	
    StringBuffer ss = new StringBuffer("TA");
    PrintBuffer pb = new PrintBuffer(ss);
    Thread t1 = new Thread(pb, "T1");
    Thread t2 = new Thread(pb, "T2");
    Thread t3 = new Thread(pb, "T3");
    t1.start();
    t2.start();
    t3.start();
    	

  }
}

