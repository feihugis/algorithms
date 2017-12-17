package algorithms.repeat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei Hu on 9/2/17.
 */
public class Permutation_Sequence_60 {
  int count = 0;
  StringBuilder result = new StringBuilder();

  public String getPermutation(int n, int k) {
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }

    getPermutation(arr, k, 0);
    return result.toString();
  }

  public void getPermutation(int[] arr, int k, int index) {
    //if (count == k) return;
    if (index >= arr.length) {
      System.out.println(Arrays.toString(arr));
      count++;
      if (count == k) {
        for (int val : arr) {
          result.append(val);
        }
      }
      return;
    }

    for (int i = index; i < arr.length; i++) {
        int tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
        getPermutation(arr, k, index+1);
        tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
    }
  }

  public static void main(String[] args) {
    Permutation_Sequence_60 solution = new Permutation_Sequence_60();
    System.out.println(solution.getPermutation(4, 5));
    Integer[] arr = {1,2,3,4};
    Arrays.asList(arr);

  }

}
