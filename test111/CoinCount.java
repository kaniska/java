package test111;

import java.util.Arrays;

/**
 * @author jbu
 */
public class CoinCount {

  public void count1(int[] v, int sum) {
     int[] s = new int[sum+1];
    Arrays.fill(s, 10000);
    s[0] =0;
    for (int i=0;i<v.length;i++) {
      for (int j=0;j<=sum;j++ ) {
        if (v[i]+j<=sum) s[j+v[i]]= Math.min(s[j+v[i]], s[j]+1);
      }
    }
    for (int k=0;k<=sum;k++) System.out.print(s[k]+"  ");
  }

  public void count2(int[] v, int sum) {
    int[] s = new int[sum+1];
    Arrays.fill(s, 10000);
    s[0]=0;
    for (int i=1;i<=sum;i++) {
      for (int j=0;j<v.length;j++) {
        if (v[j]<=i) s[i] = Math.min(s[i], s[i-v[j]]+1);
      }
    }
    for (int k=0;k<=sum;k++) System.out.print(s[k]+"  ");
  }
  public static void main(String args[]) {
    System.out.println("\nV1");
    new CoinCount().count1(new int[]{1,3,5}, 1001);

    System.out.println("\nV2"); 
    new CoinCount().count2(new int[]{1,3,5}, 1001);

  }

}
