package facebook.array;

import java.util.Arrays;

/**
 * @author jbu
 */
public class RotateArray {
  public static void rotate(char[] s, int k) {
    for (int i=0;i<k;i++) {
      char t = s[i];
      for (int j=i;j<s.length;j+=k) {
        s[j]=(j+k)<s.length? s[j+k]:t;
      }
      System.out.println(Arrays.toString(s));
    }
  }

  public static void reverse(char[] s, int l, int u) {
    for (int i=l;i<=(l+u)/2;i++) {
      char t = s[i];
      s[i]=s[l+u-i];
      s[l+u-i]=t;
    }
  }

  public static void rotate2(char[] s, int k) {
    reverse(s, 0, s.length-1);
    reverse(s, 0, s.length-k-1);
    reverse(s, s.length-k, s.length-1);
  }

  public static void main(String args[]) {
    char[] s= "abcdefghijk".toCharArray();
    System.out.println(Arrays.toString(s));
     rotate(s,3);
    System.out.println(Arrays.toString(s));
  }
}
