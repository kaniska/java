package facebook.array;

import java.util.Arrays;

/**
 * @author jbu
 */
public class RemoveZeroInArray {
  public static int[] remove(int[] a) {
    int i = 0, j = a.length - 1;
    int last = -1;
    int temp;
    while (i < j) {
      while (a[i]!=0) i++;
      last = i-1;
      if (i>j) break;
      while (a[j]==0) j--;
      if (i>j) break;
      temp = a[j];
      a[j]=a[i];
      a[i]=temp;
      last = i;
      i++;j--;
    }
    return Arrays.copyOfRange(a, 0, last+1);
  }

  public static void main(String args[]) {
    System.out.println(Arrays.toString(remove(new int[]{0,2,3,0,4,0,5,0,1,0})));
  }

}
