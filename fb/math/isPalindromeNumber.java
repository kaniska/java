package fb.math;

/**
 * @author jbu
 */


public class isPalindromeNumber {

//      public boolean isPalindrome(int x) {
//        if (x<0) return false;
//        if (x<10) return true;
//        int m = 10;
//        while (x/m>=10) m*=10;
//
//        while (x>0) {
//            if (x/m!=x%10) return false;
//            x = x-(x/m)*m;
//            x = x/10;
//            m/=100;
//        }
//        return true;
//    }

  // x-(x/m)*m  ----> x%m
  // be careful of negative number, also overflow when getting minimum d;
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int d = 1;
    while (x / d >= 10) d *= 10;
    // d/=10;
    while (x > 0) {
      if (x / d != x % 10) return false;
      x = x % d / 10;
      d = d / 100;
    }

    return true;
  }

}
