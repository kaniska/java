package fb.math;

public class AddBinary {
  // simpler @ 05/12/2012
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length()-1, j=b.length()-1;
    int carry = 0;
    while (i>=0 || j>=0) {
      int vi = (i>=0 && a.charAt(i--)=='1')? 1:0;
      int vj = (j>=0 && b.charAt(j--)=='1')? 1:0;
      char s = ((vi+vj+carry) & 1)==0?'0':'1';
      carry = (vi+vj+carry) >> 1;
      sb.append(s);
    }
    if (carry==1) sb.append('1');
    return sb.reverse().toString();
  }

  public String addBinary_OLD(String a, String b) {
    char s[] = new char[Math.max(a.length(), b.length()) + 1];
    int i = a.length() - 1, j = b.length() - 1, k = s.length - 1;
    int a1, b1, carry = 0;
    while (k >= 0) {
      a1 = (i >= 0) ? (a.charAt(i--) - '0') : 0;
      b1 = (j >= 0) ? (b.charAt(j--) - '0') : 0;
      s[k--] = (char) ((a1 ^ b1 ^ carry) + '0');
      carry = (a1 + b1 + carry) >> 1;
    }
    String r = new String(s);
    return (r.charAt(0) == '0' && r.length() > 1) ? r.substring(1) : r;
  }
}