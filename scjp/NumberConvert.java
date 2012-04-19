package scjp;

public class NumberConvert {
  public static void main(String[] args) {
   p("atoi: s=89712121  ==>"+atoi("89712121"));
   p("itoa: i=109232312  ==>"+itoa(109232312));
   int []numbers = {124,1235,190,290,37,1213};
   int []bases = {2,3,8,16};
   for (int i:numbers) for (int b: bases)  p("toBaseN: i=",i, " base=",b," =",toBaseN(i,b));
   String[] strs = {"0A812EF1", "01276521","122210012"};
   int bases2[] = {16,8,3};
   for (int i=0;i<3;i++) p("fromBaseN: s=",strs[i]," base=",bases2[i]," =",fromBaseN(strs[i],bases2[i]));      
  }

  public static void p(Object...o) {
    StringBuilder sb=new StringBuilder();
    for (Object o1:o) sb.append(o1);
    System.out.println(sb.toString());
  }
      

  public static int atoi(String s) {
    char d[] = s.toCharArray();
    boolean neg = false;
    if (d[0]=='-') neg=true;
    int sum = 0;
    for (int i=(neg?1:0);i<d.length;i++) {
      sum = sum*10 + (d[i]-'0');
    }
    return neg? sum*(-1):sum;
  }

  public static String itoa(int i) {
    String s=i>0? "":"-";
    i = i>0? i: i*(-1);

    while (i>0) {
      s = (i%10)+s;
      i = i/10;
    }
    return s;
  }

  /** support i>0 */
  static String BASE = "0123456789ABCDEF";
  static char B[] = BASE.toCharArray(); 
  public static String toBaseN(int i, int b) {
    String s = "";
    while (i>0) {
      s = B[(i%b)]+s;
      i = i/b;
    }
    return s;
  }

  /* suppose s is from positive number */
  public static int fromBaseN(String s, int b){
    char d[] = s.toCharArray();
    int sum = 0;
    for (int i=0;i<d.length;i++) {
      sum = sum*b + BASE.indexOf(d[i]);
    }
    return sum;
  }
}
