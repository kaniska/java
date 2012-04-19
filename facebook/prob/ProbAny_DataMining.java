package facebook.prob;

/**
 * http://www.mitbbs.com/article/JobHunting/32055263_0.html
 *
 * @author jbu
 */
public class ProbAny_DataMining extends ProbAny {

  public boolean prob(double p) {
    double EPS = 1e-8;
    if (p >= 1.0) {
      return true;
    }
    if (p <= 0.0) {
      return false;
    }

    int bitPos = 0;
    while (p > EPS) {
      exp_value++;
      bitPos++;
      p = p * 2;
      if (p >= 1.0) {
        // We need to return true with prob 2^(-bitPos),  this can be achieved by calling prob() with bitPos times and return true if all true
        // All false is the prerequesite state for checking next 1's.
        boolean allTrue = true, allFalse = true;
        for (int i = 0; i < bitPos; ++i) {
          boolean flip = prob();
          allTrue = allTrue && flip;
          allFalse = allFalse && !flip;
          EPS = EPS * 2;
        }

        if (allTrue) {
          return true;
        }
        if (!allFalse) {
          return false;
        }
        // reset
        bitPos = 0;
        p = p - 1.0;
      }
    }

    return false;
  }

}
