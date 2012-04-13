package leetcode;

import java.util.Stack;

/**
 * @author jbu
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<Integer>();
       int max =0;
       // put into index of the left parenthesis into stack,
       // and pop up when meet right parenthesis
       // everytime pop up, peek the top of the stack (which is the one hasn't been processed yet,
       // and calcuate the current length, if stack is empty, take as -1,
       for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='(') stack.push(i);
            else {
                if (stack.size()==0 || s.charAt(stack.peek())!='(') {
                    stack.push(i);
                } else {  // stack top is (
                    stack.pop();
                    int last = stack.size()==0? -1: stack.peek();
                    max = max>(i-last)? max:(i-last);
                }

            }
       }
       return max;
    }

}
