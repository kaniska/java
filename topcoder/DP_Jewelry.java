package topcoder;

import java.util.*;
import static java.lang.Math.*;

public class DP_Jewelry {
  public static void main(String[] args) {
    int s1[] = {1,2,5,3,4,5}; long r1 =9;
    System.out.println(howMany(s1)==r1?"Right":"Wrong,Should="+r1);
    int s2[]= {1000,1000,1000,1000,1000,
       1000,1000,1000,1000,1000,
        1000,1000,1000,1000,1000,
         1000,1000,1000,1000,1000,
          1000,1000,1000,1000,1000,
           1000,1000,1000,1000,1000}; long r2= 18252025766940l;
    System.out.println(howMany(s2)==r2?"Right":"Wrong,Should="+r2); 
    int s3[] = {1,2,3,4,5};  long r3 = 4;
    System.out.println(howMany(s3)==r3?"Right":"Wrong,Should="+r3); 
    int s4[] = {7,7,8,9,10,11,1,2,2,3,4,5,6}; long r4 = 607;
    System.out.println(howMany(s4)==r4?"Right":"Wrong,Should="+r4); 
    int s5[] = {123,217,661,678,796,964,54,111,417,526,917,923}; long r5 = 0;
    System.out.println(howMany(s5)==r5?"Right":"Wrong,Should="+r5); 
  }

  public static long howMany(int[] values) {
    return 0;
  }

}

