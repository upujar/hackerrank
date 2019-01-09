import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] weight = new long[n];
    for (int i = 0; i < n; i++) {
      weight[i] = sc.nextLong();
    }
    int m = sc.nextInt();
    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    for (int i = 0; i < m; i++) {
      int k = sc.nextInt() - 1;
      if (!adj.containsKey(k)) {
        adj.put(k, new ArrayList());
      }
      ArrayList list = adj.get(k);
      list.add(sc.nextInt() - 1);
      adj.put(k, list);
    }
     /*   for (int i = 0; i < n; i++)
      System.out.println(adj[i]);*/
    boolean[] visited = new boolean[n];
    Stack<Integer> dfsOrder = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfsExplore(i, visited, adj, dfsOrder);
      }
    }
    // System.out.println(dfsOrder);
    Map<Integer, ArrayList<Integer>> reverse = reverseGraph(adj, n);

    visited = new boolean[n];
    List<List<Long>> componentsRev = new ArrayList<>();
    while (!dfsOrder.isEmpty()) {
      int k = dfsOrder.pop();
      if (!visited[k]) {
        Stack<Long> list = new Stack<>();
        dfsExploreWeights(k, visited, reverse, list, weight);
        componentsRev.add(list);
      }
    }
     /* for (int i = 0; i < adj.length; i++)
      System.out.println(reverse[i]);*/
    long result = 0;
    for (List<Long> c : componentsRev) {
      result += c.stream().min(Comparator.comparing(Long::valueOf)).get();
    }
    System.out.println(result);
    //  System.out.println(componentsRev);
  }

  static Map<Integer, ArrayList<Integer>> reverseGraph(Map<Integer, ArrayList<Integer>> adj,
      int n) {
    Map<Integer, ArrayList<Integer>> reverse = new HashMap<>();

    for (int i = 0; i < n; i++) {

      if (adj.containsKey(i)) {
        Iterator<Integer> j = adj.get(i).listIterator();
        while (j.hasNext()) {
          int k = j.next();
          if (!reverse.containsKey(k)) {
            reverse.put(k, new ArrayList());
          }
          ArrayList list = reverse.get(k);
          list.add(i);
          reverse.put(k, list);


        }
      }
    }
    return reverse;
  }

  static void dfsExplore(int s, boolean visited[], Map<Integer, ArrayList<Integer>> adj,
      Stack<Integer> dfsOrder) {
    visited[s] = true;
    if (adj.containsKey(s)) {
      Iterator<Integer> i = adj.get(s).listIterator();
      while (i.hasNext()) {
        int k = i.next();
        if (!visited[k]) {
          dfsExplore(k, visited, adj, dfsOrder);
        }
      }
    }
    dfsOrder.push(s);

  }

  static void dfsExploreWeights(int s, boolean visited[], Map<Integer, ArrayList<Integer>> adj,
      Stack<Long> dfsOrder, long[] weights) {
    visited[s] = true;
    dfsOrder.push(weights[s]);
    if (adj.containsKey(s)) {
      Iterator<Integer> i = adj.get(s).listIterator();
      while (i.hasNext()) {
        int k = i.next();
        if (!visited[k]) {
          dfsExploreWeights(k, visited, adj, dfsOrder, weights);
        }
      }
    }
  }


}
