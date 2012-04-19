package scjp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author jbu
 */
public class PrivateMethod {
  public static void main(String args[]) {
    PA pa = new PB();

  }
}

class PA {

  static class PC extends PA {
    void p() {

    }
  }

  final private void p() {
    System.out.println("TA.p");
  }

  public static void main(String args[]) {
    PA a = new PB();
    List<Number> lll =new ArrayList<Number>();

        List<String> l = new Vector();
        List ll = new Vector<String>();
    a.p();
  }
}

interface IF {
}

class PB extends PA {


  void p() {
    StringBuilder sb = new StringBuilder("PAA");
    String s= "PAA";

    PB p = (PB)null;

    try {
    } catch (NullPointerException npe) {
      throw new NullPointerException();
    } catch (Exception e) {

    }

    System.out.println("PB.p");
  }
}

abstract class PAA<K extends Number> {
  public abstract <K> K useMe(Object k);
//  abstract <K> PAA<? extends Number> useMe(PAA<? super K> k);
//  abstract <K> PAA<? super Number> useMe(PAA<? extends K> k);
//  abstract <K> PAA<K> useMe(PAA<K> k);
//  public abstract <V extends K> PAA<V> useMe(PAA<V> k);
//  abstract <V extends Character> PAA<? super V>useMe(PAA<K> k);

}