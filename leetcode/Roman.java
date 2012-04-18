package leetcode;

/**
 * @author jbu
 */
public class Roman {
  final static int[] N = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  final static String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String intToRoman(int num) {
    assert (num <= 3999 && num >= 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N.length && num>0; i++) {
      while (num >= N[i]) {
        sb.append(ROMAN[i]);
        num -= N[i];
      }
    }
    return sb.toString();
  }

  public int romanToInt(String s) {
     int pos=0;
     int num = 0;
     for (int i=0;i<N.length;i++) {
        while (pos+i%2<s.length() && s.substring(pos,pos+i%2+1).equals(ROMAN[i])) {
            num+=N[i];
            pos+=i%2+1;
        }
        if (pos==s.length())  break;
     }
     return num;
  }

}
