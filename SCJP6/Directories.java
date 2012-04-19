package SCJP6;

import java.io.*;

public class Directories {
  static String[] dirs = { "dir1", "dir2" };
  public static void main(String[] args) {
     for (String d: dirs) {
        File f = new File(d, args[0]);
        System.out.println(f.exists()+" ");
      }
   }
}
