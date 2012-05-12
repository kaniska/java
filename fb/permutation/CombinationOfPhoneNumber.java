package fb.permutation;

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
        }
        else {
          current[i] = (char) (current[i] + 1);
          break;
        }
      }
      if (i == -1) {
        break;
      }
    }
    return s;
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

}
