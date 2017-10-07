package algorithms.repeat;

import java.util.Stack;

public class Longest_Increasing_Path_in_a_Matrix_329 {
  public static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int h = matrix.length, w = matrix[0].length;

    int[][] outdegree = new int[matrix.length][matrix[0].length];
    Stack<int[]> seeds = new Stack<int[]>();
    Stack<int[]> next = new Stack<int[]>();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        for (int[] dir : dirs) {
          int row = i + dir[0], col = j + dir[1];
          if (row >= 0 && row < h && col >= 0 && col < w && matrix[i][j] < matrix[row][col]) {
            outdegree[i][j]++;
          }
        }

        if (outdegree[i][j] == 0) {
          seeds.push(new int[]{i,j});
        }
      }
    }

    int height = 0;
    while (!seeds.isEmpty()) {
      int[] node = seeds.pop();
      for (int[] dir : dirs) {
        int row = node[0] + dir[0], col = node[1] + dir[1];
        if (row >= 0 && row < h && col >= 0 && col < w && matrix[node[0]][node[1]] > matrix[row][col]) {
          outdegree[row][col]--;
          if (outdegree[row][col] == 0) {
            next.add(new int[]{row, col});
          }
        }
      }
      if (seeds.isEmpty()) {
        seeds.addAll(next);
        height++;
        next.clear();
      }
    }
    return height;
  }

  public static void main(String[] args) {
    Longest_Increasing_Path_in_a_Matrix_329 solution = new Longest_Increasing_Path_in_a_Matrix_329();
    int[][] nums = {{3, 4, 5},
                    {3, 2, 6},
                    {2, 2, 1}};
    System.out.println(solution.longestIncreasingPath(nums));
  }



}
