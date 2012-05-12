package fb.permutation;

import java.util.HashMap;

/**
 * @author jbu
 */
public class CoinCount {
  static class CoinFaces {
    boolean[] faces;
    int numberOfTrue;
    double probability = 1;

    public CoinFaces(boolean[] faces, double[] p) {
      this.faces = faces;
      for (int i = 0; i < faces.length; i++) {
        if (faces[i]) {
          numberOfTrue++;
        }
        probability *= faces[i] ? p[i] : (1 - p[i]);
      }
    }

    public double getProbability() {
      return probability;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      CoinFaces coinFaces = (CoinFaces) o;
      return this.numberOfTrue == coinFaces.numberOfTrue;
    }

    @Override
    public int hashCode() {
      return numberOfTrue;
    }
  }

  public static void count1(double[] p) {
    int n = p.length;
    boolean[] faces = new boolean[n];
    HashMap<CoinFaces, Double> map = new HashMap<CoinFaces, Double>();
    boolean done = false;
    while (!done) {
      CoinFaces f = new CoinFaces(faces, p);
      if (map.get(f) == null) {
        map.put(f, f.getProbability());
      }
      else {
        map.put(f, map.get(f) + f.getProbability());
      }
      for (int i = n - 1; i >= -1; i--) {
        if (i == -1) {
          done = true;
          break;
        }
        if (faces[i] == false) {
          faces[i] = true;
          break;
        }
        else {
          faces[i] = false;
        }
      }
    }
    for (CoinFaces c : map.keySet()) {
      System.out.println("coins:=" + c.numberOfTrue + "   probability=" + map.get(c));
    }
  }

  public static void count2(int n) {
    long total = (int) Math.pow(2, n);
    System.out.printf("%d facing up, possiblity=%3.2f%%\n", 0,
        (100.0 * 1 / total));
    double p = 1;
    for (int i = 1; i <= n; i++) {
      p = p * (n - i + 1) / i;
      System.out.printf("%d facing up, possiblity=%3.2f%%\n", i, 100 * p / total);
    }
  }

  public static void main(String args[]) {
    count2(6);
    count1(new double[]{0.7, 0.7, 0.7, 0.7, 0.7, 0.7});
  }
}
