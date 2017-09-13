package algorithms.repeat;

import java.util.Arrays;

/**
 * Created by Fei Hu on 9/12/17.
 */
public class Kth_Largest_Element_in_An_Array_215 {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    int left = 0, right = nums.length - 1;
    int result;
    while ( left < right) {
      result = exchange(nums, left, right);
      System.out.println("Index is: " + result + "; left is " + left + "; right is " + right + "; Array is: " + Arrays.toString(nums));
      if (result <= nums.length - k) {
        left = result;
      } else if (result > nums.length - k){
        right = result - 1;
      }
    }


    return nums[nums.length - k];
  }

  public int exchange(int[] nums, int left, int right) {
    int val = nums[(left + right) / 2];
    while (left <= right) {
      while(nums[left] < val) {
        left++;
      }

      while(nums[right] > val) {
        right--;
      }

      if (left <= right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        left++;
        right--;
      }
    }

    return left;
  }

  public static void main(String[] args) {
    Kth_Largest_Element_in_An_Array_215 solution = new Kth_Largest_Element_in_An_Array_215();
    int[] nums = new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
    int k = 2;
    System.out.println(solution.findKthLargest(nums, k));
  }

}
