package com.shixi.leetcode.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei Hu on 9/2/17.
 */
public class Permutation_Sequence_60 {
  public String getPermutation(int n, int k) {
    List<Integer> array = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      array.add(i+1);
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; i++) {
      long len = getNum(n - 1 - i);
      int index = (int) Math.ceil(k*1.0/len) - 1;
      int first = array.get(index);
      array.remove(index);
      result.append(String.valueOf(first));
      k = (int) (k % len > 0? k%len : len);
    }
    return result.toString();
  }

  public long getNum(int n) {
    long result = 1;
    for (int i = n; i >= 1; i--) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) {
    Permutation_Sequence_60 solution = new Permutation_Sequence_60();
    System.out.println(solution.getPermutation(3, 2));
    List<Integer> array = new ArrayList<>();
    array.add(0);
    array.add(1);
    array.add(2);
    System.out.println(array);
    array.add(1, 3);
    System.out.println(array);
    Integer[] tmp = new Integer[array.size()];
    array.toArray(tmp);
    Arrays.sort(tmp, 1, 3+1);
    System.out.println(Arrays.toString(tmp));


  }

}
