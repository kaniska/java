package topcoder;

import java.util.*;

public class DP_Coins {
  public static void main(String[] args) {
    if (args.length<2) {
      System.out.println("Not enough args");
      System.exit(1);
    }
    String []coins = args[0].split(",");    
    int sum = 0;
    int v[] = new int[coins.length];
    try {
      sum = Integer.valueOf(args[1]);
      System.out.print("TOTAL SUM IS "+sum+"\nCOINS IS ");
      for (int x=0;x<coins.length;x++) {
        v[x] = Integer.parseInt(coins[x]);
        System.out.print(v[x]+" ");
      }   
      System.out.println();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(2);
    }

    int min[] = new int[sum+1];
    int minCoin[] = new int[sum+1];
    Arrays.fill(min, 100000);
  
    min[0] = 0;
    for (int i=1;i<=sum;i++) { 
      for (int k=0;k<coins.length;k++) {
        if (v[k]<=i && min[i-v[k]]+1<min[i]) {
          min[i] = min[i-v[k]]+1;
          minCoin[i] = v[k];    
        }
      }
      System.out.print("Min coins for sum="+i+" is:"+ min[i]+ "  ==> (" );
      int a = i;
      while (a>0) {
        System.out.print(minCoin[a]+",");
        a -= minCoin[a];
      }
      System.out.println(")");
    }
  }
}
