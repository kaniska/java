package fb.string;

import java.util.*;

/**
 * @author jbu
 */
public class SubstringWithConcatenationWords {
  public ArrayList<Integer> findSubstring(String S, String[] L) {
    int n = S.length();
    int m = L[0].length();
    int l = L.length;
    Map<String, Integer> needFind = new HashMap<String, Integer>();
    Map<String, Integer> hasFound = new HashMap<String, Integer>();
    for (int i = 0; i < l; i++) {
      if (!needFind.containsKey(L[i])) {
        needFind.put(L[i], 1);
      }
      else {
        needFind.put(L[i], needFind.get(L[i]) + 1);
      }
    }
    ArrayList<Integer> r = new ArrayList<Integer>();
    int j;
    String w;
    for (int i = 0; i < n - l * m + 1; i++) {
      w = S.substring(i, i + m);
      if (needFind.containsKey(w)) {
        hasFound.clear();
        hasFound.put(w, 1);
        for (j = 1; j < l; j++) {
          w = S.substring(i + j * m, i + (j + 1) * m);
          if (!needFind.containsKey(w)) {
            break;
          }
          Integer v = hasFound.get(w);
          hasFound.put(w, v == null ? 1 : v + 1);
          if (hasFound.get(w) > needFind.get(w)) {
            break;
          }
        }
        if (j == l) {
          r.add(i);
        }
      }
    }
    return r;
  }
}
