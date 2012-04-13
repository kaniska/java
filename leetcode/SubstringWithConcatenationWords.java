package leetcode;

import java.util.*;

/**
 * @author jbu
 */
public class SubstringWithConcatenationWords {

      public ArrayList<Integer> findSubstring(String S, String[] L) {
       int len=S.length();
       int m = L[0].length();
       int l = L.length;

       Map<String,Integer> count = new HashMap<String, Integer>();
       Map<String,Integer> found = new HashMap<String, Integer>();
       for (int i=0;i<l;i++) {
           if (!count.containsKey(L[i])) count.put(L[i],1);
           else count.put(L[i],count.get(L[i])+1);
       }
       ArrayList<Integer> result = new ArrayList<Integer>();
       int j; String sub;
       for (int i=0;i<len-l*m+1;i++) {
           sub = S.substring(i,i+m);
           if (count.containsKey(sub)) {
               found.clear();
               found.put(sub,1);
               for (j=1;j<l;j++) {
                   sub = S.substring(i+j*m,i+(j+1)*m);
                   if (!count.containsKey(sub)) break;
                   Integer v = found.get(sub);
                   found.put(sub,v==null? 1: v+1);
                   if (found.get(sub)>count.get(sub)) break;
               }
               if (j==l) result.add(i);
           }

       }

       return result;

    }

}
