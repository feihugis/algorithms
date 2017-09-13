package algorithms.done;

import java.util.Stack;

/**
 * Created by Fei Hu on 9/12/17.
 */
public class Third_Maximum_Number_414 {
  public int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) throw new IllegalArgumentException();

    int rank = nums.length >= 3? 3 : 1;
    int max = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < rank; i++) {
      max = Integer.MIN_VALUE;
      boolean isUpdate = false;
      for (int num : nums) {
        if (max <= num && !stack.contains(num)) {
          max = num;
          isUpdate = true;
        }
      }

      if (isUpdate) {
        stack.add(max);
      }
    }

    if (stack.size() != rank) {
      while(stack.size() > 1) {
        stack.pop();
      }
    }

    return stack.peek();
  }

}
