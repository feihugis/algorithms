package algorithms.done;

import java.util.HashSet;

public class Array_Nesting_565 {
  public int arrayNesting(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int max = 0;
    HashSet<Integer> visited = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      int index = nums[i];
      while(!visited.contains(index) && count < nums.length) {
        count++;
        visited.add(index);
        index = nums[index];
      }

      if (count == nums.length) {
        return count;
      }

      max = Math.max(max, count);
    }
    return max;
  }

}
