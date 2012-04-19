package topcoder;

import java.util.*;
import static java.lang.Math.*;

public class DP_AvoidRoards {
  public static void main(String []args){
    String s1[] = {"0 0 0 1","6 6 5 6"};
    if (numWays(6,6,s1)!=252) System.out.println("Wrong, Should be 252");
    else System.out.println("Correct!");
    String s2[] = {};
    if (numWays(1,1,s2)!=2) System.out.println("Wrong, should be 2");
    else System.out.println("Correct!"); 
    String s3[] = {};
    if (numWays(35,31,s3)!=6406484391866534976l) System.out.println("Wrong, should be 6406484391866534976l");
    else System.out.println("Correct!"); 
    String s4[] = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
    if (numWays(2,2,s4)!=0) System.out.println("Wrong, Should be 0");
   else System.out.println("Correct!"); 
  }

  public static boolean isBadPath(Set s, int x1,int y1, int x2,int y2) {
    String p1 = x1+" "+y1+" "+x2+" "+y2;
    String p2 = x2+" "+y2+" "+x1+" "+y1;
    return (s.contains(p1)||s.contains(p2));
  }

  public static long numWays(int width, int height,String[] bad) {
    Set<String> b = new HashSet<String>();
    for (String s:bad) b.add(s);
    long w[][]= new long [width+1][height+1];
    w[0][0] = 1; 
    for (int i=0;i<=width;i++) 
      for (int j=0;j<=height;j++) {
       if (i>0 && !isBadPath(b,i,j,i-1,j)) 
         w[i][j]+=w[i-1][j];
       if (j>0 && !isBadPath(b,i,j,i,j-1)) 
         w[i][j]+=w[i][j-1];
      }  
    System.out.print(width+" "+height+" "+ Arrays.toString(bad)+
         " ==>"+w[width][height]+"  ");
    return w[width][height];

  }
}
