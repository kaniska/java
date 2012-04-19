package SCJP6.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jbu
 */
public class TestFile {
  public static void main(String args[]) {
    try {
      FileWriter fw = new FileWriter("aa");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter("bb.txt");
    } catch (IOException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }

}
