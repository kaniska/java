package lc;

import java.util.*;

public class Jump2 {
  // DP
  public int jump(int[] A) {
    if (A.length <= 1) return 0;
    int s[] = new int[A.length];
    Arrays.fill(s, Integer.MAX_VALUE);
    s[0] = 0;
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = 1; j <= A[i]; j++) {
        if (i + j > A.length - 1) break;
        s[i + j] = s[i] + 1 < s[i + j] ? s[i] + 1 : s[i + j];
      }
    }
    return s[s.length - 1];
  }
}
