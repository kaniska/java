package topcoder;

import java.util.*;

public class DP_ZigZag {
  public static int longestZigzag(int[] sequence) {
    int n = sequence.length;
    int l[] = new int[n];
    boolean b[] = new boolean[n];
    Arrays.fill(l, 1);
    for (int i=1;i<n;i++) {
      for (int j=0;j<i;j++) {
        if (l[j]==1 && l[j]+1>l[i] && sequence[i]!=sequence[j]) {
          l[i] = l[j]+1;
          b[i] = sequence[i]>sequence[j]? true: false;
          continue;
        }
        if (l[j]>1 && l[j]+1>l[i] && (b[j] && sequence[i]<sequence[j] || !b[j] && sequence[i]>sequence[j])) {
          l[i] = l[j]+1;
          b[i] = !b[j];
        }
      }
    }
    System.out.println("Largest zigzag sequence number="+l[n-1]);
    return l[n-1];
  }

  public static void main(String[] args) {
    if (args.length<1) {
      System.out.println("Usage: DP_ZigZag <sequence>");
      System.exit(1);
    } 
    String [] s = args[0].split(",\\s*");
    int [] seq = new int[s.length];
    try {
      for (int i=0;i<s.length;i++) seq[i]=Integer.parseInt(s[i]);
    }catch(Exception e) {
      System.out.println("Invalid Args");
      System.exit(2);
    }
    longestZigzag(seq);
  }

}

