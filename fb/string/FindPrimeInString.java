package fb.string;

/**
 * @author jbu
 */
public class FindPrimeInString {
  public static void find(String s) {
//    String [] numbers = s.split("\\D+");
//    System.out.println(Arrays.toString(numbers));
//    for (String n: numbers) {
//      if (n.length()>0) {
//        printAllPrimes(n);
//      }
//    }
    int start = -1;
    int i = 0, end;
    while (i < s.length()) {
      while (i < s.length() && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
        i++; // i at number now
      }
      if (i >= s.length()) {
        break;
      }
      start = i;
      end = start;
      while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
        end++;
      }
      printAllPrimes(s.substring(start, end));
      i = end + 1;
    }
  }

  private static void printAllPrimes(String n) {
    int x;
    for (int i = 0; i < n.length(); i++) {
      x = 0;
      for (int j = i; j < n.length(); j++) {
        x = x * 10 + (n.charAt(j) - '0');
        if (isPrime(x)) {
          System.out.println(x);
        }
      }
    }
  }

  private static boolean isPrime(int i) {
    if (i == 1) {
      return false;
    }
    if (i == 2 || i == 3 || i == 5 || i == 7) {
      return true;
    }
    for (int k = 2; k < i; k++) {
      if (i % k == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    find("abc2134kd31");
  }
}
