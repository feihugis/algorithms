package com.shixi.leetcode.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei Hu on 9/2/17.
 */
public class Permutations_II_47 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    boolean[] visited = new boolean[nums.length];

    if (nums == null || nums.length == 0) return result;
    Arrays.sort(nums);
    subPermuteUnique(nums, visited, result, new ArrayList<Integer>());
    return result;
  }

  public void subPermuteUnique(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> rst) {
    if (rst.size() == nums.length) {
      List<Integer> tmp = new ArrayList<>();
      tmp.addAll(rst);
      result.add(tmp);
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;
      int next = i;
      while (next+1 < nums.length && (visited[next+1] || nums[i] == nums[next+1])) {
        next++;
      }
      rst.add(nums[i]);
      visited[i] = true;
      subPermuteUnique(nums, visited, result, rst);
      visited[i] = false;
      rst.remove(rst.size()-1);
      i = next;
    }
  }

  public static void main(String[] args) {
    int[] input = new int[] {1,1,1,2};
    Permutations_II_47 solution = new Permutations_II_47();
    System.out.println(solution.permuteUnique(input));

  }

}
