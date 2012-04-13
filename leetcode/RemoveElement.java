package leetcode;

/**
 * @author jbu
 */
public class RemoveElement {
    // minimize element to be moved in the array
    public int removeElement(int[] A, int elem) {
       int len = A.length;
       int i=0,j=len-1;
       while (i<=j) {
           // find first element to be removed
           while (i<len && A[i]!=elem) i++;
           // find first element to be kept
           while (j>=0 && A[j]==elem) j--;
           if (i>j) break;
           swap(A,i,j);
       }
       return i;
    }

    private void swap(int[]A, int i, int j) {
        int t = A[i];
        A[i]=A[j];
        A[j]=t;
    }
}
