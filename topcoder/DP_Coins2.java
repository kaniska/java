package topcoder;

import java.util.*;

public class DP_Coins2 {
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
    for (int k=0;k<coins.length;k++) {
      for (int i=0;i<=sum;i++) {
        if (i+v[k]<=sum && min[i]+1<min[i+v[k]]) min[i+v[k]]=min[i]+1;			
      }
    }
    for (int i=0;i<=sum;i++) {  
      System.out.print("Min coins for sum="+i+" is:"+ min[i]+ "  ==> (" );
      System.out.println(")");
    }
  }
}
