package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
Interview Questions Online Judge

Below are a collection of interview questions for you to practice. Click on the question’s title to expand the question description. Read the question and try to solve it by clicking on the “Solve this problem” link. You may start typing your code in the coding panel (bottom right side).

Once done, run your solution against the judge’s secret input to see if you’ve solved it correctly. It’s that easy!

Below are some tips to improve your coding skills:

Do not rush to code.
Always consider all edge cases before you start coding.
Debug in your head while you are coding.
Always aim for bug-free code on your first attempt.
Run through some test cases before submitting to avoid careless mistakes.
Finally, practice makes perfect!
Happy coding and remember to follow LeetCode to get the latest update when a new question is added!

Follow me: 

@Facebook
@Twitter
Questions List: (Click on title to expand)
3Sum
3Sum Closest
4Sum
Add Binary
Add Two Numbers
Anagrams
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

» Solve this problem
Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

» Solve this problem
Combination Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … ,ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
* @author jbu
 */
public class CombinationSum {
  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    doCombinationSum(candidates, target, 0, new ArrayList<Integer>(), result);
    return new ArrayList<ArrayList<Integer>>(result);
  }

  void doCombinationSum(int[] candidates, int target, int pos, ArrayList<Integer> current, HashSet<ArrayList<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<Integer>(current));
      return;
    }
    for (int i = pos; i < candidates.length; i++) {
      if (candidates[i] <= target) {
        current.add(candidates[i]);
        doCombinationSum(candidates, target - candidates[i], i, current, result);
        current.remove(current.size() - 1);
      }
    }
  }
}
