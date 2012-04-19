package scjp;

import java.io.Console;

public class NewConsole {
  public static void main(String[] args) {
    Console c = System.console();
    char[] pw;
    pw = c.readPassword("%s", "pwd:");
    for (char ch:pw) c.format("%c ", ch);
    c.format("\n");
    
    while (true) {
      String name = c.readLine("%s", "input?: ");
      c.format("output: %s \n", "result="+name);
    }
  }
}
