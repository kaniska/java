package topcoder;

import java.util.*;

public class DP_SmartWordToy {
  public static void main(String[] args) {
    String s1 = "aaaa";
    String e1 = "zzzz";
    String f1[] = {"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"};

    String s2 = "aaaa";
    String e2 = "bbbb";
    String f2[] = {};

    String s3 = "aaaa";
    String e3 = "mmnn";
    String f3[] = {};

    String s4 = "aaaa";
    String e4 = "zzzz";
    String f4[] = {"bz a a a", "a bz a a", "a a bz a", "a a a bz"};

    String s5 = "aaaa";
    String e5 = "zzzz";
    String f5[] = {"cdefghijklmnopqrstuvwxyz a a a",
      "a cdefghijklmnopqrstuvwxyz a a",
      "a a cdefghijklmnopqrstuvwxyz a",
      "a a a cdefghijklmnopqrstuvwxyz"};

    String s6 = "aaaa";
    String e6 = "bbbb";
    String f6[] = {"b b b b"};

    String s7 = "zzzz";
    String e7 = "aaaa";
    String f7[] = {"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefg" +
				"hijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl a" +
				"bcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk","abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"};

    p(minPress(s1, e1, f1) == 8 ? "T" : "F");
    p(minPress(s2, e2, f2) == 4 ? "T" : "F");
    p(minPress(s3, e3, f3) == 50 ? "T" : "F");
    p(minPress(s4, e4, f4) == -1 ? "T" : "F");
    p(minPress(s5, e5, f5) == 6 ? "T" : "F");
    p(minPress(s6, e6, f6) == -1 ? "T" : "F");
    p(minPress(s7, e7, f7) == -1 ? "T" : "F");
  }

  public static void p(String s) {
    System.out.println(s);
  }

  public static int w2i(String s) {
    char[] c = s.toCharArray();
    int x = 0;
    for (int i=0;i<4;i++) {
      x = x*26;
      x += (c[i]-'a');
    }
 //   System.out.println("s="+s+"   i="+x);
    return x;
  }

  public static String i2w(int x) {
    String r="";
    for (int i=0;i<4;i++) {
      r = (char)('a'+x%26)+r;
    }
    return r;
  }

  public static int minPress(String start, String end, String[] forbids) {
    String ff[][] = new String[forbids.length][];
    for (int i=0;i<forbids.length;i++) {
      ff[i] = forbids[i].split(" ");
    }
    
//    int a1 = w2i("aaaa");
//    int a2 = w2i("zzzz");
//    System.out.println("aaaa="+a1+ " =>"+ i2w(a1));
//    System.out.println("zzzz="+a2+ " =>"+ i2w(a2));
    if (isForbid(ff,end)) return -1;
    int steps[] = new int[26*26*26*26];
    Arrays.fill(steps, 10000);
    steps[w2i(start)] = 0;
    for (int i=0;i<26*26;i++) {
      for (int j=0;j<26*26*26*26;j++) {
        if (steps[j]<10000) {
          String next[] = getNext(i2w(j));
          for (String n: next)
          if ( ! isForbid(ff,n) && steps[j]+1<steps[w2i(n)]) {
            steps[w2i(n)] = steps[j]+1;
         //   System.out.println("n="+n+" w="+w2i(n)+" s="+steps[w2i(n)]);
          }
        }
      }
    }   
    System.out.println(steps[w2i(end)]);
    return steps[w2i(end)]==10000? -1: steps[w2i(end)];
  }

  public static boolean isForbid(String[][] f, String s) {
    for (String[] fs: f) {
      if (fs[0].contains(s.substring(0,1)) && fs[1].contains(s.substring(1,2)) &&
        fs[2].contains(s.substring(2,3)) && fs[3].contains(s.substring(3,4))) return true;
    }
    return false;
  }

  public static String[] getNext(String s) {
    String [] r = new String[8];
    char[] c = s.toCharArray();
    r[0] = ""+getNL(c[0])+c[1]+c[2]+c[3];
    r[1] = ""+c[0]+getNL(c[1])+c[2]+c[3];
    r[2] = ""+c[0]+c[1]+getNL(c[2])+c[3];
    r[3] = ""+c[0]+c[1]+c[2]+getNL(c[3]);
    r[4] = ""+getPL(c[0])+c[1]+c[2]+c[3];                                                                                                               
    r[5] = ""+c[0]+getPL(c[1])+c[2]+c[3];                                                                                                                   
    r[6] = ""+c[0]+c[1]+getPL(c[2])+c[3];                                                                                                                   
    r[7] = ""+c[0]+c[1]+c[2]+getPL(c[3]);
    return r;
  }

  public static char getNL(char c) {
    if (c<'z') return (char)(c+1);
    else return 'a';
  }

  public static char getPL(char c){
    if (c>'a') return (char)(c-1);
    else return 'z';
  }



}

