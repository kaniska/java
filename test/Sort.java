package test;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author jbu
 */
public class Sort {

  public static void swap(int []x,int a, int b) {
    int t = x[a];
    x[a] = x[b];
    x[b]=t;
  }

  public static void isort1(int[] x) {
    for (int i=1;i<x.length;i++) {
      for (int j=i;j>0 && x[j-1]>x[j]; j--) {
        swap(x, j-1,j);
      }
    }
  }

  public static void isort2(int[] x) {
    int t;
    for (int i=1;i<x.length;i++) {
      for (int j=i;j>0 && x[j-1]>x[j]; j--) {
         t = x[j];
        x[j] = x[j-1];
        x[j-1] = t;
      }
    }
  }

  public static void isort3(int[] x) {
    int t,j;
    for (int i=1;i<x.length;i++) {
      t = x[i];
      for (j=i;j>0 && x[j-1]>t; j--) {
        x[j] = x[j-1];
      }
      x[j] = t;
    }
  }

  public static void qsort(int[] x, int l, int u) {
    if (l>=u) return;
    int t = x[l], m=l;
    for (int i=l+1;i<=u;i++) {
      // x[l+1..m]< x[l] < x[m+1..u]
      if (x[i]<t) {
        m++;
        swap(x, i,m);
      }
    }
    swap(x, l, m);
    qsort(x, l, m-1);
    qsort(x, m+1, u);
  }


  public static void hsort(int[] x) {
    PriorityQueue<Integer> h = new PriorityQueue<Integer>();
    for (int i=0;i<x.length;i++) {
      h.add(x[i]);
    }
    for (int i=0;i<x.length;i++) {
      x[i] = h.poll();
    }
  }


 public static void hsort2(int[] x) {
   heapify(x);
   for (int i=x.length-1;i>0;i--) {
     swap(x,0, i);
     siftDown(x,0,i);
   }
 }


  public static void heapify(int[] x) {
    int len = x.length;
    int n = len/2;
    while (n>=0) {
     siftDown(x, n--, len);
    }
  }

  public static void siftDown(int[] x, int n,int len) {
    // children:  2*n+1, 2*n+2
    int largest = n;
    while (true) {
      // left children
      if (2*n+1<len && x[2*n+1]>x[n]) {
        largest = 2*n+1;
      }
      if (2*n+2<len && x[2*n+2]>x[largest]) {
        largest = 2*n+2;
      }
      if (largest!=n) {
        swap(x,n, largest);
        n = largest;
      } else {
        break;
      }
    }
  }


  public static long now = 0;  
  public static void main(String args[]) {
    Random r = new Random();
    int limit = 100000000, n = 1000000, x[] = new int[n];
    p("Array=[");
    for (int i = 0; i < n; i++) {
      x[i] = r.nextInt(limit);
//      p(x[i], ";");
    }
    pl("]");

    int i;
    long diff =0;
    int  s1[] = new int[n], s2[] = new int[n], s3[]=new int[n], s4[]=new int[n],
      h1[]=new int[n], h2[]=new int[n];
    System.arraycopy(x,0,s1,0,n);
    System.arraycopy(x,0,s2,0,n);
    System.arraycopy(x,0,s3,0,n);
    System.arraycopy(x,0,s4,0,n);
    System.arraycopy(x,0,h1,0,n);
    System.arraycopy(x,0,h2,0,n);

/*    now = System.nanoTime(); isort1(s1);
    for (i=0;i<s1.length-1 && s1[i]<=s1[i+1];i++);
    if (i<s1.length-1) pl("sort1 error");
    diff = System.nanoTime()-now;
    pl("isort1 time=", (double)(diff)/1000000000d, "s; time for n=", (double)diff/(n*n), "ns");

    now = System.nanoTime(); isort2(s2);
    for (i=0;i<s2.length-1 && s2[i]<=s2[i+1];i++);
    if (i<s2.length-1) pl("sort2 error");
    diff = System.nanoTime()-now;
    pl("isort2 time=", (double)(diff)/1000000000d, "s; time for n=", (double)diff/(n*n), "ns"); //*/

/*    now = System.nanoTime(); isort3(s3);
    for (i=0;i<s3.length-1 && s3[i]<=s3[i+1];i++);
    if (i<s3.length-1) pl("sort3 error");
    diff = System.nanoTime()-now;
    pl("isort3 time=", (double)(diff)/1000000000d, "s; time for n=", (double)diff/(double)n/(double)n, "ns");//*/

    now = System.nanoTime(); qsort(s4, 0, n-1);
    for (i=0;i<s4.length-1 && s4[i]<=s4[i+1];i++);
    if (i<s4.length-1) pl("qsort error");
    diff = System.nanoTime()-now;
    pl("qsort time=", (double)(diff)/1000000000d, "s; time for n=", (double)diff/(double)(n*Math.log(n)), "ns");  //*/


    now = System.nanoTime(); hsort(h1);
    for (i=0;i<h1.length-1 && h1[i]<=h1[i+1];i++);
    if (i<h1.length-1) pl("hsort error");
    diff = System.nanoTime()-now;
    pl("hsort time=", (double)(diff)/1000000000d, "s; time for n=", (double)diff/(double)(n*Math.log(n)), "ns"); //*/

    now = System.nanoTime(); hsort2(h2);
    for (i=0;i<h2.length-1 && h2[i]<=h2[i+1];i++);
    if (i<h2.length-1) pl("hsort2 error");
    diff = System.nanoTime()-now;
    pl("hsort2 time=", (double)(diff)/1000000000d, "s; time for n=", (double)diff/(double)(n*Math.log(n)), "ns");


  }

  public static void pl(Object... msg) {
    p(msg);
    p("\n");
  }

  public static void p(Object... msg) {
    StringBuilder sb = new StringBuilder("");
    for (Object o : msg) {
      if (o != null) {
        sb.append(o);
      } else {
        sb.append("null");
      }
    }
    System.out.print(sb.toString());
  }  
}
