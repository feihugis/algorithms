package algorithms.repeat;

import java.util.Arrays;

/**
 * Created by Fei Hu on 9/16/17.
 */
public class Longest_Increasing_Subsequence_300 {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return len;
  }

  public int lengthOfLIS_dp(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int result = 1;
    for (int i = 0; i < nums.length; i++) {
      int max = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          max = Math.max(max, dp[j]+1);
        }
      }
      dp[i] = max;
      result = Math.max(result, max);
    }
    return result;
  }

  public int lengthOfLIS_memo(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int[][] memo = new int[nums.length][nums.length];

    int r1 = lengthOfLIS(nums, -1, 0, memo);
    return r1;
  }

  public int lengthOfLIS(int[] nums, int cur, int next, int[][] memo) {
    if (next == nums.length) return 0;
    if (cur >= 0 && memo[cur][next] > 0) return memo[cur][next];
    int taken = 0;
    if (cur < 0 || nums[next] > nums[cur]) {
      taken = 1 + lengthOfLIS(nums, next, next+1, memo);
    }

    int nontaken = lengthOfLIS(nums, cur, next+1, memo);
    if (cur >= 0) {
      memo[cur][next] = Math.max(taken, nontaken);
    }

    return Math.max(taken, nontaken);
  }

  public static void main(String[] args) {
    Longest_Increasing_Subsequence_300 solution = new Longest_Increasing_Subsequence_300();
    int[] input = new int[]{0, 8, 4, 12, 2};
    solution.lengthOfLIS(input);
  }

}
