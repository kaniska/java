package leetcode;

/**
 * @author jbu
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i=1;i<n;i++) {
            StringBuilder sb = new StringBuilder();
            int c =0;
            char[] s = str.toCharArray();
            char p =' ';
            for (int j=0;j<s.length;j++) {
                if (s[j]==p) {
                    c++;
                } else {
                    if (p!=' ') {
                      sb.append((char)(c+'0'));
                      sb.append(p);
                    }
                    c = 1;
                    p = s[j];
                }
            }
            sb.append((char)(c+'0'));
            sb.append(p);
            str=sb.toString();
        }
        return str;
    }
}
