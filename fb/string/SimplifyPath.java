package fb.string;

import java.util.*;

public class SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> d = new ArrayDeque<String>();
    String[] p = path.split("/");
    for (String s : p) {
      if (s.equals("..")) {
        if (!d.isEmpty()) {
          d.removeLast();
        }
      }
      else if (s.length() == 0 || s.equals(".")) {
        continue;
      }
      else {
        d.addLast(s);
      }
    }
    StringBuffer sb = new StringBuffer();
    while (!d.isEmpty()) {
      sb.append("/").append(d.removeFirst());
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }
}
