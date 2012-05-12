package fb.puzzle;

/**
 * @author jbu
 */
public class TrapRunningWater {
  public int trap(int[] A) {
    if (A.length <= 2) {
      return 0;
    }
    int[] lmax = new int[A.length];
    int[] rmax = new int[A.length];
    lmax[0] = A[0];
    for (int i = 1; i < A.length; i++) {
      lmax[i] = Math.max(lmax[i - 1], A[i]);
    }
    rmax[A.length - 1] = A[A.length - 1];
    for (int i = A.length - 2; i >= 0; i--) {
      rmax[i] = Math.max(rmax[i + 1], A[i]);
    }
    int total = 0;
    for (int i = 1; i < A.length - 1; i++) {
      int low = Math.min(lmax[i - 1], rmax[i + 1]);
      total += (low > A[i]) ? (low - A[i]) : 0;
    }
    return total;
  }
}
