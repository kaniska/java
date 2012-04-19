package fb.interview;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jbu
 */
public class TestRegex {
  private static final Pattern p = Pattern.compile("(52(5|8))|(5[3-9][0-9])");

  public static void main(String args[]) {
    Console c = System.console();
    String s;
    while (!(s=c.readLine()).equals("")) {
      Matcher m = p.matcher(s);
      System.out.println(m.matches());
    }
  }


}
