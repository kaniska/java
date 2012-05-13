package fb.permutation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author jbu
 */
public interface PhoneNumberWords {
  public ArrayList<String> letterCombinations(String digits);
  public final static char[][] charKey = {
      {'0'},
      {'1'},
      {'a', 'b', 'c'},     //2
      {'d', 'e', 'f'},     //3
      {'g', 'h', 'i'},     //4
      {'j', 'k', 'l'},     //5
      {'m', 'n', 'o'},     //6
      {'p', 'q', 'r', 's'},//7
      {'t', 'u', 'v'},     //8
      {'w', 'x', 'y', 'z'} //9
  };
}

class PhoneNumberWordsTest {
  public static void main(String[] args) {
    PhoneNumberWords p = new PhoneNumberWordsIterative();
    ArrayList<String> result = p.letterCombinations("2856938");
    int i = 0;
    Iterator<String> it = result.iterator();
    String[] selected = new String[1];
    Random r = new Random();
    while (it.hasNext()) {
      i++;
      String s = it.next();
      int n = r.nextInt(i);
      if (n<1) selected[n%1]=s;
    }
    for (String s: selected) {
      System.out.print(s+'\t');
    }
  }
}

class PhoneNumberWordsRecursive implements  PhoneNumberWords {
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
}

class PhoneNumberWordsIterative implements  PhoneNumberWords{
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

}
