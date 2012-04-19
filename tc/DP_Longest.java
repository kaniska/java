package tc;

import java.util.*;

public class DP_Longest {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("No args provided");
      System.exit(1);
    }
    String[] seq = args[0].split(",");
    int n[] = new int[seq.length];
    try {
      for (int i = 0; i < seq.length; i++) n[i] = Integer.parseInt(seq[i]);
    } catch (Exception e) {
      System.exit(1);
    }

    int l[] = new int[n.length];
    Arrays.fill(l, 1);
    for (int i = 1; i < n.length; i++) {
      for (int j = 0; j < i; j++) {
        if (n[i] >= n[j] && l[j] + 1 > l[i]) l[i] = l[j] + 1;
      }
    }
    System.out.println("Longest sequence=" + l[n.length - 1]);
  }
}
