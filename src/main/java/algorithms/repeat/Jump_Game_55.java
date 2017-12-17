package algorithms.repeat;

import java.util.HashMap;

public class Jump_Game_55 {
  public boolean canJump(int[] nums) {
    HashMap<Integer, Boolean> record = new HashMap<Integer, Boolean>();
    return canJump(nums, 0, record);
  }

  // This dynamic programming with recursion may lead the stackoverflow error
  public boolean canJump(int[] nums, int index, HashMap<Integer, Boolean> record) {
    if (index >= nums.length - 1) {
      return true;
    }

    if (record.containsKey(index)) {
      return record.get(index);
    }

    int maxLoc = index + nums[index];

    for (int i = maxLoc; i > index; i--) {
      boolean jump = canJump(nums, i, record);
      if (jump) {
        record.put(i, true);
        return true;
      } else {
        record.put(index, false);
      }
    }

    record.put(index, false);
    return false;
  }

  enum Status {
    GOOD, BAD, UNKNOWN
  }

  // Top-down to bottom-up conversion is done by eliminating recursion. In practice, this achieves
  // better performance as we no longer have the method stack overhead and might even benefit from
  // some caching.
  public boolean canJump_v2(int[] nums) {
    Status[] memo = new Status[nums.length];
    for (int i = 0; i < nums.length; i++) {
      memo[i] = Status.UNKNOWN;
    }
    memo[memo.length - 1] = Status.GOOD;

    int lastIndex = nums.length - 1;

    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= lastIndex) {
        memo[i] = Status.GOOD;
        lastIndex = i;
      } else {
        memo[i] = Status.BAD;
      }
    }

    return memo[0] == Status.GOOD;
  }

  public static void main(String[] args) {
    Jump_Game_55 solution = new Jump_Game_55();

    int[] nums = new int[Integer.MAX_VALUE/2000000];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = 1;
    }

    System.out.println(solution.canJump(nums));
  }

}
