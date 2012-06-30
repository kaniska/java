package fb.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * @author: mindpower
 * @since: 6/3/12-10:39 AM
 */

public class Toposort {
  static class NodeFactory {
    static HashMap<String, Node> map = new HashMap<String, Node>();

    public static Node Node(String s) {
      if (map.containsKey(s)) return map.get(s);
      Node n = new Node(s);
      map.put(s, n);
      return n;
    }
  }

  static class Node {
    public final String name;
    public final HashSet<Edge> inEdges;
    public final HashSet<Edge> outEdges;

    public Node(String name) {
      this.name = name;
      inEdges = new HashSet<Edge>();
      outEdges = new HashSet<Edge>();
    }

    public Node addEdge(Node node) {
      Edge e = new Edge(this, node);
      outEdges.add(e);
      node.inEdges.add(e);
      return this;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  static class Edge {
    public final Node from;
    public final Node to;

    public Edge(Node from, Node to) {
      this.from = from;
      this.to = to;
    }

    @Override
    public boolean equals(Object obj) {
      Edge e = (Edge) obj;
      return e.from == from && e.to == to;
    }
  }

  public static Node[] toposort_DFS(Node[] allNodes) {
    HashSet<Node> visited = new HashSet<Node>();
    Deque<Node> order = new ArrayDeque<Node>();
    HashSet<Node> S = new HashSet<Node>();
    for (Node n : allNodes) {
      //   if (n.inEdges.size() == 0) {
      S.add(n);
      //   }
    }
    for (Node n : S) {
      if (visited.contains(n)) continue;
      toposort_DFS(n, visited, order);
    }
    System.out.println("Toposort DFS: =" + order);
    return order.toArray(new Node[0]);
  }

  public static void toposort_DFS(Node n, HashSet<Node> visited, Deque<Node> order) {
    if (visited.contains(n)) return;
    visited.add(n);
    for (Edge e : n.inEdges) {
      toposort_DFS(e.from, visited, order);
    }
    order.addLast(n);
  }

  public static Node[] toposort(Node[] allNodes) {
    //L <- Empty list that will contain the sorted elements
    ArrayList<Node> L = new ArrayList<Node>();
    //S <- Set of all nodes with no incoming edges
    HashSet<Node> S = new HashSet<Node>();
    for (Node n : allNodes) {
      if (n.inEdges.size() == 0) {
        S.add(n);
      }
    }
    //while S is non-empty do
    while (!S.isEmpty()) {
      //remove a node n from S
      Node n = S.iterator().next();
      S.remove(n);
      //insert n into L
      L.add(n);
      //for each node m with an edge e from n to m do
      for (Iterator<Edge> it = n.outEdges.iterator(); it.hasNext(); ) {
        //remove edge e from the graph
        Edge e = it.next();
        Node m = e.to;
        it.remove();//Remove edge from n
        m.inEdges.remove(e);//Remove edge from m
        //if m has no other incoming edges then insert m into S
        if (m.inEdges.isEmpty()) {
          S.add(m);
        }
      }
    }
    //Check to see if all edges are removed
    boolean cycle = false;
    for (Node n : allNodes) {
      if (!n.inEdges.isEmpty()) {
        cycle = true;
        break;
      }
    }
    System.out.println("Topological Sort (not final, cycle possible): " + Arrays.toString(L.toArray()));
    if (cycle) {
      System.out.println("Cycle present, topological sort not possible");
      return null;
    }
    else {
      System.out.println("Topological Sort: " + Arrays.toString(L.toArray()));
      return L.toArray(new Node[0]);
    }
  }

  public static void main(String[] args) {
    Node seven = new Node("7");
    Node five = new Node("5");
    Node three = new Node("3");
    Node eleven = new Node("11");
    Node eight = new Node("8");
    Node two = new Node("2");
    Node nine = new Node("9");
    Node ten = new Node("10");
    seven.addEdge(eleven).addEdge(eight);
    five.addEdge(eleven);
    three.addEdge(eight).addEdge(ten);
    eleven.addEdge(two).addEdge(nine).addEdge(ten);
    eight.addEdge(nine).addEdge(ten);
    Node[] allNodes = {seven, five, three, eleven, eight, two, nine, ten};
    toposort(allNodes);
    Set<Node> alphaNodes = new HashSet<Node>();
    try {
      BufferedReader br = new BufferedReader(new FileReader("/Users/junjie.bu/Downloads/dict.txt"));
//      BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
      String line, preline = null;
      while ((line = br.readLine()) != null) {
        line = line.toLowerCase();
        if (preline != null) {
          for (int i = 0; i < line.length() && i < preline.length(); i++) {
            if (line.charAt(i) != preline.charAt(i) && line.charAt(i) != '-' && preline.charAt(i) != '-') {
              String s2 = "" + line.charAt(i);
              String s1 = "" + preline.charAt(i);
              Node n1 = NodeFactory.Node(s1);
              Node n2 = NodeFactory.Node(s2);
              n1.addEdge(n2);
              alphaNodes.add(n1);
              alphaNodes.add(n2);
              break;
            }
          }
        }
        preline = line;
      }
    }
    catch (Exception e) {
    }
    System.out.println(alphaNodes);
    Node[] alphaNodesArray = alphaNodes.toArray(new Node[0]);
//    toposort(alphaNodesArray);
    toposort_DFS(alphaNodesArray);
  }
}