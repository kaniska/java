package SCJP6;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jbu
 */
public class ListFiles {

  public static void listAndPrint(String name, String indent) {
    File d = new File(name);
    if (!d.exists()) {
      System.out.println("No exist");
      return;
    }
    if (d.getName().startsWith(".")) {
      return;
    }
    if (d.isDirectory()) {
      String[] files = d.list();
      if (files == null || files.length == 0) {
        System.out.format("%s-%s\n", indent, d.getName());
      } else {
        System.out.format("%s+%s\n", indent, d.getName());
      }

      for (String s : files) {
        listAndPrint(d.getAbsolutePath() + "/" + s, indent + "  ");
      }
    } else {
      System.out.format("%s|-%s %d bytes\n", indent, d.getName(), d.length());
    }

  }

  public static void main(String args[]) {
    File f = new File("XXX");
    StringBuffer sb = new StringBuffer("AAA");
    System.out.println(sb + " ");
    BufferedReader bf;
    Object a = new Object();
    Set<String> ss = new HashSet<String>();
    ss.add("Hello");
    ss.add("Hello");
    ss.add("Hello1");
    System.out.println(ss);

    List<String> test = new ArrayList<String>();
    String s = "hi";
    test.add("string");
    test.add(new Integer(42).toString());
    test.add(s);
    test.add(s + s);
    System.out.println(test.size());
    System.out.println(test.contains(42));
    System.out.println(test.contains("hihi"));
    test.remove("hi");
    System.out.println(test.size());

    Console c1 = System.console();
    Integer s1 = new Integer(33);
    Integer s2 = new Integer(33);
    System.out.println("CCC" + (s1 == s2));
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(5);
    System.out.println(nf.format(1.123456d));
    try {
      System.out.println(nf.parse("1.123456"));
    } catch (ParseException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

    System.out.println("IsFile = " + f.isFile());
    listAndPrint("AgentClient", "");
    Date d = new Date();
    Calendar c = Calendar.getInstance();
    System.out.println("1st Date time is " + d.toString());
    c.setTime(d);
    if (Calendar.SUNDAY == c.getFirstDayOfWeek()) {
      System.out.println("First day of week is Sunday");
      System.out.println("Current day of week is " + c.get(Calendar.DAY_OF_WEEK) + "; day of year " + c.get(Calendar.DAY_OF_YEAR));
    }
    //  c.add(Calendar.MONTH, 3);
    c.roll(Calendar.DAY_OF_WEEK, 100);
    Date d2 = c.getTime();
    System.out.println("2nd date is " + d2.toString());

    DateFormat df = DateFormat.getDateTimeInstance();
    System.out.println(df.format(d2));

    String sd = df.format(d2);

    try {
      Date d3 = df.parse(sd);
      p("d3=", d3);
    } catch (ParseException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

    DateFormatWithLocale();
    NumberFormatWithLocale();
    Pattern();
  }

  public static void DateFormatWithLocale() {
    Calendar c = Calendar.getInstance();
    c.set(2011, 12, 31);
    Date d = c.getTime();

    Locale l1 = new Locale("en", "US");
    Locale l2 = new Locale("it", "IT");
    Locale l3 = Locale.CHINA;

    DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, l1);
    DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, l2);
    DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, l3);

    p("df1=", df1.format(d));
    p("df2=", df2.format(d));
    p("df3=", df3.format(d));
    p("l1 ", l1.getDisplayLanguage(), l1.getDisplayCountry());
    p("l1.l2 ", l1.getDisplayLanguage(l2), l1.getDisplayCountry(l2));
    p("l1.l3 ", l1.getDisplayLanguage(l3), l1.getDisplayCountry(l3));

    p("l1.l3 ", l2.getDisplayLanguage(l3), l2.getDisplayCountry(l3));

    p("l3 ", l3.getDisplayLanguage(l3), l3.getDisplayCountry(l3));
    p("l3.l1 ", l3.getDisplayLanguage(l1), l3.getDisplayCountry(l1));
    p("l1.l2 ", l3.getDisplayLanguage(l2), l3.getDisplayCountry(l2));

  }

  public static void NumberFormatWithLocale() {
    float f = 123.23125f;
    Locale l = Locale.ENGLISH;
    NumberFormat nf = NumberFormat.getInstance(l);
    p(nf.getMaximumFractionDigits());
    p(nf.format(f));
    nf.setMaximumFractionDigits(5);
    p(nf.format(f));
    try {
      p("P", nf.parse("32314.121f").getClass());
      nf.setParseIntegerOnly(true);
      p(nf.parse("314.1213").getClass());
    } catch (ParseException e) {
      p("Parse exception");
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

  }

  public static void Pattern() {
    Pattern pattern = Pattern.compile("H[[a-e]&&[x-z]]llo");
    CharSequence inputStr = "Hello H8llo Hxllo Hzllo H_llo";
    Matcher matcher = pattern.matcher(inputStr);

    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      System.out.println("Pattern found:  " + inputStr.subSequence(start, end).toString());
    }

  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o).append(" ");
    }
    System.out.println(sb.toString());
  }

}
