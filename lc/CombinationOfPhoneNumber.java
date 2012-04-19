package lc;

import java.util.ArrayList;

/**
 * @author jbu
 */
public class CombinationOfPhoneNumber {
  public ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> s = new ArrayList<String>();
    char[] current = new char[digits.length()];
    for (int i = 0; i < current.length; i++) {
      current[i] = charKey[digits.charAt(i) - '0'][0];
    }
    int i;
    while (true) {
      s.add(new String(current));
      for (i = digits.length() - 1; i >= 0; i--) {
        int n = digits.charAt(i) - '0';
        if (current[i] == charKey[n][charKey[n].length - 1]) { // already max {
          current[i] = charKey[n][0];
        } else {
          current[i] = (char) (current[i] + 1);
          break;
        }
      }
      if (i == -1) break;
    }
    return s;
  }


  // this won't work since the charKey does not always contains 3 keys
  public ArrayList<String> letterCombinations1(String digits) {
    // Start typing your Java solution below
    // DO NOT write main() function
    char[] cur = new char[digits.length()];
    for (int i = 0; i < digits.length(); i++) cur[i] = getKey(digits.charAt(i) - '0', 0);
    ArrayList<String> result = new ArrayList<String>();
    while (true) {
      result.add(new String(cur));
      int k;
      for (k = cur.length - 1; k >= 0; k--) {
        if (cur[k] == '0' || cur[k] == '1' || cur[k] == getKey(digits.charAt(k) - '0', 2)) {
          cur[k] = getKey(digits.charAt(k) - '0', 0);
          continue;
        } else if (cur[k] == getKey(digits.charAt(k) - '0', 0)) cur[k] = getKey(digits.charAt(k) - '0', 1);
        else cur[k] = getKey(digits.charAt(k) - '0', 2);
        break;
      }
      if (k == -1) break;
    }

    return result;
  }


  char[][] charKey = {
      {'0'},
      {'1'},
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'},
      {'j', 'k', 'l'},
      {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'},
      {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'}
  };

  private char getKey(int n, int i) {
    return charKey[n][i];
  }


}
