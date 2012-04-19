package scjp;

import test111.Color;
import static test111.Color.GREEN;

/**
 * @author jbu
 */

interface Foo {
  int bar();
}

public class Sprite {
  public int fubar(Foo foo) {
    return foo.bar();
  }

  public void testFoo() {
    fubar(new Foo() { public int bar() {return 1;}}
      // insert code here
 
    );
  }

 public static void main(String args[]) {
   Color c = GREEN;
 }
}