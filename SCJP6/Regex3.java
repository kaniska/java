package SCJP6;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Regex3 {
  public static void main(String[] args) {
    Console c = System.console();
    String regex, input;
    while (true) {
      regex = c.readLine("%s", "Regex>>");
      Pattern p = Pattern.compile(regex);
      while (true) {
        input = c.readLine("%s", "Input>>");
        if (input==null || input.isEmpty()) break;
        Matcher m = p.matcher(input);
        System.out.println("Found the following matches:");
        while (m.find()) {
          System.out.println(m.start()+"  >"+m.group()+"<");
        }
      }
    }
  }
}
