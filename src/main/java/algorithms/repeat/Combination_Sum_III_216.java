package algorithms.repeat;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III_216 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    if (n < (k + 1) * k/2) return null;
    List<List<Integer>> result = combinationSum3(k, n, 9);
    return result;

  }

  public List<List<Integer>> combinationSum3(int k, int n, int threshold) {
    if (n < (k + 1) * k/2) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (k == 0 && n == 0) {
      List<Integer> t = new ArrayList<Integer>();
      result.add(t);
      return result;
    }

    for (int i = threshold; i >= 0; i--) {
      if (i <= n) {
        List<List<Integer>>  tmp = combinationSum3(k - 1, n - i, i - 1);
        for(List<Integer> ele : tmp) {
          ele.add(i);
          result.add(ele);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Combination_Sum_III_216 solution = new Combination_Sum_III_216();
    solution.combinationSum3(3, 7);
  }

}
