package fb.prob;

/**
 * http://www.mitbbs.com/article/JobHunting/32054765_0.html
 *
 * @author jbu
 */
public class ProbAny_Peking extends ProbAny {
  public boolean prob(double d) {
    return prob(d, true);
  }

  private boolean prob(double p, boolean expected) {
    exp_value++;
    if (p < 0.5) {
      expected = !expected;
      p = 1 - p;
    }
    if (prob() == expected) {
      return expected;
    }
    else {
      return prob((p - 0.5) / 0.5, expected);
    }
  }
}

