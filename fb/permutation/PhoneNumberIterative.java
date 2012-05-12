package fb.permutation;

/**
 * @author jbu
 */
public class PhoneNumberIterative {
  public static void main(String args[]) {
    long t = System.currentTimeMillis();
    printPhoneWords(new int[]{2, 8, 5, 6, 9, 3, 8});
    System.out.println(count);
    p(System.currentTimeMillis() - t, "ms");
  }

  public static void printPhoneWords(int[] number) {
    char[] result = new char[number.length];
    for (int i = 0; i < number.length; i++) {
      result[i] = getCharKey(number[i], 0);
    }
    boolean finished = false;
    while (!finished) {
      if (count++ < 10) {
        System.out.println(result);
      }
      for (int j = number.length - 1; j >= -1; j--) {
        if (j == -1) {
          finished = true;
          break;
        }
        if (result[j] == getCharKey(number[j], 2) || number[j] < 2) {
          result[j] = getCharKey(number[j], 0);
        }
        else if (result[j] == getCharKey(number[j], 1)) {
          result[j] = getCharKey(number[j], 2);
          break;
        }
        else { // 0
          result[j] = getCharKey(number[j], 1);
          break;
        }
      }
    }
  }

  static int count = 0;

  static char[][] charKey = {
      {'0'},
      {'1'},
      {'A', 'B', 'C'},
      {'D', 'E', 'F'},
      {'G', 'H', 'I'},
      {'J', 'K', 'L'},
      {'M', 'N', 'O'},
      {'P', 'R', 'S'},
      {'T', 'U', 'V'},
      {'W', 'X', 'Y'}
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
