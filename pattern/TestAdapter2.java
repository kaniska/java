package pattern;

/**
 * @author jbu
 */
public class TestAdapter2 {

  static void Jobs (Extra job) {
      if (job instanceof Clean)
          ((Clean)job).makeClean();
      if (job instanceof Extra)
          ((Extra)job).takeCare();
  }
  public static void main(String[] args) {
      Extra e = new Facility();
      Jobs(e);
      Clean c1 = new Office();
      Clean c2 = new Workshop();
      c1.makeClean();
      c2.makeClean();
      e.makeClean();
  }

}


interface Clean {
    public void makeClean();
}
class Office implements Clean{
    public void makeClean() {
        System.out.println("Clean Office");
    }
}
class Workshop implements Clean{
    public void makeClean() {
        System.out.println("Clean Workshop");
    }
}

interface Extra extends Clean{
    public void takeCare();
}
class Facility implements Extra{
    public void makeClean() {
        System.out.println("Clean Facility");
    }
    public void takeCare() {
        System.out.println("Care has been taken");
    }
}
