package lc;

import java.util.ArrayList;

/**
 * @author jbu
 */
public class CombinationOfPhoneNumberRecursive {
  public ArrayList<String> letterCombinations(String digits) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> result = new ArrayList<String>();
    doLetterCombination(digits, 0, new char[digits.length()], result);
    return result;
  }

  private void doLetterCombination(String digits, int pos, char[] letters, ArrayList<String> result) {
    if (pos == digits.length()) {
      result.add(new String(letters));
      return;
    }
    int key = digits.charAt(pos) - '0';
    for (int i = 0; i < charKey[key].length; i++) {
      letters[pos] = charKey[key][i];
      doLetterCombination(digits, pos + 1, letters, result);
    }

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
