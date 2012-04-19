package fb.prob;

import java.util.Random;

/**
 * @author jbu
 */
public class ProbHalf {

  static Random r = new Random();
  static double PROB = 0.8813;
  static long exp_value = 0;
  static boolean prob() {
    if (r.nextDouble() < PROB) {
      return true;
    }
    return false;
  }

  /**
   * We have to get any two independant probablitiy
   * @return
   */
  static boolean prob5() {
    boolean b1, b2;
    do {
      exp_value++;
      b1 = prob();
      exp_value++;
      b2 = prob();
      if (b1 != b2) {
        break;
      }
    } while (true);
    return b1;
  }

  /**
   * this is wrong because we are unfortunately checking three prob and requires first two be the same
   * so we are returning one of aab , bba,
   * however, the probablity of getting one of each is not equal
   * to get aab:   p*p*(1-p)
   * to get bba:   (1-p)*(1-p)*p
   * so if we return a: then probablility is still (1-p) or b is p, same as inital probablity
   * @return
   */
  static boolean prob5s() {
    boolean b1, b2;
    b1= prob();
    do {
      b2 = prob();
      if (b1 != b2) {
        break;
      }
      b1=b2;
    } while (true);
    return b2;
  }


  static void testProb() {
    long s = System.currentTimeMillis();
    for (int i = 0; i < 1; i++) {
      int c = 1000000;
      int trueCount = 0;
      for (int j = 0; j < c; ++j) {
        if (prob5()) {
          trueCount++;
        }
      }
      System.out.println("p--" + 0.5 + ", tc%--" + (double) trueCount / c + " time="+(System.currentTimeMillis()-s)+"ms  exp_value=" +(double)exp_value/c);
    }
  }

  public static void main(String args[]) {
    testProb();
  }

}
