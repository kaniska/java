package facebook.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbu
 */
public class LargestCommonString {
  public static List<String> find(String a, String b) {
    int m=a.length(), n=b.length();
    int[][] L = new int[m][n];
    int max =0;
    List<String> result = new ArrayList<String>();
    for (int i=0;i<m;i++)
      for (int j=0;j<n;j++) {
        if (a.charAt(i)==b.charAt(j)) {
          if (i==0 || j==0) L[i][j]=1;
          else L[i][j]=L[i-1][j-1]+1;
          if (L[i][j]>max) {
            max=L[i][j];
            result.clear();
          }
          if (L[i][j]==max){
            result.add(a.substring(i-max+1,i+1));
      //      System.out.println(result.get(0).length());
          }

        } else {
          L[i][j]=0;
        }

      }
//    System.out.println(result.size());
    return result;
  }


  public static void main(String args[]) {
    System.out.println(find("A survey of longest-common subsequence algorithms", "Help can you find any long-commonanimal in the subseqzoon?"));
  }
}
