package fb.permutation;

/**
 * @author: mindpower
 * @since: 7:57 AM, 5/13/12
 */
public class PermutationSequence {
  public String getPermutation(int n, int k) {
    int[] p = new int[n];
    for (int i=0;i<n;i++) p[i]=i+1;
    for (int i=0;i<k-1;i++) p = nextPermutation(p);
    StringBuilder sb = new StringBuilder();
    for (int i=0;i<n;i++) sb.append(p[i]);
    return sb.toString();
  }

  int[] nextPermutation(int[] p) {
    int len = p.length;
    int start = len -2;
    while (start>=0 && p[start]>=p[start+1]) start--;
    if (start<0) return p;//no next permutation
    int end = len-1;
    while (p[end]<=p[start]) end--;
    swap(p,start,end);
    reverse(p,start+1,len-1);
    return p;
  }

  void swap(int[] a,int i,int j) {
    int t = a[i];
    a[i]=a[j];
    a[j]=t;
  }

  void reverse(int[] a, int start, int end) {
    for (int i=start;i<(start+end+1)/2;i++) {
      swap(a,i,end+start-i);
    }

  }
}
