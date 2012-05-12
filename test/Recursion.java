package test;

/**
 * @author jbu
 */
public class Recursion {
  public final static int NOT_FOUND = -1;
  public final static int ARRAY_NOT_SORTED = -2;
  public final static int LIMIT_REVERSED = -3;

  public static void pl(Object... msg) {
    p(msg);
    p("\n");
  }

  public static void p(Object... msg) {
    StringBuilder sb = new StringBuilder("");
    for (Object o : msg) {
      if (o != null) {
        sb.append(o);
      } else {
        sb.append("null");
      }
    }
    System.out.print(sb.toString());
  }

  public static int binarySearch_iter(int data[], int lower, int upper, int target) {
    if (lower > upper) {
      return LIMIT_REVERSED;
    }
    while (lower <= upper) {
      if (lower == upper && target != data[lower]) {
        break;
      }
      int middle = lower + (upper - lower) / 2;
      p("lower=", lower, "; middle=", middle, "; upper=", upper);
      if (target == data[middle]) {
        p("found");
        return middle;
      } else if (target > data[middle]) {
        p("go right");
        lower = middle + 1;
      } else {
        p("go left");
        upper = middle - 1;
      }
    }
    return NOT_FOUND;
  }

  public static int binarySearch(int data[], int lower, int upper, int target) {
    int middle = lower + (upper - lower) / 2;
    p("lower=", lower, "; middle=", middle, "; upper=", upper);
    if (lower > upper) {
      return NOT_FOUND;
    }
    if (lower == upper || lower + 1 == upper) {
      if (data[lower] == target) {
        return lower;
      } else if (data[upper] == target) {
        return upper;
      } else {
        return NOT_FOUND;
      }
    }

    if (target == data[middle]) {
      p("found");
      return middle;
    } else if (target > data[middle]) {
      p("go right");
      return binarySearch(data, middle + 1, upper, target);
    } else {
      p("go left");
      return binarySearch(data, lower, middle - 1, target);
    }
  }

  private static int count = 0;

  public static void permute(String str) {
    char input[] = str.toCharArray();
    char output[] = new char[str.length()];
    boolean used[] = new boolean[str.length()];
    count = 0;
    doPermute(input, output, used, 0);
  }

  public static void doPermute(char[] input, char[] output, boolean used[], int pos) {
    if (pos == input.length) {
      p(String.valueOf(output), " | ");
      if (++count % 10 == 0) {
        p("\n");
      }
    } else {
      for (int i = 0; i < used.length; i++) {
        if (used[i]) {
          continue;
        }
        output[pos] = input[i];
        used[i] = true;
        doPermute(input, output, used, pos + 1);
        used[i] = false;

      }
    }
  }

  public static void combine(String str) {
    char[] input = str.toCharArray();
    char[] output = new char[str.length()];
    count = 0;
    doCombine(input, output, 0, 0);
  }

  public static void doCombine(char[] input, char[] output, int srcPos, int dstPos) {
    int len = input.length;
    if (dstPos < len) {
      for (int i = srcPos; i < len; i++) {
        output[dstPos] = input[i];
        p(String.format("%-5s  | ", String.valueOf(output, 0, dstPos + 1)));
        if (++count % 10 == 0) {
          p("\n");
        }
        doCombine(input, output, i + 1, dstPos + 1);
      }
    }
  }

  public static void printTelephoneWords_Iter(int[] number) {
    int len = number.length;
    char[] result = new char[len];
    int[] curPlace = new int[len];

    for (int i = 0; i < len; i++) {
      result[i] = getCharKey(number[i], 1);
      curPlace[i] = 1;
    }

    count = 0;
    while (true) {
      pl(String.valueOf(result));
      count++;
      for (int p = len - 1; p >= -1; p--) {
        if (p == -1) {
          return;
        }
        if (number[p] == 0 || number[p] == 1) {
          continue;
        }
        if (curPlace[p] == 3) {
          curPlace[p] = 1;
          result[p] = getCharKey(number[p], curPlace[p]);
          continue;
        }
        if (curPlace[p] < 3) {
          curPlace[p]++;
          result[p] = getCharKey(number[p], curPlace[p]);
          break;
        }
      }

    }

  }

  public static void printTelephoneWords(int[] number) {
    char[] result = new char[number.length];
    count = 0;
    doPrintTelephoneWords(number, result, 0);
  }

  final static int PHONE_LENGTH = 7;

  public static void doPrintTelephoneWords(int[] number, char[] result, int pos) {
    if (pos == PHONE_LENGTH) {
      pl(String.valueOf(result));
      count++;
    } else {
      for (int i = 1; i <= 3; i++) {
        result[pos] = getCharKey(number[pos], i);
        doPrintTelephoneWords(number, result, pos + 1);
        if (number[pos] == 0 || number[pos] == 1) {
          break;
        }
      }
    }

  }

  public static char getCharKey(int key, int place) {
    if (key > 9 || key < 0 || place > 3 || place < 1) {
      return '^';
    }
    switch (key) {
      case 0:
      case 1:
        return (char) ('0' + key);
      default:
        return (char) ('A' + (key - 1) * 3 + place - 1);
    }
  }

  public static void main(String args[]) {
    p(">>>>>>>>>>>>>>>>");
    int data[] = new int[]{1, 4, 18, 22, 23, 39, 42, 78, 123, 780, 912, 1233, 1255};
    int index = binarySearch_iter(data, 0, data.length - 1, 1);
    p("Index=", index, " |", index >= 0 ? data[index] : "ERROR");

    permute("Junjie");
    pl("Total Permutation=", count);

    combine("wxyz");
    pl("Total Combination=", count);

    printTelephoneWords(new int[]{1, 2, 1, 0, 0, 7, 5});
    pl("Total Words=", count);

    printTelephoneWords_Iter(new int[]{1, 2, 1, 0, 0, 7, 5});
    pl("Total Words=", count);

  }
}
