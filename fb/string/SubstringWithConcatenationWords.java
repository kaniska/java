package fb.string;

import java.util.*;

/**
 * @author jbu
 */
public class SubstringWithConcatenationWords {

  public ArrayList<Integer> findSubstring(String S, String[] L) {
    int len = S.length();
    int m = L[0].length();
    int l = L.length;

    Map<String, Integer> needFind = new HashMap<String, Integer>();
    Map<String, Integer> hasFound = new HashMap<String, Integer>();
    for (int i = 0; i < l; i++) {
      if (!needFind.containsKey(L[i])) needFind.put(L[i], 1);
      else needFind.put(L[i], needFind.get(L[i]) + 1);
    }
    ArrayList<Integer> result = new ArrayList<Integer>();
    int j;
    String sub;
    for (int i = 0; i < len - l * m + 1; i++) {
      sub = S.substring(i, i + m);
      if (needFind.containsKey(sub)) {
        hasFound.clear();
        hasFound.put(sub, 1);
        for (j = 1; j < l; j++) {
          sub = S.substring(i + j * m, i + (j + 1) * m);
          if (!needFind.containsKey(sub)) break;
          Integer v = hasFound.get(sub);
          hasFound.put(sub, v == null ? 1 : v + 1);
          if (hasFound.get(sub) > needFind.get(sub)) break;
        }
        if (j == l) result.add(i);
      }

    }

    return result;

  }

}
