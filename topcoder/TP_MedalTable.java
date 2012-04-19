package topcoder;

import java.util.*;

public class TP_MedalTable {
  public static void main(String[] args) {
    String s[][] = new String[3][];
    s[0] = new String[]{"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};
    s[1] = new String[]{"USA AUT ROM"};
    s[2] = new String[]{"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"};
    for (String[] s1:s) System.out.println(Arrays.toString(generate(s1)));
  }

  public static String[] generate(String[] results) {
    List<Country> list = new ArrayList<Country>();
    for (String s:results) {
      String c[] = s.split(" ");
      for (int i=0;i<3;i++) {      
        Country ct = new Country(c[i],0,0,0);
        if (!list.contains(ct)) list.add(ct);
        int idx = list.indexOf(ct);
        ct = list.get(idx);
        switch (i) {
          case 0: ct.gold++; break;
          case 1: ct.silver++; break;
          case 2: ct.bronze++; break;
          default: break;
        }
      }
    }
    Collections.sort(list);
    String[] r = new String[list.size()];
    for (int i=0;i<list.size();i++) r[i] = list.get(i).toString();
    return r;
  }

}

