package fb.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jbu
 */
public class CacheManager {
  public static void main(String args[]) {
    LRUCache<Integer, Integer> cs = new LRUCache<Integer, Integer>(3);
    Integer[][] data = new Integer[][]{ //
        // {0:put, 1:get}, {result}
        {0, 1}, {1}, // put 1 - add
        {0, 2}, {2, 1},// put 2 - add
        {0, 3}, {3, 2, 1},// put 3 - add
        {0, 2}, {2, 3, 1},// put 2 - refresh, data changed
        {1, 1}, {1, 2, 3},// get 1 - get
        {0, 3}, {3, 1, 2},// put 3 - refresh, data changed
        {1, 4}, {3, 1, 2},// get 4 - miss
        {0, 4}, {4, 3, 1},// put 4 - 2 is gone
        {0, 0}, {0, 4, 3},// put 0 - 1 is gone
    };
    for (int i = 0; i < data.length; i += 2) {
      int act = data[i][0];
      int d = data[i][1];
      if (act == 1) { // get
        cs.get(d);
      }
      else { // put
        cs.put(d, d);
      }
      if (cs.getKeys().equals(Arrays.asList(data[i + 1]))) {
        System.out.println("CORRECT: " + cs.getKeys() + "  /  " + Arrays.asList(data[i + 1]));
      }
      else {
        System.out.println("WRONG: " + cs.getKeys() + "  /  " + Arrays.asList(data[i + 1]));
      }
    }
  }
}

interface Cache<K, V> {
  public void put(K k, V v);

  public V get(K k);

  public List<K> getKeys();
}

class LRUCache<K, V> implements Cache<K, V> {
  public class ListNode {
    K key;
    V value;
    ListNode prev, next;

    public ListNode(K k, V v) {
      this.key = k;
      this.value = v;
    }
  }

  Map<K, ListNode> map = null;
  int maxsize = 10;
  final static float loadfactor = 0.75f;
  ListNode head, tail;

  public LRUCache(int size, float loadfactor) {
    map = new HashMap<K, ListNode>((int) (Math.ceil(size / loadfactor)) + 1, loadfactor);
    this.maxsize = size;
  }

  public LRUCache(int size) {
    this(size, loadfactor);
  }

  public void put(K k, V v) {
    if (!map.containsKey(k)) {
      ListNode n = new ListNode(k, v);
      addFirst(n);
      map.put(k, n);
      if (map.size() > maxsize) {
        ListNode last = removeLast();
        map.remove(last.key);
      }
    }
    else {
      ListNode n = map.get(k);
      n.value = v;
      map.put(k, n);  // not changing position if update value
      moveToFirst(n);
    }
  }

  public V get(K k) {
    if (!map.containsKey(k)) {
      return null;
    }
    ListNode n = map.get(k);
    moveToFirst(n);
    return n.value;
  }

  public List<K> getKeys() {
    if (head == null) {
      return null;
    }
    ListNode c = head;
    List<K> l = new ArrayList<K>();
    while (c != null) {
      l.add(c.key);
      c = c.next;
    }
    return l;
  }

  private void addFirst(ListNode n) {
    if (head == null) {
      head = n;
      tail = n;
    }
    else {
      n.next = head;
      head.prev = n;
      head = n;
    }
  }

  private ListNode removeLast() {
    ListNode n = tail;
    if (head == tail) {  // one node only
      head = null;
      tail = null;
    }
    else {
      tail = tail.prev;
      tail.next = null;
    }
    return n;
  }

  private void moveToFirst(ListNode n) {
    if (head == n) {
      return;
    }
    if (tail == n) {
      n.prev.next = null;
      tail = n.prev;
      head.prev = n;
      n.next = head;
      head = n;
    }
    else {
      n.prev.next = n.next;
      n.next.prev = n.prev;
      head.prev = n;
      n.next = head;
      head = n;
    }
  }
}
