package algorithms.repeat;

public class Number_of_Connected_Components_in_an_Undirected_Graph_323 {
  public int countComponents(int n, int[][] edges) {
    if (edges == null || edges.length == 0 || edges[0].length == 0) return n;

    int[] root = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
    }

    for (int i = 0; i < edges.length; i++) {
      int from = edges[i][0], to = edges[i][1];
      int child1 = findRoot(root, from);
      int child2 = findRoot(root, to);
      if (child1 != child2) {
        root[child1] = child2;
        n--;
      }
    }
    return n;
  }

  public int findRoot(int[] root, int child) {
    while(root[child] != child) {
      root[child] = root[root[child]];
      child = root[child];
    }
    return child;
  }
}
