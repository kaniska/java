package fb.math;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-8:19 AM
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int val = digits[i] + carry;
      digits[i] = val >= 10 ? 0 : val;
      carry = val >= 10 ? 1 : 0;
    }
    if (carry == 0) {
      return digits;
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    for (int i = 0; i < digits.length; i++) {
      result[i + 1] = digits[i];
    }
    return result;
  }
}
