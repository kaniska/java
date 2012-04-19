package tc;

import java.util.*;

public class DP_BadNeighbors {
  public static void main(String[] args) {
    if (args.length < 1 && !args[0].equals("Test")) {
      System.out.println("Usuage: DP_BadNeighbors  <Args>");
      System.exit(1);
    }
    String s[] = args[0].split(",\\s*");
    int n[] = new int[s.length];
    try {
      for (int i = 0; i < s.length; i++) n[i] = Integer.parseInt(s[i]);
    } catch (Exception e) {
      System.out.println("Invalid Args");
      System.exit(2);
    }
    System.out.println("Result=" + maxDonations(n));
  }

  public static int maxDonations(int[] donations) {
    int max1, max2;
    int n = donations.length;
    int m1[] = Arrays.copyOf(donations, n); //0..n-2  (n-1)
    int m2[] = Arrays.copyOf(donations, n); // 1..n-1  (n-1)

    // 0..n-1
    for (int i = 1; i < n - 1; i++) {
      for (int j = 0; j < i - 1; j++) {
        if (donations[i] + m1[j] > m1[i]) m1[i] = donations[i] + m1[j];
      }
    }

    // 1..n
    for (int i = 2; i < n; i++) {
      for (int j = 1; j < i - 1; j++) {
        if (donations[i] + m2[j] > m2[i]) m2[i] = donations[i] + m2[j];
      }
    }
    return Math.max(m1[n - 2], m2[n - 1]);
  }
}
