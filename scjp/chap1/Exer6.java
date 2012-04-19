package scjp.chap1;

/**
 * @author jbu
 */
public class Exer6 {
}

class Electronics implements iDevice {
  public void doIt() { }
}

abstract class Phone1 extends Electronics {}
abstract class Phone2 extends Electronics {
  public void doIt(int X) {}
}

class Phone3 extends Electronics implements iDevice {
  public int count(int x, int y) {return x+y;}
  public void a() {
    Short a =3;
    count(a, 3);
  }

}


interface iDevice {
  public void doIt();
}
