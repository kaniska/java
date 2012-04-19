package SCJP6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jbu
 */
public class Simple {

  final public void Simple() {
  }

  public static void main(String args[]) {
    int a =3;
    int count =0;
    if ( !(a>1) && ++count >0) {
      System.out.println("good - a="+a+"  count="+count) ;
    }
    System.out.println("out - a="+a+"  count="+count) ;

    try {
      File f = new File("AAA","myfile.txt");

      f.createNewFile();

    } catch (FileNotFoundException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (IOException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }

}
