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