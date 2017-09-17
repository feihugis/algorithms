package algorithms.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Fei Hu on 9/16/17.
 */
public class Intersection_Of_Two_Arrays_II_350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i < nums1.length; i++)
    {
      if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
      else map.put(nums1[i], 1);
    }

    for(int i = 0; i < nums2.length; i++)
    {
      if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
      {
        result.add(nums2[i]);
        map.put(nums2[i], map.get(nums2[i])-1);
      }
    }

    int[] r = new int[result.size()];
    for(int i = 0; i < result.size(); i++)
    {
      r[i] = result.get(i);
    }

    return r;
  }

  public static void main(String[] args) {
    Intersection_Of_Two_Arrays_II_350 solution = new Intersection_Of_Two_Arrays_II_350();
    int[] input1 = new int[] {1, 2, 3, 2, 2};
    int[] input2 = new int[] {3, 2, 1, 2};
    int[] result = solution.intersect(input1, input2);
    System.out.println(Arrays.toString(result));
  }

}
