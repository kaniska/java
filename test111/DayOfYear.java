package test111;

/**
 * @author jbu
 */
public class DayOfYear {
  public static int Mon, Day;

  public static void dayOfYear(int year, int day) {
    int monthDay[] = new int[]{31,28,31,30,31,31,30,31,30,31,30,31};
    if ((year%4==0 && year %100!=0) || (year%400==0)) monthDay[1]=29;
    int i;
    for (i=0; day>monthDay[i] && i<11; day-=monthDay[i++]){System.out.println("i="+i+";day="+day);}
    Mon = i+1; Day = day;

  }


  public static void main(String args[]) {
      dayOfYear(2004, 466);
     System.out.println("Error day="+Day+";month="+Mon);
  }
}
