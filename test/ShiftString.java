package test;

public class ShiftString {

  public static String shift(char[] s, int k) {
    int len= s.length;
    reverse(s, 0, len-1);
    reverse(s, 0, len- (k % len)-1);
    reverse(s, len -( k% len), len-1);
    return String.valueOf(s);
  }

  public static void reverse(char[] str, int s, int e) {
    char t;
    for (int i=s; i<= s + e -i; i++) {
      t = str[i];
      str[i] = str[e+s-i];
      str[e+s-i] = t;
    }
  }

  public static void main(String args[]) {
      System.out.println("HelloWorld" + " ==>" +shift("HelloWorld".toCharArray(), 1212));
    System.out.println("Leo is here" + " ==>" +shift("Leo is here".toCharArray(), 6));

  }

}
