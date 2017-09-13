package algorithms.repeat;

import java.util.Arrays;

/**
 * Created by Fei Hu on 9/2/17.
 */
public class Next_Permutation_31 {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 1) return;
    int location = nums.length - 1;
    for (; location >= 1; location--) {
      if (nums[location] > nums[location - 1]) {
        int left = location - 1, right = location;
        while (right+1 < nums.length && nums[right+1] > nums[left]) {
          right++;
        }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        //Arrays.sort(nums, left + 1, nums.length);
        reverse(nums, left+1, nums.length - 1);
        return;
      }
    }
    reverse(nums, 0, nums.length - 1);
  }

  public void reverse(int[] nums, int left, int right) {
    while (left <= right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
      left++;
      right--;
    }
  }

}
