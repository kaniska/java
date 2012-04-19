package test;

/**
 * simple test class for test.IterateArray
 *
 * @author jbu
 */
public class IterateArrayTest {
  public static void main(String args[]) {
    IterateArray.PrintArray(new Integer[][]{{1, 2, 3, 4}, {14, 15, 16, 5}, {13, 20, 17, 6}, {12, 19, 18, 7}, {11, 10, 9, 8}});
    IterateArray.PrintArray(new Integer[][]{{1}, {2}, {3}, {4}});
    IterateArray.PrintArray(new Character[][]{{'a', 'b'}, {'c', 'd'}, {'e', 'f'}, {'g', 'h'}, {'i', 'j'}, {'k', 'l'}});
    IterateArray.PrintArray(new Integer[][]{{1, 2, 3, 4}});
    IterateArray.PrintArray(new Integer[][]{{1}});
    IterateArray.PrintArray(new Integer[][]{{1, 2}, {3, 4}});
  }

}
