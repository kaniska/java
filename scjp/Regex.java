package scjp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jbu
 */
public class Regex {
  public static void main(String args[]) {
    if (args.length<2) return;
    Pattern p = Pattern.compile(args[0]);
    Matcher m = p.matcher(args[1]);

    p("Pattern=", args[0], "; matcher=", args[1]);
    while (m.find()) {
      p(m.start(),"-", m.end(), "   ", m.group());
    }
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o);
    }
    System.out.println(sb.toString());
  }
}
