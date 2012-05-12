package fb.permutation;

/**
 * @author jbu
 */
public class NextPermutation {

  public void nextPermutation(int[] num) {
    // from back to front, find one number  is smaller than the one after it (head)
    int len = num.length, head = len - 2;
    while (head >= 0 && num[head] >= num[head + 1]) {
      head--;
    }
    // if head==-1, return (can't find)
    if (head == -1) {
      reverse(num, 0, len - 1);
      return;
    }
    // from back to (head-1), find first number that is larger than (head), call is tail
    int tail = len - 1;
    while (num[tail] <= num[head]) {
      tail--;
    }
    // exchange head with tail
    swap(num, head, tail);
    // reverse from head+1 to end
    reverse(num, head + 1, len - 1);
  }

  private void swap(int[] num, int i, int j) {
    int t = num[i];
    num[i] = num[j];
    num[j] = t;
  }

  private void reverse(int[] num, int i, int j) {
    for (int k = i; k < (j + i) / 2 + 1; k++) {
      swap(num, k, i + j - k);
    }
  }
}
