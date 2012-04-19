package scjp;

import java.util.regex.*;

public class Regex2 {
  public static void main(String[] args) {
    Pattern p = Pattern.compile(args[0]);
    Matcher m = p.matcher(args[1]);
    boolean b = false;
    while ( b=m.find()) {
      System.out.print(m.start()+m.group());
    }
  }
}
