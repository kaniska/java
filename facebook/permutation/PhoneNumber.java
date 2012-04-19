package facebook.permutation;

/**
 * @author jbu
 */
public class PhoneNumber {
  public static void main(String args[]) {
    long t= System.currentTimeMillis();
    printPhoneWords(new int[]{2,8,5,6,9,3,8, 9, 5, 2});
    System.out.println(count);
    p(System.currentTimeMillis() - t, "ms");
    char[] aaa = new char[10];
    System.out.println(aaa);

  }

  public static void printPhoneWords(int[] number) {
    char[] result = new char[number.length];
    doPrintPhoneWords(number,0, result);
  }

  static int count=0;

  private static void doPrintPhoneWords(int[] number, int pos, char[] result) {
    if (pos==number.length) {
      if (count++<10)
      System.out.println(result);
      return;
    }
    for (int i=0;i<3;i++) {
      result[pos]= getCharKey(number[pos],i);
      doPrintPhoneWords(number, pos+1, result);
      if (number[pos]<2) break;
    }
  }

  static char[][] charKey = {
    {'0'},
    {'1'},
    {'A','B','C'},
    {'D','E','F'},
    {'G','H','I'},
    {'J','K','L'},
    {'M','N','O'},
    {'P','R','S'},
    {'T','U','V'},
    {'W','X','Y'}
  };

  private static char getCharKey(int num, int n) {
    return charKey[num][n];
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o);
    }
    System.out.println(sb.toString());

  }
}
