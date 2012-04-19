package SCJP6;//import static com.atti.leadgen.common.server.util.Util.DEFAULT_EMAIL_FORMAT;

import java.util.Properties;

/**
 * @author jbu
 */
public class BufferSync extends Thread implements Testable {
  private StringBuffer sb;
  /**
   * Allocates a new <code>Thread</code> object. This constructor has
   * the same effect as <code>Thread(null, null,</code>
   * <i>gname</i><code>)</code>, where <b><i>gname</i></b> is
   * a newly generated name. Automatically generated names are of the
   * form <code>"Thread-"+</code><i>n</i>, where <i>n</i> is an integer.
   *
   * @see #Thread(ThreadGroup, Runnable, String)
   */
  public BufferSync(StringBuffer sb) {
    this.sb = sb;
  }

  /**
   * If this thread was constructed using a separate
   * <code>Runnable</code> run object, then that
   * <code>Runnable</code> object's <code>run</code> method is called;
   * otherwise, this method does nothing and returns.
   * <p/>
   * Subclasses of <code>Thread</code> should override this method.
   *
   * @see #start()
   * @see #stop()
   * @see #Thread(ThreadGroup, Runnable, String)
   */
  public void run() {
    String A =  "AAA";
    try {
      A.wait();
      sb.wait();
    } catch (Exception e) {
  //    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    synchronized (sb) {
       for (int i=0;i<2;i++) {
         System.out.println(sb.toString());
         try {
           Thread.sleep(10);
         } catch (InterruptedException e) {

         }
       }
      sb.setCharAt(0, (char) (sb.charAt(0)+1));
    }
  }

  public synchronized static void main(String args[]) {
    assert (false);
    for (String s: args) {
      System.out.println("<"+s+">");
    }
    String x = null;
    Integer a = new Integer(3);
//    String s = DEFAULT_EMAIL_FORMAT;
    Number n = (Number)(Object)a;
    assert(false) :"not good";

    Properties p = System.getProperties();
    p.setProperty("TTTT", "TTTT");

    p.list(System.out);

    new String("TA");

    synchronized (args) {
      System.out.println(x + args.length);
    }
    int i = 3;

    StringBuffer sb = new StringBuffer("TA");
    BufferSync bs1 = new BufferSync(sb);
    BufferSync bs2 = new BufferSync(sb);
    BufferSync bs3 = new BufferSync(sb);
    bs1.start();
    bs2.start();
    bs3.start();

  }
}
