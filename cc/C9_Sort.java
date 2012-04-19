package cc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jbu
 */
public class C9_Sort {

  static class StringComparator implements Comparator<String> {

    String getAnagram(String o) {
      char[] c = o.toCharArray();
      char t;
      for (int i=0;i<=c.length/2;i++) {
        t = c[c.length-1-i];
        c[c.length-1-i] = c[i];
        c[i]=t;
      }
      return new String(c).compareTo(o)<=0? new String(c):o;
    }

    public int compare(String o, String o1) {
      return getAnagram(o).compareTo(getAnagram(o1));
    }
  }

  public static void sortByAnagram(String[] str) {
    Arrays.sort(str, new StringComparator());
  }

  public static int findRotationIndex(int a[], int i,int j) {
    if (a[i]<a[j]) return -1;
    if (a[i]>a[j] && i+1==j) return j;
    int len = j-i;
    return Math.max(findRotationIndex(a, i, i+len/2), findRotationIndex(a, i+len/2,j));
  }

  public static int largestPossibleCircus(Person[] p) {
    Arrays.sort(p, new HeightComparator());
    int curLen = 1, maxLen = 1;
    Person maxLast = p[0];
    for (int i=1; i<p.length;i++) {
      curLen = p[i].compareTo(p[i-1])>0? curLen+1:1;
      maxLen = p[i].compareTo(maxLast)>0? maxLen+1: maxLen;
      if (curLen>=maxLen) {
        maxLen = curLen;
        maxLast = p[i];
      }
    }
    return maxLen;
  }

  public static void main(String args[]) {
    String[] str = new String[] {"Hello", "Google", "Welcome", "olleH","elgooG"};
    List<String> list = Arrays.asList(str);
    System.out.println(Arrays.asList(str));
    sortByAnagram(str);
    System.out.println(Arrays.asList(str));

    int a[] = {15,16,19,20,25,1,3,4,5,7,10,14};
    int r = findRotationIndex(a, 0, a.length-1);
    System.out.println(r);
    if (r==-1) System.out.println(Arrays.binarySearch(a, 5));
    else if (5>a[0]) System.out.println(Arrays.binarySearch(a, 0, r-1,5));
    else System.out.println(Arrays.binarySearch(a,r, a.length-1, 5));

    Person[] p = new Person[]{ new Person(65,100), new Person(70,150), new Person(56,90), new Person(75,190),
      new Person(60,95), new Person(68,110)};
    System.out.println(Arrays.asList(p)+" max="+largestPossibleCircus(p));

     

  }

}

class Person implements Comparable {
  int height;
  int weight;

  Person(int height, int weight) {
    this.height = height;
    this.weight = weight;
  }

  public int compareTo(Object o) {
    Person other = (Person)o;
    return new Integer(weight).compareTo(((Person) o).weight);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("(").append(height);
    sb.append(",").append(weight);
    sb.append(')');
    return sb.toString();
  }
}

class HeightComparator implements Comparator<Person> {
  public int compare(Person p1, Person p2 ) {
    if (p1.height==p2.height) return new Integer(p1.weight).compareTo(p2.weight);
    return new Integer(p1.height).compareTo(p2.height);
  }
}
