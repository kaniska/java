package topcoder;

/**
 * @author jbu
 */
class Country implements Comparable<Country>{
  String name;
  int gold;
  int silver;
  int bronze;

  public Country(String name, int gold, int silver, int bronze){
    this.name = name;
    this.gold = gold;
    this.silver = silver;
    this.bronze = bronze;
  }

  public int compareTo(Country m) {
    if (m.gold!=gold) return m.gold-gold;
    if (m.silver!=silver) return m.silver-silver;
    if (m.bronze!=bronze) return m.bronze-bronze;
    return m.name.compareTo(name);
  }

  public boolean equals(Object o) {
    Country m = (Country)o;
//    System.out.println("m.name="+m.name+" name="+name+" ==?"+m.name.equals(name));
    return m.name.equals(name);
  }

  public int hashCode(){ return name.hashCode(); }

  public String toString() {
    return name+" "+gold+" "+silver+" "+bronze;
  }
}
