package leetcode;
import java.util.*;

/**
 * Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * /

public class MinimumWindowSubstring {

    /**
     * Improvements:
     * http://www.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
     * (1) Use array map instead of hash map  (since we only deal with 255 chars)
     * (2) Use additional count to check if current windows contains all char in T, instead of iterating though the map
     * (3) Now its only O(n) 
     * (4) We use an additional deque to track positions for only those elements in T
     * 
     */
    public String minWindow(String S, String T) {
        Deque<Integer> d = new ArrayDeque<Integer>();
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        for (int c:T.toCharArray()) needToFind[c]++;
        
        int min = Integer.MAX_VALUE;
        String s = "";
        int n=T.length(), count=0;
        for (int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if (needToFind[c]<=0) continue;
            d.addLast(i);
            hasFound[c]++;
            if (hasFound[c]<=needToFind[c]) count++;
            if (count<n) continue;
            while (!d.isEmpty()) {
                char x = S.charAt(d.peekFirst());
                if (needToFind[x]>=hasFound[x]) break;
                d.removeFirst();
                hasFound[x]--;
            }
            if (i-d.peekFirst()<min) {
                min = i-d.peekFirst();
                s = S.substring(d.peekFirst(),i+1);
            }    
        }
        return s;
    }

    private boolean containsAll(Map<Character,Integer> m) {
        for (int i:m.values()) {
            if (i>0) return false;
        }
        return true;
    }
    
    
    public String minWindow(String S, String T) {
        Deque<Integer> d = new ArrayDeque<Integer>();
        Map<Character, Integer> h = new HashMap<Character,Integer>();
        for (char c:T.toCharArray()) {
            if (h.containsKey(c)) h.put(c, h.get(c)+1);
            else h.put(c,1);
        }
        int min = Integer.MAX_VALUE;
        String s = "";
        for (int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if (h.containsKey(c)) {
                d.addLast(i);
                h.put(c, h.get(c)-1);        
                while (!d.isEmpty() && h.get(S.charAt(d.peekFirst()))<0) {
                    int f = d.removeFirst();
                    h.put(S.charAt(f), h.get(S.charAt(f))+1);
                }
                if (containsAll(h) && (i-d.peekFirst()<min)) {
                    min = i-d.peekFirst();
                    s = S.substring(d.peekFirst(),i+1);
                }
            }
            
        }
        return s;
    }
}