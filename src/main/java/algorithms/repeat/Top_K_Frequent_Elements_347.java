package algorithms.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fei Hu on 9/16/17.
 */
public class Top_K_Frequent_Elements_347 {

  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || k > nums.length) return null;

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        int count = map.get(num) + 1;
        map.put(num, count);
      } else {
        map.put(num, 1);
      }
    }

    List<Integer>[] count = new List[nums.length+1]; //note the grammar here.

    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey(), value = entry.getValue();
      if (count[value] == null) {
        count[value] = new ArrayList<Integer>();
      }
      count[value].add(key);
    }

    List<Integer> result = new ArrayList<Integer>();

    for (int i = count.length - 1; i >= 1; i--) {
      if (count[i] != null) {
        result.addAll(count[i]);
      }

      if (result.size() == k) {
        break;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Top_K_Frequent_Elements_347 solution = new Top_K_Frequent_Elements_347();
    int[] input = new int[]{1, 2};
    solution.topKFrequent(input, 2);
  }

}
