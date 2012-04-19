package test111;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author jbu
 */

class Outside {

}

public class Misc {
  private static class AAA {
    int a;
  }

  public static int numberOnesInBinary(int n) {
    int mask = 1, pos=0, total =0;
    while (n!=0 && pos<32) {
    //  pl("[debug] n=",  Integer.toBinaryString(n), "  n&mask=", Integer.toBinaryString(n&mask));

      if ((n & mask) == mask) total++;
      n = n >> 1;   pos++;
    }


    return total;
  }

  public static int numberOnesInBinary_s(int n) {
    int total = 0;
    while (n!=0) {
      n = n & (n-1);
      total++;
    }
    return total;
  }

  public static void pl(Object... msg) {
    p(msg);
    p("\n");
  }

  public static void p(Object... msg) {
    StringBuilder sb = new StringBuilder("");
    for (Object o : msg) {
      if (o != null) {
        sb.append(o);
      } else {
        sb.append("null");
      }
    }
    System.out.print(sb.toString());
  }

  public static void main(String args[]) {
    int[] sample = new int[]{162, 0, -122, 1, -1, 6712312};
    for (int a: sample) {
      String b = Integer.toBinaryString(a);
      pl("a=",a, "; binrary=", b, " | number of 1s=", numberOnesInBinary(a), " | ", numberOnesInBinary_s(a));
    }
    try {
      NumberFormat nf = NumberFormat.getInstance();
      nf.setMaximumFractionDigits(2);
      Number n = nf.parse("989098.90812312323948902384092384902384092384902384902384902384092384902384902384902348139183018390183901839018239018390183901839018390183901839012839012839012839012839012839018239018230912839012830918309183019283190283109830198231223424234242431222222222222222222222222297897897897897987987895");

      System.out.println(nf.format(12.1231312312)+"  " +n.getClass()+"  "+n);
    } catch (ParseException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }
}
