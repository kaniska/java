package fb.math;

import java.util.*;

/**
 * @author: mindpower
 * @created: 4/21/12-6:59 PM
 */
public class ValidNumber {
  public boolean isNumber(String s) {
    int n = s.length();
    int i = 0;
    // skip white space
    while (i < n && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
      i++;
    }
    // skip sign
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      i++;
    }
    // must have at least one number before or after .
    boolean hasDigits = false;
    while (i < n && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
      hasDigits = true;
      i++;
    }
    // skip .
    if (i < n && s.charAt(i) == '.') {
      i++;
    }
    while (i < n && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
      hasDigits = true;
      i++;
    }
    if (!hasDigits) {
      return false;
    }
    if (i < n && (s.charAt(i) == 'E' || s.charAt(i) == 'e')) {
      i++;
      // skip sign
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        i++;
      }
      hasDigits = false;
      // check digits after 'e',
      while (i < n && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
        hasDigits = true;
        i++;
      }
      if (!hasDigits) {
        return false;
      }
    }
    // skip white space after number
    while (i < n && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
      i++;
    }
    return i == n;  // if i==n, no remaining char and it's a valid number
  }
}
