package test;

/**
 * @author jbu
 */

public class Complex<T> {

  private T re;
  private T im;

  public Complex(T re, T im) {
    this.re = re;
    this.im = im;
  }

  public T getReal() {
    return re;
  }

  public int method(int ...x) {
// do something
  return 0;
  }

  public int method(int y, int...x) {
// do something
    return 0;
  }


  public T getImage() {
    return im;
  }

  public String toString() {
    return "(" + re + ", " + im + ")";
  }

/*  public double getModulus() {
         return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
  } //*/

  public static void main(String args[]) {
    Complex<Integer> c = new Complex<Integer>(new Integer(3), new Integer(4));
    Complex<String> s = new Complex<String>("hello", "world");
    System.out.println(c);
    System.out.println(s);
//    c.method(2, 3);

  }

}

