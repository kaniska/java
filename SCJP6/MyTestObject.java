package SCJP6;

/**
 * @author jbu
 */
class MyTestObject {
  int a;

  MyTestObject(int a) {
    this.a = a;
  }

  public boolean equals(MyTestObject m) {
    System.out.println("Equals MyTest called");
    return true;
  }

  @Override
  public boolean equals(Object o) {
    System.out.println("equals object called");
    return false;
  }

  @Override
  public int hashCode() {
    System.out.println("HashCode called");
    return 1;
  }
}
