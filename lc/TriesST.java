package lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jbu
 */
public class TriesST<T> {
  private static final int R = 255;

  public static class Node<T> {
    private T val;
    private Node<T>[] nodes = new Node[R];
  }

  private Node<T> root = null;

  public void put(String key, T val) {
    root = put(root, key, val, 0);
  }

  public Node put(Node<T> x, String key, T val, int d) {
    if (x == null) {
      x = new Node<T>();
    }
    if (key.length() == d) {
      x.val = val;
      return x;
    }
    char c = key.charAt(d);
    x.nodes[c] = put(x.nodes[c], key, val, d + 1);
    return x;
  }

  public boolean contains(String key) {
    return get(key) != null;
  }


  public T get(String key) {
    Node<T> node = get(root, key, 0);
    if (node == null) return null;
    return node.val;
  }

  public Node<T> get(Node x, String key, int d) {
    if (x == null) return null;
    if (d == key.length()) return x;
    char c = key.charAt(d);
    return get(x.nodes[c], key, d + 1);
  }

  public Iterable<String> keys() {
    Deque<String> queue = new LinkedList<String>();
    collect(root, "", queue);
    return queue;
  }

  public Iterable<String> keys(String prefix) {
    Deque<String> queue = new LinkedList<String>();
    Node<T> node = get(root, prefix, 0);
    collect(node, prefix, queue);
    return queue;
  }

  private void collect(Node x, String prefix, Deque<String> q) {
    if (x == null) return;
    if (x.val != null) q.addLast(prefix);
    for (char i = 0; i < R; i++) {
      collect(x.nodes[i], prefix + i, q);
    }
  }

  public String longestPrefix(String query) {
    int length = search(root, query, 0, 0);
    return query.substring(0, length);
  }

  private int search(Node x, String query, int d, int length) {
    if (x == null) return length;
    if (x.val != null) length = d;
    if (d == query.length()) return length;
    char c = query.charAt(d);
    return search(x.nodes[c], query, d + 1, length);
  }

  public static void main(String args[]) {
    String[] s = "she sells sea shells by the".split(" ");
    TriesST<Integer> tries = new TriesST<Integer>();
    for (int i = 0; i < s.length; i++) {
      tries.put(s[i], i);
    }

    System.out.println("contains she=" + tries.contains("she"));
    System.out.println("contains shore=" + tries.contains("shore"));

    Iterable<String> keys = tries.keys();
    for (String k : keys) {
      System.out.println(k);
    }

    keys = tries.keys("sh");
    for (String k : keys) {
      System.out.println(k);
    }

    System.out.println(26535 % 997);
    int R = 256;
    int RM = 1;
    int Q = 8355967;
    for (int i = 1; i <= 5; i++) {
      RM = (R * RM) % Q;
      System.out.println(RM);
    }


  }


}
