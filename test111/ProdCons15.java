package test111;

/*
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 1996-2002.
 * All rights reserved. Software written by Ian F. Darwin and others.
 * $Id: LICENSE,v 1.8 2004/02/09 03:33:38 ian Exp $
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * Java, the Duke mascot, and all variants of Sun's Java "steaming coffee
 * cup" logo are trademarks of Sun Microsystems. Sun's, and James Gosling's,
 * pioneering role in inventing and promulgating (and standardizing) the Java
 * language and environment is gratefully acknowledged.
 *
 * The pioneering role of Dennis Ritchie and Bjarne Stroustrup, of AT&T, for
 * inventing predecessor languages C and C++ is also gratefully acknowledged.
 */

import java.security.SecureRandom;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * Producer-Consumer in Java, for J2SE 1.5 using concurrent.
 */
public class ProdCons15 {

  protected boolean done = false;

  /**
   * Inner class representing the Producer side
   */
  class Producer implements Runnable {

    protected BlockingQueue queue;
    private String name;

    Producer(BlockingQueue theQueue, int name) {
      this.queue = theQueue;
      this.name = "Producer #"+name;
    }

    public void run() {
      try {
        while (true) {
          Object justProduced = getRequestFromNetwork();
          queue.put(justProduced);
          System.out.println(name+ " Produced object: "+justProduced+" | List size now " + queue.size());
          if (done) {
            return;
          }
        }
      } catch (InterruptedException ex) {
        System.out.println("Producer INTERRUPTED");
      }
    }

    private SecureRandom random = new SecureRandom();

    private RandomString r = new RandomString(6);

    Object getRequestFromNetwork() {  // Simulation of reading from client
      try {
        Thread.sleep((long) (Math.random() * 1000)); // simulate time passing during read
      } catch (InterruptedException ex) {
        System.out.println("Producer Read INTERRUPTED");
      }
//      return new BigInteger(130, random).toString(32);
      return r.nextString();
    }
  }

  /**
   * Inner class representing the Consumer side
   */
  class Consumer implements Runnable {
    protected BlockingQueue queue;
    private String name ;

    Consumer(BlockingQueue theQueue, int name) {
      this.queue = theQueue;
      this.name = "Consumer #"+name;
    }

    public void run() {
      try {
        while (true) {
          Thread.sleep((long) (Math.random() * 1000)); // simulate time passing during read
          Object obj = queue.take();
          int len = queue.size();
          System.out.println("List size now " + len);
          process(obj);
          if (done) {
            return;
          }
        }
      } catch (InterruptedException ex) {
        System.out.println("CONSUMER INTERRUPTED");
      }
    }

    void process(Object obj) {
      // Thread.sleep(xxx) // Simulate time passing
      System.out.println(name+ " Consuming object " + obj);
    }
  }

  ProdCons15(int nP, int nC) {
    BlockingQueue myQueue = new LinkedBlockingQueue();
    for (int i = 0; i < nP; i++) {
      new Thread(new Producer(myQueue, i+1)).start();
    }
    for (int i = 0; i < nC; i++) {
      new Thread(new Consumer(myQueue, i+1)).start();
    }
  }

  public static void main(String[] args)
    throws IOException, InterruptedException {

    // Start producers and consumers
    int numProducers = 4;
    int numConsumers = 8;
    ProdCons15 pc = new ProdCons15(numProducers, numConsumers);

    // Let the simulation run for, say, 10 seconds
    Thread.sleep(5 * 1000);

    // End of simulation - shut down gracefully
    pc.done = true;
  }
}

class RandomString {

  private static final char[] symbols = new char[36];

  static {
    for (int idx = 0; idx < 10; ++idx) {
      symbols[idx] = (char) ('0' + idx);
    }
    for (int idx = 10; idx < 36; ++idx) {
      symbols[idx] = (char) ('A' + idx - 10);
    }
  }

  private final Random random = new Random();

  private final char[] buf;

  public RandomString(int length) {
    if (length < 1) {
      throw new IllegalArgumentException("length < 1: " + length);
    }
    buf = new char[length];
  }

  public String nextString() {
    for (int idx = 0; idx < buf.length; ++idx) {
      buf[idx] = symbols[random.nextInt(symbols.length)];
    }
    return new String(buf);
  }

}
