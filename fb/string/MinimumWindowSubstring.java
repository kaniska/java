package fb.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p/>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p/>
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * <p/>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p/>
 * /
 * <p/>
 * public class MinimumWindowSubstring {
 * <p/>
 * /**
 * Improvements:
 * http://www.lc.com/2010/11/finding-minimum-window-in-s-which.html
 * (1) Use array map instead of hash map  (since we only deal with 255 chars)
 * (2) Use additional count to check if current windows contains all char in T, instead of iterating though the map
 * (3) Now its only O(n)
 * (4) We use an additional deque to track positions for only those elements in T
 */
public class MinimumWindowSubstring {
  // 05/18/2012 simple version without using queue,
  // just search from start to remove chars not needed, so total time O(2*n)
  public String minWindowSimple(String S, String T) {
    int[] needFind = new int[256];
    int[] hasFound = new int[256];
    int n = T.length();
    if (n == 0) return "";
    for (int i = 0; i < n; i++) needFind[T.charAt(i)]++;
    int count = 0;
    int start = 0;
    int min = Integer.MAX_VALUE;
    String minString = "";
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (needFind[c] == 0) continue;
      hasFound[c]++;
      if (hasFound[c] <= needFind[c]) count++;
      if (count < n) continue;
      while (true) {
        char s = S.charAt(start);
        if (needFind[s] != 0 && needFind[s] >= hasFound[s]) break;
        start++;
        hasFound[s]--;
      }
      if (i - start + 1 < min) {
        min = i - start + 1;
        minString = S.substring(start, i + 1);
      }
    }
    return minString;
  }

  String minWindow(String S, String T) {
    Deque<Integer> d = new ArrayDeque<Integer>();
    int[] needToFind = new int[256];
    int[] hasFound = new int[256];
    for (int c : T.toCharArray()) {
      needToFind[c]++;
    }
    int min = Integer.MAX_VALUE;
    String s = "";
    int n = T.length(), count = 0;
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (needToFind[c] <= 0) {
        continue;
      }
      d.addLast(i);
      hasFound[c]++;
      if (hasFound[c] <= needToFind[c]) {
        count++;
      }
      if (count < n) {
        continue;
      }
      while (!d.isEmpty()) {
        char x = S.charAt(d.peekFirst());
        if (needToFind[x] >= hasFound[x]) {
          break;
        }
        d.removeFirst();
        hasFound[x]--;
      }
      if (i - d.peekFirst() < min) {
        min = i - d.peekFirst();
        s = S.substring(d.peekFirst(), i + 1);
      }
    }
    return s;
  }

  private boolean containsAll(Map<Character, Integer> m) {
    for (int i : m.values()) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }

  public String minWindow1(String S, String T) {
    Deque<Integer> d = new ArrayDeque<Integer>();
    Map<Character, Integer> h = new HashMap<Character, Integer>();
    for (char c : T.toCharArray()) {
      if (h.containsKey(c)) {
        h.put(c, h.get(c) + 1);
      }
      else {
        h.put(c, 1);
      }
    }
    int min = Integer.MAX_VALUE;
    String s = "";
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (h.containsKey(c)) {
        d.addLast(i);
        h.put(c, h.get(c) - 1);
        while (!d.isEmpty() && h.get(S.charAt(d.peekFirst())) < 0) {
          int f = d.removeFirst();
          h.put(S.charAt(f), h.get(S.charAt(f)) + 1);
        }
        if (containsAll(h) && (i - d.peekFirst() < min)) {
          min = i - d.peekFirst();
          s = S.substring(d.peekFirst(), i + 1);
        }
      }
    }
    return s;
  }
}