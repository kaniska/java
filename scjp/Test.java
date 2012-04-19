package scjp;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Test extends TestF implements TestC {

  static void  printCollection(Collection<?> c) {
    for (Object e : c) {
      System.out.println(e);
    }
  }

  Integer i;
  int x;

  public static void main(String args[]) {
    Double i1 = new Double(2);
    Double i2 = new Double("5");
    System.out.println(i1 + i2);

    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(4);
    nf.setMinimumFractionDigits(2);
    String a = nf.format(3.1415426);
    String b = nf.format(1);
    System.out.println("TA=" + a + "|TB=" + b);
    String test = "Test TA. Test TB. Test C";
    String r = ".s*";
    String sp[] = test.split(r);
    NumberFormat.getCurrencyInstance(Locale.getDefault());
    Locale l = Locale.ENGLISH;

    System.out.println(l.getDisplayName(Locale.GERMANY));
    Test t = new Test();
//    System.out.println(t.i+3);

    List ld = new LinkedList<Driver>();
    ld.add(new Person());
    ld.add(new Driver());
    ld.add(new Person());
    List lp = ld;
    List<? super Driver> ll = ld;
    List<? super Person> la = ld;
    la.add(new Person());
    la.add(new Driver());

    ll.add(new Driver());

    printCollection(ll);
//    ll.add(new Person());
    int i, j;
    for (i = 0; i < 2; i++) {
      inner:
      for (j = i; j < 3; j++) {
        if (i != j) {
          break inner;
        }
      }
      System.out.println("i=" + i + ";j=" + j);

    }

    Color c1 = Color.RED;
    Color c2 = Color.RED;
    System.out.println("c1=c2" + (c1 == c2));

    String s = String.valueOf(122);

  }
}


