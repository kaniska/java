package fb.array;

/**
 * @author jbu
 */
public class CircularSortedSearch {

  public static int rotatedSearch(int[] values, int start, int end,
                          int x){
    if(values[start] == x){
        return start;
    } else if(values[end] == x){
        return end;
    } else if(end - start == 1) {
        return -1;
    }
    int middle = (start + end) / 2;

    if(values[start] <= values[middle]){
        if(x <= values[middle] && x >= values[start]){
            return rotatedSearch(values, start, middle, x);
        } else {
            return rotatedSearch(values, middle, end, x);
        }
    } else if(values[middle] <= values[end]){
        if(x >= values[middle] && x <= values[end] ){
            return rotatedSearch(values, middle, end, x);
        } else {
            return rotatedSearch(values, start, middle, x);
        }
    } else {
        return -1;
    }
}

  public static int circularSearch(int[] a, int l, int u, int x) {
    int m=(l+u)/2;
    if (x==a[m]) return m;
    if (l>=u) return -1;
    if (a[l]<=a[m]) {
      if (x<a[m] && x>=a[l]) return circularSearch(a,l,m-1,x);
      else return circularSearch(a, m+1, u,x);
    } else if (a[m]<=a[u]) {
      if (x>a[m] && x<=a[u]) return circularSearch(a,m+1,u,x);
      else return circularSearch(a,l,m-1,x);
    }
    return -1;
  }

  public static void main(String args[]) {
    int [] a = {19,30,31,35,40,44,50,51, 123,2,3,4,5,6,7,9,12,15,17, 18};
    System.out.println(circularSearch(a, 0,a.length-1, 15));
    System.out.println(circularSearch(a, 0,a.length-1, 102));
    System.out.println(circularSearch(a, 0,a.length-1, 40));
    System.out.println(circularSearch(a, 0,a.length-1, 10));
    System.out.println(circularSearch(a, 0,a.length-1, 19));

        System.out.println(circularSearch(a, 0,a.length-1, 15));
    System.out.println(rotatedSearch(a, 0,a.length-1, 102));
    System.out.println(rotatedSearch(a, 0,a.length-1, 40));
    System.out.println(rotatedSearch(a, 0,a.length-1, 10));
    System.out.println(rotatedSearch(a, 0,a.length-1, 19));
  }

}
