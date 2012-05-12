package fb.math;

public class AddBinary {
  public String addBinary(String a, String b) {
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