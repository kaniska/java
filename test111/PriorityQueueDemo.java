package test111;

/**
 * @author jbu
 */

import java.util.*;

public class PriorityQueueDemo {

  static PriorityQueue<String> stringQueue;

  public static void main(String[] args) {

    System.out.println("ab vs. ad"+ "ab".compareTo("ac"));

    stringQueue = new PriorityQueue<String>();

    stringQueue.add("abd");
    stringQueue.add("abcd");
    stringQueue.add("abc");
    stringQueue.add("a");

//don't use iterator which may or may not
//show the PriorityQueue's order
    while (stringQueue.size() > 0) {
      System.out.println(stringQueue.poll());
    }

  }

}
