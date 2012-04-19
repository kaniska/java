package careercup;

import java.util.Stack;

/**
 * @author jbu
 */
public class C3_Stack {
}


class MyQueue<T> {
  Stack<T> s1,s2;

  MyQueue() {
   s1 = new Stack<T>();
    s2 = new Stack<T>();
  }

  public void add(T t) {
    s1.push(t);
  }

  public T peek() {
    if (!s2.isEmpty()) return s2.peek();
    while (!s1.isEmpty()) s2.push(s1.pop());
    return s2.peek();
  }

  public T remove() {
    if (!s2.isEmpty()) return s2.pop();
    while (!s1.isEmpty()) s2.push(s1.pop());
    return s2.pop();
  }

}
