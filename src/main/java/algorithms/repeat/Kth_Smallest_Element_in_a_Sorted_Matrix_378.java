package algorithms.repeat;

import java.util.PriorityQueue;

/**
 * Created by Fei Hu on 9/17/17.
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {
  class Tuple implements Comparable<Tuple> {
    int x, y, val;

    public Tuple(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    @Override
    public int compareTo (Tuple o1) {
      return this.val < o1.val? -1 : 1;
    }
  }

  public int kthSmallest_heap(int[][] matrix, int k) {
    int n = matrix[0].length;
    PriorityQueue<Tuple> priorityQueue = new PriorityQueue<Tuple>();
    for (int i = 0; i < n; i++) priorityQueue.offer(new Tuple(0, i, matrix[0][i]));
    for (int i = 0; i < k - 1; i++) {
      Tuple tuple = priorityQueue.poll();
      if (tuple.x + 1 == n -1) continue;
      priorityQueue.offer(new Tuple(tuple.x+1, tuple.y, matrix[tuple.x+1][tuple.y]));
    }

    return priorityQueue.poll().val;
  }

  public int kthSmallest_binarySearch(int[][] matrix, int k) {
    int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
    while(lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int count = 0,  j = matrix[0].length - 1;
      for(int i = 0; i < matrix.length; i++) {
        while(j >= 0 && matrix[i][j] > mid) j--;
        count += (j + 1);
      }
      if(count < k) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    queue.offer(1);
    queue.offer(3);
    queue.offer(2);
    System.out.println(queue.peek());

    Kth_Smallest_Element_in_a_Sorted_Matrix_378 solution = new Kth_Smallest_Element_in_a_Sorted_Matrix_378();
    int[][] matrix = new int[][]{{1,  5,  9},
                                 {10, 11, 13},
                                 {12, 13, 15}};
    System.out.println(solution.kthSmallest_heap(matrix, 3));
    System.out.println(solution.kthSmallest_binarySearch(matrix, 3));
  }

}
