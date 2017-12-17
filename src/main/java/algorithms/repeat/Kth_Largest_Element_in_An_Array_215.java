package algorithms.repeat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Fei Hu on 9/12/17.
 */
public class Kth_Largest_Element_in_An_Array_215 {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    int left = 0, right = nums.length - 1;

    while(left <= right) {
      int cur = exchange(nums, left, right);
      if (cur < nums.length - k) {
        left = cur + 1;
      }
      else if (cur > nums.length - k){
        right = cur - 1;
      } else {
        return nums[cur];
      }
    }
    return -1;
  }

  public int exchange(int[] nums, int left, int right) {
    int val = nums[right];
    int i = left - 1;
    for (int j = left; j <= right - 1; j++) {
      if (nums[j] < val) {
        i++;
        swap(nums, i, j);
      }
    }

    swap(nums, right, i+1);
    return i+1;
  }

  public void swap(int[] nums, int i , int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int i = 0; i < nums.length; i++) {
      if (heap.size() < k) {
        heap.add(nums[i]);
      } else {
        if (heap.peek() < nums[i]) {
          heap.poll();
          heap.add(nums[i]);
        }
      }
    }
    return heap.peek();
  }

  public static void main(String[] args) {
    Kth_Largest_Element_in_An_Array_215 solution = new Kth_Largest_Element_in_An_Array_215();

    int[] nums = {5,2,4,1,3,6,0};
    int k = 4;
    System.out.println(solution.findKthLargest(nums, k));
    System.out.println(solution.findKthLargest2(nums, k));
    
  }

}
