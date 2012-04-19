package test;

/**
 * @author jbu
 */

/** Use the Collections.sort to sort a List
**
** When you need natural sort order you can implement
** the Comparable interface.
**
** If You want an alternate sort order or sorting on different properties
* then implement a Comparator for your class.
*/

import java.util.*;

 public class Farmers implements Comparable
 {
 String name;
 int age;
 long income;

 public Farmers(String name, int age)
 {
   this.name = name;
   this.age = age;
 }

 public Farmers(String name, int age,long income)
 {
   this.name = name;
   this.age = age;
   this.income=income;
 }
 public String getName()
 {
   return name;
 }

 public int getAge()
 {
   return age;
 }

 public String toString()
 {
   return name + " : " + age;
 }

 /*
  ** Implement the natural order for this class
  */
 public int compareTo(Object o)
 {
   return getName().compareTo(((Farmers)o).getName());
 }

 static class AgeComparator implements Comparator
 {

   /*
    * (non-Javadoc)
    * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
    *
    */
   public int compare(Object o1, Object o2)
   {
     Farmers p1 = (Farmers)o1;
     Farmers p2 = (Farmers)o2;
     if(p1.getIncome()==0 && p2.getIncome()==0 )
       return p1.getAge() - p2.getAge();
     else
       return (int)(p1.getIncome() -p2.getIncome());
   }
 }

 public static void main(String[] args)
 {

   List farmer = new ArrayList();
   farmer.add( new Farmers("Joe", 34) );
   farmer.add( new Farmers("Ali", 13) );
   farmer.add( new Farmers("Mark", 25) );
   farmer.add( new Farmers("Dana", 66) );

   Collections.sort(farmer);
   System.out.println("Sort in Natural order");
   System.out.println("t" + farmer);

   Collections.sort(farmer, Collections.reverseOrder());
   System.out.println("Sort by reverse natural order");
   System.out.println("t" + farmer);

   List farmerIncome = new ArrayList();
   farmerIncome.add( new Farmers("Joe", 34,33));
   farmerIncome.add( new Farmers("Ali", 13,3));
   farmerIncome.add( new Farmers("Mark", 25,666));
   farmerIncome.add( new Farmers("Dana", 66,2));

   Collections.sort(farmer, new AgeComparator());
   System.out.println("Sort using Age Comparator");
   System.out.println("t" + farmer);

   Collections.sort(farmerIncome, new AgeComparator());
   System.out.println("Sort using Age Comparator But Income Wise");
   System.out.println("t" + farmerIncome);

 }

 public long getIncome() {
   return income;
 }

 public void setIncome(long income) {
   this.income = income;
 }

 public void setAge(int age) {
   this.age = age;
 }

 public void setName(String name) {
   this.name = name;
 }
 }

