package scjp.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jbu
 */
public class TestDogsEnum {
  public enum Dogs {collie, harrie, shepherd};

  public static void main(String args[]) {
    Dogs myDog = Dogs.shepherd;

    switch (myDog) {
      case collie:
         System.out.println("collie");
      default:
        System.out.println("collie");
    }


    ArrayList<String> x1 = new ArrayList<String>();
//    foo(x1);

//    ArrayList<Object> x2 = new ArrayList<String>();
//    foo(x1);

    ArrayList x4 = new ArrayList();
    foo(x4);
    try {
      new BufferedReader(new FileReader("aa")) ;
      new PrintWriter(new BufferedWriter(new PrintWriter(new FileWriter("aa"))));

    } catch (FileNotFoundException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (IOException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }

  public static void foo(List<Object> list) {

  }

}
