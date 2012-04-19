package SCJP6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jbu
 */

public class T1 {

  public static void main(String[] args) {
    try {
      try {
        throw new IOException();
      } catch (Exception e) {
        System.out.println("caught exception, throw IOException");
        throw new IOException();
      }  finally {
        if (true) {
          System.out.println("finally, throw ClassNotFoundException");
          throw new ClassNotFoundException();
        } else if (false) {
          System.out.println("finally, throw InterruptedException");
          throw new InterruptedException();
        } else
        throw new IOException();
      }
    } catch (InterruptedException t) {
      System.out.println("caught InterruptedException");

    } catch (ClassNotFoundException e) {
      System.out.println("caught ClassNotFoundException");

    } catch (IOException e) {

    }  catch (RuntimeException e) {
      System.out.println("caught RuntimeException");

    }  catch (Exception e) {

    }
  }

}

