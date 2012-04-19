package fb.prob;

import java.util.*;

/**
 * @author jbu
 * @since 3/17/12 6:27 PM
 */
public abstract class ProbAny {
  static long exp_value = 0;

  boolean prob() {
    Random rand = new Random();
    return rand.nextBoolean();
//    Random r = new Random();
//    if (r.nextDouble() < 0.5) {
//      return true;
//    }
//    return false;
  }

  abstract public boolean prob(double d);

  public static void main(String args[]) {
    ProbAny [] algorithm = new ProbAny[]{new ProbAny_DataMining(),new ProbAny_Peking(), new ProbAny_Junjie()};
    int n = 6;
    double [] p = new double[n];
    for (int i=0;i<n;i++) p[i]=Math.random();
    for (ProbAny m: algorithm) {
      exp_value=0;
      System.out.println(p.getClass().getSimpleName());
      m.testProb(p);
      System.out.println();
    }
  }


  private void testProb(double[] p) {
    //double[] p = {0.891, 0.9122, 0.33, 0.5};
    for (int i = 0; i < p.length; i++) {
      int c = 10000000;
      int trueCount = 0;
      for (int j = 0; j < c; ++j) {
        if (prob(p[i])) {
          trueCount++;
        }
      }
      System.out.printf("Expected: %7.3f || Actual: %7.3f || Accuracy: %10.2f%%,  EXP_VALUE=%6.2f\n"  ,
         p[i], (double) trueCount / c, (((double) trueCount / c)-p[i])*100, (double)exp_value/c);
    }
  }


}
