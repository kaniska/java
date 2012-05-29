package fb.design;

import java.util.LinkedList;

/**
 * @author: mindpower
 * @since: 5/19/12-2:01 PM
 */
public class BlockingQueue<T> {
  final static private int DEFAULT_SIZE = 100;
  private int maxSize;

  private LinkedList<T> queue = new LinkedList<T>();

  public BlockingQueue() {
    this(DEFAULT_SIZE);
  }

  public BlockingQueue(int size) {
    maxSize = size;
  }

  public synchronized T take() throws InterruptedException {
    while (true) {
      if (!queue.isEmpty()) {
        T t = queue.poll();
        if (queue.size() == maxSize - 1) {
          notifyAll();
        }
        return t;
      }
      else {
        wait();
      }
    }
  }

  public synchronized void put(T o) throws InterruptedException {
    while (true) {
      if (queue.size() < maxSize) {
        queue.add(o);
        return;
      }
      else {
        wait();
      }
    }
  }

  public static void main(String[] agrs) {
  }
}


