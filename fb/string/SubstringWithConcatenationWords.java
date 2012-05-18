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

  /**
   * 05/17/2012
   */
  public ArrayList<Integer> findSubstring2(String S, String[] L) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    HashMap<String, Integer> needFind = new HashMap<String, Integer>();
    HashMap<String, Integer> hasFound = new HashMap<String, Integer>();
    int m=S.length(), n = L.length, len = L[0].length();
    for (int i = 0; i < n; i++) {
      Integer count = needFind.get(L[i]);
      needFind.put(L[i], count == null ? 1 : count + 1);
    }
    for (int i = 0; i < m - n * len + 1; i++) {
      if (needFind.containsKey(S.substring(i, i + len))) {
        hasFound.clear();
        hasFound.put(S.substring(i, i + len), 1);
        int j = 0;
        for (j = i + len; j < i + n * len; j += len) {
          String sub = S.substring(j, j + len);
          if (!needFind.containsKey(sub)) break;
          Integer count = hasFound.get(sub);
          hasFound.put(sub, count == null ? 1 : count + 1);
          if (hasFound.get(sub) > needFind.get(sub)) break;
        }
        if (j == i + n * len) result.add(i);
      }
    }
    return result;
  }
}
