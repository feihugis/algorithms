package algorithms.repeat;

public class Graph_Valid_Tree_261 {
  public boolean validTree(int n, int[][] edges) {
    if (n == 1) return true;
    if (n <= 0 || edges == null || edges.length == 0 || edges[0].length == 0) return false;
    int[] parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

    for (int i = 0; i < edges.length; i++) {
      int n1 = edges[i][0], n2 = edges[i][1];
      int p1 = findParent(parents, n1);
      int p2 = findParent(parents, n2);
      if (p1 == p2) {
        return false;
      } else {
        parents[p1] = p2;
        n--;
      }
    }

    return n == 1 ;
  }

  public int findParent(int[] parents, int child) {
    while (parents[child] != child) {
      parents[child] = parents[parents[child]];
      child = parents[child];
    }
    return child;
  }
}
