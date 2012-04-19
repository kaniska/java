package lc;

import java.util.*;

/**
 * @author jbu
 * @since 3/23/12 4:29 PM
 */
public class Anagrams {
  public ArrayList<String> anagrams(String[] strs) {
    Map<String, List<String>> m = new HashMap<String, List<String>>();
    ArrayList<String> result = new ArrayList<String>();
    if (strs == null || strs.length == 0) return result;
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String ss = new String(c);
      if (m.containsKey(ss)) m.get(ss).add(s);
      else {
        ArrayList<String> one = new ArrayList<String>();
        one.add(s);
        m.put(ss, one);
      }
    }

    for (Map.Entry<String, List<String>> e : m.entrySet()) {
      if (e.getValue().size() > 1) result.addAll(e.getValue());
    }

    return result;
  }

}
