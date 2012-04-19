package fb.interview;

/**
 * @author jbu
 */
public class FindMaxSum {
  public static int findMaxSum(int[] a) {
    int currentMax = 0, totalMax = 0;

    for (int i: a) {
      currentMax = (currentMax+i)>0? currentMax+i: 0;
      totalMax = currentMax>totalMax? currentMax:totalMax;
    }

    return totalMax;

  }

  public static void main(String args[]) {
    int s1[] = {-2, 11, -4, 13, -5, -2};
    System.out.println(findMaxSum(s1));

    System.out.println(findMaxSum(new int[]{12}));
    System.out.println(findMaxSum(new int[]{2, -3}));
    System.out.println(findMaxSum(new int[]{2, -3, 19, 2, 21, -12, 54}));

  }


}
