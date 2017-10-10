package algorithms.repeat;

import java.util.HashMap;

public class Subarray_Sum_Equals_K_560 {
  public int subarraySum(int[] nums, int k) {
    if (nums == null) return 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0, 1);
    int sum = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int rest = sum - k;
      if (map.containsKey(rest)) {
        count += map.get(rest);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

}
