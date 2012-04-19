package scjp.test;

import java.util.Locale;

/**
 * @author jbu
 */
public class TestLocale {

  static int a = getX();
  static int b = 3;

  static int getX() {
    return b;
  }

  public static void p(Object... s) {
    StringBuilder sb = new StringBuilder();
    for (Object o : s) {
      sb.append(o).append("\t");
    }
    System.out.println(sb.toString());
  }

  public static void main(String args[]) {
    p("Locale.getDefault()=Locale.US", Locale.US==Locale.getDefault());

    Locale[] locales =  {Locale.US, Locale.JAPAN, Locale.CHINA, Locale.FRANCE};
    for (Locale l: locales) {
      p(l,l.getDisplayLanguage(), l.getDisplayCountry());
      for (Locale l2: locales) {
        p(l, "==>", l2, l.getDisplayLanguage(l2), l.getDisplayCountry(l2));
      }
    }


    locales = new Locale[] {Locale.ENGLISH, Locale.JAPANESE, Locale.CHINESE, Locale.FRENCH};
    for (Locale l: locales) {
      p(l,l.getDisplayLanguage(), l.getDisplayCountry());
      for (Locale l2: locales) {
        p(l, "==>", l2, l.getDisplayLanguage(l2), l.getDisplayCountry(l2));
      }
    }

  }
}
