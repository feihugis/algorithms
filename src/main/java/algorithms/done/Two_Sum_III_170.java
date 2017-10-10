package algorithms.done;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Two_Sum_III_170 {
  HashMap<Integer, Integer> map = null;
  /** Initialize your data structure here. */
  public Two_Sum_III_170() {
    map = new HashMap<Integer, Integer>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    map.put(number, 1 + map.getOrDefault(number, 0));
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (int i : map.keySet()) {
      int rest = value - i;
      if (map.containsKey(rest)) {
        if (rest != i || map.get(rest) >= 2) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    map.put(2, 2);
    Set<Integer> set = map.keySet();
    System.out.println(set.getClass());

    for (int i : set) {
      System.out.println(-i);
    }
  }

}
