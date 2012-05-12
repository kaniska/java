package src;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Junjie Bu
 * @since 05/11/2012
 */
public class Tries<T> {
    private static final int R = 2;

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
        int c = key.charAt(d) == '.' ? 0 : 1;
        x.nodes[c] = put(x.nodes[c], key, val, d + 1);
        return x;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }


    public T get(String key) {
        Node<T> node = get(root, key, 0);
        if (node == null) {
            return null;
        }
        return node.val;
    }

    public Node<T> get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        int c = key.charAt(d) == '.' ? 0 : 1;
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

    private void collect(Node<T> x, String prefix, Deque<String> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            q.addLast(prefix);
        }
        for (char i = 0; i < R; i++) {
            collect(x.nodes[i], prefix + (i==0?'.':'-'), q);
        }
    }

    public Iterable<T> values(String prefix) {
        Deque<T> queue = new LinkedList<T>();
        Node<T> node = get(root, prefix, 0);
        collectValues(node, prefix, queue);
        return queue;
    }

    private void collectValues(Node<T> x, String prefix, Deque<T> q) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            q.addLast(x.val);
        }
        for (char i = 0; i < R; i++) {
            collectValues(x.nodes[i], prefix + (i==0?'.':'-'), q);
        }
    }


    public String longestPrefix(String query) {
        int length = search(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int search(Node x, String query, int d, int length) {
        if (x == null) {
            return length;
        }
        if (x.val != null) {
            length = d;
        }
        if (d == query.length()) {
            return length;
        }
        int c = query.charAt(d) == '.' ? 0 : 1;
        return search(x.nodes[c], query, d + 1, length);
    }

    public static void main(String args[]) {
        Tries<Character> tries = new Tries<Character>();
        tries.put("--..", 'Z');
        tries.put("----.", '9');
        tries.put("---..", '8');

        Iterable<String> keys = tries.keys();
        for (String k : keys) {
            System.out.println(k);
        }

        keys = tries.keys("----.");
        System.out.println(tries.get("--.."));
        for (String k : keys) {
            System.out.println(k);
        }


//        String[] s = "she sells sea shells by the".split(" ");
//        Tries<Integer> tries = new Tries<Integer>();
//        for (int i = 0; i < s.length; i++) {
//            tries.put(s[i], i);
//        }
//
//        System.out.println("contains she=" + tries.contains("she"));
//        System.out.println("contains shore=" + tries.contains("shore"));
//
//        Iterable<String> keys = tries.keys();
//        for (String k : keys) {
//            System.out.println(k);
//        }
//
//        keys = tries.keys("sh");
//        for (String k : keys) {
//            System.out.println(k);
//        }


    }
}
