package topcoder;

import java.util.Arrays;

/**
 * @author jbu
 */
public class Sorting {
  public static <T extends Comparable> T[] mergeSort(final T[] a) {
    Class<T> clazz;
    int len = a.length;
    if (len == 1) {
      return a;
    }
    int m = len / 2;
    // l=2: m=1, a(0,1)=1, a(1,2)=1;  l=3: m=1: a(0,1)=1, a(1,3)=2
    T left[] = mergeSort(Arrays.copyOfRange(a, 0, m));
    T right[] = mergeSort(Arrays.copyOfRange(a, m, len));
    // merge a[i,m] and a[m,j];
    return merge(left, right);
  }

  public static <T extends Comparable> T[] merge(T[] left, T[] right) {
    int len = left.length + right.length;
    T result[] = Arrays.copyOfRange(left, 0, len);

    int i = left.length - 1, j = right.length - 1, c = len - 1;
    while (j >= 0 && i >= 0) {
      if (result[i].compareTo(right[j]) > 0) {
        result[c--] = result[i--];
      } else {
        result[c--] = right[j--];
      }
    }
    while (j >= 0) {
      result[c--] = right[j--];
    }

    for (T aResult : result) {
      System.out.print(aResult + ",");
    }
    System.out.println();
    return result;
  }

  public static <T extends Comparable> void bubbleSort(T[] a) {
    int len = a.length;
    boolean swapped = false;
    do {
      swapped = false;
      for (int i = 1; i < len; i++) {
        if (a[i-1].compareTo(a[i])>0) {
          swap(a, i-1, i);
          swapped = true;
        }
      }
    } while (swapped);
  }

  public static <T extends Comparable> void selectionSort(T[] a){
    int len= a.length;
    for (int i=0;i<len-1;i++) {
      int minP = i;
      for (int j=i+1;j<len;j++) {
        if (a[j].compareTo(a[minP])<0) minP = j;
      }
      if (minP!=i) swap(a, i,minP);
    }
  }

  public static <T extends Comparable> void insertionSort(T[] a) {
    int len = a.length, k;
    for (int i=1;i<len;i++) {
      T t = a[i];
      for (k=i;k>0 && t.compareTo(a[k-1])<0; k--) a[k]=a[k-1];
      a[k] = t;
    }
  }

  public static <T extends Comparable> void quickSort(T[] a, int l, int u) {
    if (l>=u) return;
    T t = a[l];
    int m = l;
    for (int i=l+1;i<=u;i++) {
      if (a[i].compareTo(t)<0) swap(a, i, ++m);
    }
    swap(a, l, m);
    quickSort(a, l, m-1);
    quickSort(a, m+1, u);
  }

  public static <T> void swap(T[]a, int i, int j) {
    T t = a[j];
    a[j] = a[i];
    a[i] = t;
  }

  public static void main(String args[]) {
    Integer a[] = {18, 6, 9, 1, 4, 15, 12, 5, 6, 7, 11};
    Integer result[] = mergeSort(a);
    System.out.println("mergesort");
    for (int aResult : result) {
      System.out.print(aResult + ",");
    }
    System.out.println();

    System.out.println("bubblesort");
    bubbleSort(a);
    for (int aResult : a) {
      System.out.print(aResult + ",");
    }
    System.out.println();

    System.out.println("selectionsort");
    a = new Integer[]{18, 6, 9, 1, 4, 15, 12, 5, 6, 7, 11};
    selectionSort(a);
    for (int aResult : a) {
      System.out.print(aResult + ",");
    }
    System.out.println();

    System.out.println("insertionsort");
    a = new Integer[]{18, 6, 9, 1, 4, 15, 12, 5, 6, 7, 11};
    insertionSort(a);
    for (int aResult : a) {
      System.out.print(aResult + ",");
    }
    System.out.println();


    System.out.println("quicksort");
    a = new Integer[]{18, 6, 9, 1, 4, 15, 12, 5, 6, 7, 11};
    quickSort(a, 0,a.length-1);
    for (int aResult : a) {
      System.out.print(aResult + ",");
    }
    System.out.println();

    Integer two = 2;
    Integer one =1 ;
    int i = two - one;
    
  }

}
