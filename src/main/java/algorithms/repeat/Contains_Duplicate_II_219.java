package algorithms.repeat;

import java.util.HashMap;

/**
 * Created by Fei Hu on 8/18/17.
 */
public class Contains_Duplicate_II_219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length <= 1) return false;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) return true;
         map.put(nums[i], i);
      }
    }

    return false;
  }

}
