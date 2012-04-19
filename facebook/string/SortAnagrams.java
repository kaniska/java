package facebook.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jbu
 */
public class SortAnagrams {
   static class StringComparator implements Comparator<String> {


     /*
      * @param o1 the first object to be compared.
      * @param o2 the second object to be compared.
      * @return a negative integer, zero, or a positive integer as the
      *         first argument is less than, equal to, or greater than the
      *         second.
      * @throws ClassCastException if the arguments' types prevent them from
      *                            being compared by this comparator.
      */
     public int compare(String o1, String o2) {
       char[] c1= o1.toCharArray();
       char[] c2 = o2.toCharArray();
       Arrays.sort(c1);
 //      System.out.println(new String(c1));
       Arrays.sort(c2);
  //     System.out.println(new String(c2));

       // we have to use the same comparision, remember there is also sorting,
       // if we sort using string, the order might be wrong and we can never find the match
       return new String(c1).compareTo(new String(c2));
//       if (Arrays.equals(c1,c2)) return 0;
//       return o1.compareTo(o2);
     }
   }

  public static void main(String args[]) {
    String[] s = {"Occasional nude income", "Hello", "Water", "Madonna Louise Ciccone", "olleH", "lleoH", "One cool dance musician",
    "i am a weakish speller","Junjie","william shakespeare","serious or skilled anagrammatists"};

//    String[] s = {"Hello", "Google", "Welcome", "olleH","elgooG"};
    Arrays.sort(s, new StringComparator());
    System.out.println(Arrays.toString(s));
  }

}
