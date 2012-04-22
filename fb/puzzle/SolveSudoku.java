package fb.puzzle;

import java.util.*;

/**
 * Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p/>
 * Empty cells are indicated by the character '.'.
 * <p/>
 * You may assume that there will be only one unique solution.
 * <p/>
 * A sudoku puzzle...
 * <p/>
 * ...and its solution numbers marked in red.
 * <p/>
 * » Solve this problem  -- Back filling
 * http://www.leetcode.com/onlinejudge
 *
 * @author: mindpower
 * @created: 4/22/12-2:09 PM
 */
public class SolveSudoku {
  public void solveSudoku(char[][] board) {
    int[] next = getNextEmpty(board, 0, 0);
    if (next == null) return;
    solve(board, next[0], next[1]);
  }

  // x.y is the current position that I am looking for solution
  // If there is empty cell and we can't find possible values, it means the previous value is wrong
  // and we eleminate this solution and go back to previous position
  boolean solve(char[][] board, int x, int y) {
    char[] possible = getPossibleValues(board, x, y);
    if (possible == null) return false;
    for (int i = 0; i < possible.length; i++) {
      board[x][y] = possible[i];
      int[] next = getNextEmpty(board, x, y);
      if (next == null) return true;  // fully filled
      if (solve(board, next[0], next[1])) return true;
      // if this solution is not working, reset current cell and try other values
      board[x][y] = '.';
    }
    return false;
  }

  /**
   * Get possible values for cell (x,y) based on current board values
   *
   * @param board
   * @param x
   * @param y
   * @return
   */
  char[] getPossibleValues(char[][] board, int x, int y) {
    Set<Character> s = new HashSet<Character>();
    for (int i = 1; i <= 9; i++) s.add((char) (i + '0'));
    for (int i = 0; i < 9; i++) {
      if (board[i][y] != '.') s.remove(board[i][y]);
      if (board[x][i] != '.') s.remove(board[x][i]);
      char c = board[x / 3 * 3 + i / 3][y / 3 * 3 + i % 3];
      if (c != '.') s.remove(c);
    }
    if (s.isEmpty()) return null;
    char p[] = new char[s.size()];
    int k = 0;
    for (char i : s) p[k++] = i;
    return p;
  }

  /**
   * Get next empty cell, if can't find, it means it's already finished
   *
   * @param board
   * @param x
   * @param y
   * @return
   */
  int[] getNextEmpty(char[][] board, int x, int y) {
    while (x <= 8 && y <= 8) {
      if (board[x][y] == '.') return new int[]{x, y};
      x = y >= 8 ? x + 1 : x;
      y = y >= 8 ? 0 : y + 1;
    }
    return null;
  }
}
