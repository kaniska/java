package scjp;

import java.util.Scanner;

/**
 * @author jbu
 */
public class ScanIn {
  public static void main(String args[]) {
    String a =" Hello 123 dase3d,qwe23sdadds";
    String []sp = a.split("\\d");
    for (String as:sp) {
      p("[",as,"]");
    }
    p("Please input:");
    Scanner s  = new Scanner(System.in);
    String tk;
    do {
      tk = s.findInLine(args[0]);
      p("found ",tk);
    } while (tk!=null);

    Integer i = 345;
    long l = 345l;
    if (i.equals(345)) p("TA");
    if (i.equals(l)) p("TB");
    if (i==l) p("C");
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o);
    }
    System.out.println(sb.toString());
  }
}
