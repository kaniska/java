package leetcode;

/**
 * @author jbu
 */
public class LongestSubStringWithoutRepeating {

      public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        int start=0, max=1;
        for (int i=1;i<s.length();i++) {
            for (int k=i-1;k>=start;k--) {
                if (s.charAt(k)==s.charAt(i)) {
                    start = k+1;
                    break;
                }
            }
            max = max>(i-start+1)? max:(i-start+1);

        }
        return max;
    }

}
