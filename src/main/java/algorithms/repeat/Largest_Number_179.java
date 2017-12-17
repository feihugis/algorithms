package algorithms.repeat;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Fei Hu on 8/22/17.
 */
public class Largest_Number_179 {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) return "";

    int[] helper = new int[nums.length];

    sortNums(nums, helper, 0, nums.length - 1);
    StringBuilder str = new StringBuilder();
    for (int i : nums) {
      str.append(i).append(",");
    }

    return str.toString();
  }

  public void sortNums(int[] nums, int[] helper, int start, int end) {
    if (end <= start) return;

    int mid = (start + end)/2;
    sortNums(nums, helper, start, mid);
    sortNums(nums, helper, mid+1, end);

    for (int i = start; i <= end; i++) {
      helper[i] = nums[i];
    }

    int left = start, right = mid + 1, current = start;

    while (left <= mid && right <= end) {
      if (larger(helper[left], helper[right])) {
        nums[current] = helper[left];
        left++;
      } else {
        nums[current] = helper[right];
        right++;
      }
      current++;
    }

    int remaining = mid - left + 1;

    for (int i = 0; i < remaining; i++ ) {
      nums[current] = helper[left];
      left++;
      current++;
    }
  }

  public boolean larger(int num1, int num2) {
    char[] n1 = String.valueOf(num1).toCharArray();
    char[] n2 = String.valueOf(num2).toCharArray();
    if (n1.length == n2.length) return num1 >= num2;
    if (n1.length <= n2.length) {
      int i = 0;
      for (; i < n1.length; i++) {
        if (n1[i] > n2[i]) return true;
        if (n1[i] < n2[i]) return false;
      }
      for (; i < n2.length; i++) {
        if (n2[i] > n2[i%n1.length]) {
          return false;
        }
      }
      return true;
    } else {
      int i = 0;
      for (; i < n2.length; i++) {
        if (n1[i] > n2[i]) return true;
        if (n1[i] < n2[i]) return false;
      }
      for (; i < n1.length; i++) {
        if (n1[i] > n1[i%n2.length]) {
          return true;
        }
      }
      return false;
    }
  }

  public String largestNumber2(int[] nums) {
    if (nums == null || nums.length == 0) return "";
    String[] input = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      input[i] = String.valueOf(nums[i]);
    }

    Arrays.sort(input, new Comparator<String>() {
      @Override
      public int compare(String n1, String n2) {
        String s1 = n1 + n2;
        String s2 = n2 + n1;
        return -1 * s1.compareTo(s2);
      }
    });

    if (input[0].equals("0")) return "0";

    StringBuilder stringBuilder = new StringBuilder();
    for (String s : input) {
      stringBuilder.append(s);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    Largest_Number_179 solution = new Largest_Number_179();
    int[] inputs = new int[] {824,938,1399,5607,6973,5703,9609,4398,8247};
    System.out.println(solution.largestNumber(inputs));
    "".compareTo("");
  }

}
