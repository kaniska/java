package SCJP6;

/**
 * @author jbu
 */
public class MyConsole {
  enum Suits {
    CLUBS(20), DIAMOND(20), HEARTS(30), SPADES(30), NOTRUMP(40) {
      public int getValue(int bid) { return (bid-1)*30+40; } };
    Suits(int points) {this.points = points; }
    private int points;
    public int getValue(int bid) { return points * bid; }
  }

  class AA  {
    private int t = 12;
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o).append(" ");
    }
    System.out.println(sb.toString());
  }

  static <T> T doSomething2() {
    Object o = new MyConsole();
    return (T)o;
  }

  static <T> T doSomething(Class<T> cls) {
   Object o = new MyConsole();
   // snip
   return cls.cast(o);
}

  public static void main(String args[]) {
    p(Suits.NOTRUMP.getValue(3));
    p(Suits.SPADES, " ", Suits.SPADES.points);
    p(Suits.values());
    p(((new MyConsole()).new AA()).t);
    MyConsole m = doSomething2();
    p("m=",m);
    MyConsole m2 = doSomething(MyConsole.class);
    p("m2=",m2);

/*    Console c = System.console();
    char[] pw = c.readPassword("%s %d:", "please input pwd", 12);
    for (char ch: pw) {
      c.format("%c ", ch);
    }
    c.format("\n");
    while (true) {
       String s = c.readLine("Please input a string:   ");
       c.format("Output: %s\n", s);
      if (s.isEmpty()) break;
     }  //*/

  }

}
