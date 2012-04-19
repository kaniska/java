package tc;

/**
 * @author jbu
 */
class Chicks {
  synchronized void yack(long id) {
    for (int i = 1; i < 3; i++) {
      System.out.println(id + "  ");
      Thread.yield();
    }
  }
}
