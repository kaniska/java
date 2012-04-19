package cc;

import java.util.HashSet;

/**
 * @author jbu
 */
public class C1_StringArray {

  /**
   * 1.1 a
   * @param str
   * @return
   */
  public static boolean ifRepeated(String str) {
    HashSet<Character> h = new HashSet<Character>();
    for (char c: str.toCharArray()) {
      if (h.contains(c)) return true;
      else h.add(c);
    }
    return false;
  }

  /**
   * 1.1 b
   * @param str
   * @return
   */
  public static boolean ifRepeated2(String str) {
    char c[] = str.toCharArray();
    for (int i=0;i<c.length; i++)
      for (int j=i+1;j<c.length;j++)
        if (c[i]==c[j]) return true;
    return false;
  }

  /**
   * 1.2
   * @param str
   * @return
   */
  public static String reverseCStyle(String str) {
    char [] c = str.toCharArray();
    char t;
    for (int i=0;i<(c.length-1)/2; i++) {
      t = c[i];
      c[i]= c[c.length-1-i-1];
      c[c.length-1-i-1] = t;
    }
    return new String(c);
  }

  public static void removeDuplicate(final char[] str) {
    if (str==null || str.length==1) return;
    int cur = 1;
    for (int i=1; i<str.length; i++) {
      boolean dup = false;
      for (int j=0;j<cur; j++) {
        if (str[i]==str[j]) {
          dup = true;
          break;
        }
      }
      if (!dup) str[cur++] = str[i];
    }

    for (int k=cur;k<str.length;k++) str[k]='\0';
  }


  public static void removeDuplicate2(final char[] str) {
    if (str==null || str.length==1) return;
    boolean[] hit = new boolean[256];
    int cur = 0;
    for (int i=0;i<str.length; i++) {
      if (!hit[str[i]]) {
        str[cur++] = str[i];
        hit[str[i]]=true;
      }
    }
    for (int i=cur;i<str.length;i++) str[cur++]='\0';
  }

  public static void p(Object ...s) {
    StringBuffer sb = new StringBuffer();
    for (Object o: s) {
      sb.append(o);
    }
    System.out.println(sb.toString());
  }

  public static void main(String args[]) {
    p(ifRepeated2("Hello World"));
    p(ifRepeated2("This World"));

    p("Hello World\0", "==>",reverseCStyle("Hello World\0"));
    p("Great\0", "==>",reverseCStyle("Great\0"));
    p("abcd\0", "==>",reverseCStyle("abcd\0"));

    char[] c1 = "Hello World-HGello World".toCharArray(); removeDuplicate2(c1); p(new String(c1));
    char[] c2 = "aaaaaabbbb".toCharArray(); removeDuplicate2(c2); p(new String(c2));
    char[] c3 = "abcd".toCharArray(); removeDuplicate2(c3); p(new String(c3));
    char[] c4 = "ababababa".toCharArray(); removeDuplicate2(c4); p(new String(c4));


  }
}
