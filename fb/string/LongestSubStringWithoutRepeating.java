package fb.string;

/**
 * @author jbu
 */
public class LongestSubStringWithoutRepeating {

  public static void main(String[] args) {
    System.out.println(new LongestSubStringWithoutRepeating().lengthOfLongestSubstring("inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating"));
  }

  public int lengthOfLongestSubstring(String s) {
    if (s==null) return 0;
    int len = s.length();
    if (len==0) return 0;
    int start = 0;
    int max = 1;
    for (int i=1;i<len;i++) {
      for (int j=i-1;j>=start;j--) {
        if (s.charAt(j)==s.charAt(i)) {
          start = j +1;
          break;
        }
      }
      max = Math.max(max,i-start+1);
    }
    return max;
  }


  public int lengthOfLongestSubstring2(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int start = 0, max = 1;
    for (int i = 1; i < s.length(); i++) {
      for (int k = i - 1; k >= start; k--) {
        if (s.charAt(k) == s.charAt(i)) {
          start = k + 1;
          break;
        }
      }
      max = max > (i - start + 1) ? max : (i - start + 1);
    }
    return max;
  }

  //  04/18/2012 : assume s range ['a'..'z'] , we use boolean map to check if a letter appear before
  public int lengthOfLongestSubstring1(String s) {
    boolean[] m = new boolean[27];
    int start = 0, max = 0;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i) - 'a';
      if (m[x]) {
        while (s.charAt(start) != s.charAt(i)) {
          int p = s.charAt(start) - 'a';
          m[p] = false;
          start++;
        }
        start++;
      }
      else {
        m[x] = true;
      }
      max = max < (i - start + 1) ? (i - start + 1) : max;
    }
    return max;
  }
}
