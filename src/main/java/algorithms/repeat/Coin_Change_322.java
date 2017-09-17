package algorithms.repeat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fei Hu on 9/16/17.
 */
public class Coin_Change_322 {

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) return 0;

    int[] count = new int[amount+1];

    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        int rest = i - coin;
        if (rest >= 0 && count[rest] >= 0) {
          min = Math.min(count[rest]+1, min);
        }
      }
      if (min == Integer.MAX_VALUE) {
        count[i] = -1;
      } else {
        count[i] = min;
      }
    }
    return count[amount];
  }

  public static void main(String[] args) {
    Coin_Change_322 solution = new Coin_Change_322();
    int[] coins = new int[] {2};
    int amount = 2;
    solution.coinChange(coins, amount);
  }

}
