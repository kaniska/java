package SCJP6.test;

/**
 * @author jbu
 */
public class Q100_82 {
  public static void main(String[] args) {
//    Object o = choose(991, "800");
    Double n1 = Q100_82.<Double>choose(991.4, 3.14);
     Number n2 = Q100_82.<Double> choose((double) 991, 3.14);
    int k = (int) choose(1, 3);
    int l = (int) (double) choose(1.3, 3.14);
  }

  // (1) // (2) // (3) // (4) // (5)
  public static <T extends Comparable<T>> T choose(T t1, T t2) {
    return t1.compareTo(t2) >= 0 ? t1 : t2;
  }
}