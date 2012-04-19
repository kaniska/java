package test;

import java.io.Serializable;
import java.util.HashSet;

/**
 * @author jbu
 */
public class WPList<T> implements Serializable {
  private static final long serialVersionUID = 1L;

  protected Node<T> head = null;

  public WPList() {
  }

  public WPList(Node<T> head) {
    this.head = head;
  }

  public WPList(T item) {
    head = new Node<T>(item);
  }

  public void insert(T item) {
    if (head == null) {
      head = new Node<T>(item);
    } else {
      Node<T> newItem = new Node<T>(item);
      newItem.next = head;
      head = newItem;
    }
  }

  public T remove() {
    if (head == null) {
      return null;
    }
    Node<T> t = head;
    head = head.next;
    t.next = null;
    return t.element;
  }

  public void traverse() {
    t(">>>>>>>>>>>>  Traverse the list >>>>>>>");
    if (head == null) {
      t("empty list");
      return;
    }
    Node<T> a = head;
    while (a != null) {
      t(a.element.toString());
      a = a.next;
    }
  }

  public void reverse() {
    if (head == null || head.next == null) {
      return;
    }
    Node<T> a = head;
    Node<T> prev = null;
    while (a.next != null) {
      Node<T> tmp = a;
      a = a.next;
      tmp.next = prev;
      prev = tmp;
    }
    a.next = prev;
    head = a;
  }

  public Node<T> find(T a) {
    Node<T> t = head;
    while (t != null && !t.element.equals(a)) {
      t = t.next;
    }
    return t;
  }

  public void clear() {
    while (head != null) {
      Node<T> t = head.next;
      t.next = null;
    }
  }

  public boolean delete(T a) {
    if (head == null) {
      return false;
    }
    Node<T> t = head;

    if (head.element.equals(a)) {
      head = t.next;
      t.next = null;
      return true;
    } else {
      Node<T> prev = head;
      t = t.next;
      while (t != null) {
        if (t.element.equals(a)) {
          prev.next = t.next;
          t.next = null;
          return true;
        } else {
          prev = t;
          t = t.next;
        }
      }
    }
    return false;
  }

  public static void t(String msg) {
    System.out.println(msg);
  }

  public static String RemoveChars(String str, String remove) {
    StringBuffer sb = new StringBuffer();
    HashSet<Character> h = new HashSet<Character>();
    for (char c : remove.toCharArray()) {
      h.add(c);
    }
    for (char c : str.toCharArray()) {
      if (!h.contains(c)) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static char[] RemoveChars(char str[], char remove[]) {

    boolean r[] = new boolean[128];
    char result[] = new char[str.length];

    for (char c : remove) {
      r[c] = true;
    }
    int i = 0;
    for (char c : str) {
      if (!r[c]) {
        result[i++] = c;
      }
    }

    t(String.valueOf(result, 0, i));
    return result;
  }

  public static String int2Str(int i) {
    char str[] = new char[32];
    boolean isNeg = false;
    if (i < 0) {
      isNeg = true;
      i = -1 * i;
    }
    int p = 0;
    do {
      str[p++] = (char) ('0' + i%10);
      i = i / 10;
    } while (i > 0);
    if (isNeg) {
      str[p++] = '-';
    }
    reverseString(str, 0, p-1);

    return String.valueOf(str, 0, p);
  }

  public static void reverseWord_NoBuffer(char str[]) {
    reverseString(str, 0, str.length - 1);
    int start = 0, end = 0;
    while (end < str.length) {
      if (str[end] != ' ') {
        start = end;
        while (end < str.length && str[end] != ' ') {
          end++;
        }
        end--;
        reverseString(str, start, end);
      }
      end++;
    }
  }

  public static void reverseString(char str[], int s, int e) {
    char a;
    for (int i = s; i <= e + s - i; i++) {
      a = str[i];
      str[i] = str[e + s - i];
      str[e + s - i] = a;
    }
  }

  public static char[] reverseWord(char str[]) {
    char[] result = new char[str.length];

    int src = str.length - 1, dst = 0, lastEnd = str.length - 1;
    boolean word = false;
//    for (int src = str.length - 1; src >= 0; src--) {
    while (src >= 0) {
      t("Char=" + str[src]);
      if (str[src] == ' ') {
        if (!word) {
          result[dst++] = str[src--];
        } else {
          t("Word starting found");
          for (int i = src + 1; i <= lastEnd; i++) {
            result[dst++] = str[i];
          }
//          result[dst++] = str[src];
          word = false;
        }
      } else {
        if (!word) {
          word = true;
          lastEnd = src;
          t("Word ending found");
        }
        src--;
      }
    }

    t(String.valueOf(result));
    return result;
  }

  public static void main(String args[]) {
    WPList<String> mylist = new WPList<String>("AAA");
    mylist.insert("BBB");
    mylist.insert("Hello");
    mylist.insert("Good");

    mylist.traverse();
    mylist.reverse();
    mylist.traverse();
    Node<String> f = mylist.find("Hello");
    t("Found " + f);
    t("Deleted Goaaad ?=" + mylist.delete("Goaaad"));
    mylist.traverse();
    t("Deleted Good ?=" + mylist.delete("Good"));
    mylist.traverse();
    t("Deleted AAA ?=" + mylist.delete("AAA"));
    mylist.traverse();
    t("Deleted Good ?=" + mylist.delete("Good"));
    mylist.traverse();

    t("result=" + WPList.RemoveChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
    t("result=" + WPList.RemoveChars("Battle of the Vowels: Hawaii vs. Grozny".toCharArray(), "aeiou".toCharArray()));

    t("Result=" + String.valueOf(WPList.reverseWord(" When you find a word character,".toCharArray())));
    char[] sample = " When you find a word character,".toCharArray();
    WPList.reverseWord_NoBuffer(sample);
    t("Sample result=" + String.valueOf(sample));

    int i = 12312312;
    t("Int=" + i + "str=" + WPList.int2Str(i) + "   |i=" + i);
    i = 0;
    t("Int=" + i + "str=" + WPList.int2Str(i) + "   |i=" + i);
    i = 1;
    t("Int=" + i + "str=" + WPList.int2Str(i) + "   |i=" + i);
    i = -1;
    t("Int=" + i + "str=" + WPList.int2Str(i) + "   |i=" + i);
    i = 2134897989;
    t("Int=" + i + "str=" + WPList.int2Str(i) + "   |i=" + i);
    i = -2134845289;
    t("Int=" + i + "str=" + WPList.int2Str(i) + "   |i=" + i);
  }
}

