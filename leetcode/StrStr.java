package leetcode;

/**
 * @author jbu
 */
public class StrStr {

    public String strStr(String haystack, String needle) {
       int i=0,j=0;
       if (haystack==null || needle==null) return null;
       while (i<haystack.length()-needle.length()+1) {
           j = 0;
           while (j<needle.length()) {
               if (haystack.charAt(i)==needle.charAt(j)) {
                 i++; j++;
               } else {
                 i = i-j+1;
                 break;
               }
           }
           if (j==needle.length()) return haystack.substring(i-j);
       }
       return null;
    }


}
