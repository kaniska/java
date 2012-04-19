package tc;

/**
 * @author jbu
 */
class Point implements Comparable {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Point point = (Point) o;

    if (x != point.x) {
      return false;
    }
    if (y != point.y) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Point");
    sb.append("{x=").append(x);
    sb.append(", y=").append(y);
    sb.append('}');
    return sb.toString();
  }

  public int compareTo(Object o) {
    Point p = (Point) o;
    if (x < p.x) return -1;
    if (x == p.x) return y < p.y ? -1 : y == p.y ? 0 : 1;
    return 1;
  }


}
