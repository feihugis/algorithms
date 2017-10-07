package algorithms.repeat;

public class Friend_Circle_547 {
  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) return 0;
    int n = M.length;
    int[] relation = new int[n];
    for (int i = 0; i < n; i++) {
      relation[i] = i;
    }

    int circles = n;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (M[i][j] == 1) {
          int p1 = findParent(relation, i);
          int p2 = findParent(relation, j);
          if (p1 != p2) {
            relation[p1] = p2;
            circles--;
          }
        }
      }
    }
    return circles;
  }

  public int findParent(int[] relation, int id) {
    while (relation[id] != id) {
      relation[id] = relation[relation[id]];
      id = relation[id];
    }
    return id;
  }

}
