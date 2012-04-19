package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbu
 */
public enum Language {
  ENGLISH("ENG"),
  CHINESE("CHN"),
  SPANISH("SPA");

  private String name;

  Language(String name) {
    this.name = name;
  }

  public Language getByName(String name) {
    for (Language l: Language.values())  {
      if (l.name.equals(name)) {
        return l;
      }
    }
    throw new IllegalArgumentException();
  }

  public static void main(String args[]) {
    System.out.println(Language.CHINESE);
    System.out.println(Language.ENGLISH.name);
    Language l = Language.CHINESE;
    switch (l) {
      case ENGLISH: System.out.println("Hellow Wello");
        case CHINESE: System.out.println("Nihao");
        //  default: System.out.println("bye");
    }

  }
}

class Test{

  private static Language ll = Language.CHINESE;
  public static void main(String args[]) {
    System.out.println(ll.name());
    System.out.println(Language.valueOf("ENGLISH"));

    System.out.println(Language.valueOf("ENG"));
    List<String>  aa = new ArrayList<String>();
    

  }

}
