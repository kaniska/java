package fb.dp;

/**
 * Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p/>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
  public int climbStairs(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int[] w = new int[n + 1];
    w[0] = 1;
    w[1] = 1;
    for (int i = 2; i <= n; i++) {
      w[i] = w[i - 1] + w[i - 2];
    }
    return w[n];

  }
}