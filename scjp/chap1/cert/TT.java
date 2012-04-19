package scjp.chap1.cert;

/**
 * @author jbu
 */


public class TT extends Test1 {

   int a ;
  protected TT(){
    Number [] nn = new Number[3];
    nn[0]= (double) 100;
    nn[1] = 2;
    nn[2] = 12.2d;
    for (Number n: nn)
    System.out.println(n.getClass());

    TT();
    testIt();
    Test1 y = new Test1();
    y.testIt();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TT)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Test1 t1 = (Test1)o;
    t1.testIt();

    TT tt = (TT) o;

    if (a != tt.a) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + a;
    return result;
  }

  synchronized public void TT() {

  }
  public void aa()  {
    testIt();
    Test1 t1 = new Test1();
    t1.bb = 2;
    t1.testIt();
  }

  static ANIMAL animal;
  public static void main(String args[]) {
    new TT();
    Test1 t1 = new Test1();
    t1.bb = 2;
    t1.testIt();
     System.out.println("Animal sound="+animal);

    Test1 a = new TT();
    TT s = (TT)a;


    getA(3);
  }

  Object getShort() {
   return new int[] {1,2};
  }
  @Override
  public int getA() {
 //   return super.getA();    //To change body of overridden methods use File | Settings | File Templates.
    return 0;
  }

  static void getA(Integer A) {System.out.println("Integer");}
  static void getA(Number A) {System.out.println("Number");}


  enum Traffic {RED, GREEN, BLUE}

enum ANIMAL {
  DOG("bark"),
  CAT("miao");

  String sound;
  ANIMAL(String sound) {
    this.sound = sound;
  }
}
}
