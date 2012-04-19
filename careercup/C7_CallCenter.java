package careercup;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jbu
 */

public class C7_CallCenter  {
  private static int LEVEL = 3;
  private static int NUM_FRESHER = 5;

  ArrayList<Employee>[] employeeLevels = new ArrayList[LEVEL];
  Queue<Call>[] callQueues= new Queue[LEVEL];

  Employee getCallHandler() {
    for (int i=0;i<LEVEL;i++) {
      ArrayList<Employee> employees = employeeLevels[i];
      for (Employee e: employees) {
        if (e.free) return e;
      }
    }
    return null;
  }

  public void dispatchCall(Call c) {

  }
}

class Call {
  int ranking ;
  void reply(String message) {}
  void disconnectCall() {}
}

class Employee {
  String name;
  int id;
  boolean free;
  int rank;  // 0-fresher ; 1 -lead; 2-manager
  C7_CallCenter cc;

  Employee(int rank) {
    this.rank = rank;
  }

  public void receiveCall(Call c) { }
  public void callHandled(Call c) {}
  public void cantHandle(Call c) {
    c.ranking ++;
    cc.dispatchCall(c);
    free = true;
    
  }
}

class Fresher extends Employee {
  public Fresher() {super(0);}
}

class TeamLead extends Employee {
  TeamLead() {super(1);}
}

class ProductManager extends Employee {
  ProductManager() {super(2);}
}
