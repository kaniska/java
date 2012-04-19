package SCJP6;

import java.io.File;

import static java.lang.System.out;

/**
 * @author jbu
 */
class _ {
  _() {
  }

  static public void main(String... __A_V_) {
    String $ = "";
    for (int x = 0; ++x < __A_V_.length;) {
      $ += __A_V_[x];
    }
    out.println($);
    assert (false);

    int i = 3;
    int j = 4;
    int z = j = i;
    System.out.println(i + "  " + j + "  " + z);
    try {
      File f = new File("a.txt");
      f.createNewFile();
    } catch (Throwable t) {

    }

  }
}

class Digit {
  public void print() {
  }

  int a =3;
  ;
  ;

}

abstract class AAA {
  abstract void t();
}