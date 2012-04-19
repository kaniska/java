package scjp;

import java.util.*;
import java.io.Console;
public class SortCompare {
  public static void main(String[] args) {
    int length = 1000;
    if (args.length>0) {
      try { 
        length = Integer.parseInt(args[0]);
      } catch (Exception e) {}
    }
    int n[] = new int[length];
    Random r = new Random(System.currentTimeMillis());
    for (int i=0;i<length;i++) {
      n[i] = r.nextInt();
    }
    String next ;
    Console c = System.console();
    while ( (next=c.readLine("Please select: 1)Bubble 2)Insertion 3)Selection 4)Quick 5)Merge 6)Bucket:\n"))!="\n") {
      int t = 0;
      try { t = Integer.parseInt(next); } catch (Exception e) {};
      if (t==0 || t>6) System.exit(0);
      int nn[] = Arrays.copyOf(n, length);
      long t1 = System.currentTimeMillis();
      switch (t) {
        case 1: bubbleSort(nn); break;
        case 2: insertionSort(nn); break;
        case 3: selectionSort(nn); break;
        case 4: quickSort(nn, 0, nn.length-1); break;
        case 5: nn = mergeSort(nn); break;
        default: break;
                 
      }
      long t2 = System.currentTimeMillis();
      boolean correct = isSorted(nn);
      System.out.println("Length="+length+" \tTime spent="+(t2-t1)+" milliseconds, sorted="+correct);
//      System.out.println(Arrays.toString(nn));
    }
  }

  public static boolean swap(int[] n, int x, int y) {
    int t = n[x];
    n[x] = n[y];
    n[y] = t;
    return true;
  }

  public static void bubbleSort(int[] n){
    boolean swapped;
    int len = n.length;
    do {
      swapped = false;
      for (int i=0;i<len-1;i++) {
        if (n[i]>n[i+1]) swapped = swap(n,i,i+1);
      }
    } while (swapped);
  }

  public static void insertionSort(int[] n) {
    int t;
    for (int i=1;i<n.length;i++) {
      t = n[i]; int j=i-1;
      while (j>=0 && n[j]>t) n[j+1]=n[j--];
      n[j+1] = t;
    }
  }

  public static void selectionSort(int[] n){
    for (int i=0;i<n.length-1;i++) {
      int min = i;
      for (int j=i;j<n.length;j++) if (n[j]<n[min]) min=j;
      if (min!=i) swap(n, i, min);
    }
  }

  public static void quickSort(int[] n, int l, int u) {
    if (l>=u) return;
    int t = n[l], m=l;
    for (int i=l+1;i<=u;i++) if (n[i]<t) swap(n,++m,i);
    swap(n, m, l);
    quickSort(n, l, m-1);
    quickSort(n, m+1, u);
  }

  public static int[] mergeSort(int[] n) {
    int len = n.length;
    if (len==1) return n;
    int m = len/2;
    int[] left = mergeSort(Arrays.copyOfRange(n, 0, m));
    int[] right = mergeSort(Arrays.copyOfRange(n, m, len));
    return merge(left, right);
  }

  public static int[] merge(int[] left, int[] right) {
    int len1 = left.length, len2=right.length, len = len1+len2;
    int []result = Arrays.copyOf(left, left.length+right.length);
    int i = len-1, i1 = len1-1, i2 = len2-1;
    while (i>=0 && i2>=0) {
      if (i1<0 || right[i2]>=left[i1]) result[i--]=right[i2--];
      else result[i--]=left[i1--];
    }
//    System.out.println(Arrays.toString(result));
    return result;
  }


  public static boolean isSorted(int [] n) {
    for (int i=0;i<n.length-1;i++) {
      if (n[i]>n[i+1]) return false;
    }
    return true;
  }
}



