package fb.string;

import java.util.*;

/**
 * Text Justification
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * <p/>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * <p/>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p/>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p/>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p/>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * <p/>
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 * » Solve this problem
 *
 * @author: mindpower
 * @created: 4/22/12-12:58 PM
 */
public class TextJustification {
  public ArrayList<String> fullJustify(String[] words, int L) {
    int i = 0, n = words.length;
    ArrayList<String> result = new ArrayList<String>();
    int num = 0;
    while (i < n) {
      int start = i;
      num = words[i++].length();
      while (num <= L && i < n) {
        if (num + 1 + words[i].length() > L) {
          break;
        }
        num = num + 1 + words[i++].length();
      }
      int remaining = L - num;
      int numOfWords = (i - start);
      int numOfSpaces = numOfWords - 1;
      StringBuilder sb = new StringBuilder(words[start++]);
      boolean lastLine = (i == n);
      for (int j = 0; j < numOfSpaces; j++) {
        int extra = lastLine ? 1 : 1 + remaining / numOfSpaces + (j < (remaining % numOfSpaces) ? 1 : 0);
        for (int k = 0; k < extra; k++) {
          sb.append(' ');
        }
        sb.append(words[start++]);
      }
      if (numOfSpaces == 0 || lastLine) {
        for (int k = 0; k < remaining; k++) {
          sb.append(' ');
        }
      }
      result.add(sb.toString());
    }
    return result;
  }
}
