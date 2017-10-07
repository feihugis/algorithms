package algorithms.done;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Genetic_Mutation_433 {
  public int minMutation(String start, String end, String[] bank) {
    if (bank == null || bank.length < 1) return -1;
    List<String> next = new ArrayList<String>();
    List<String> rest = new ArrayList<String>();
    for (String s : bank) {
      if (isMutation(start, s)) {
        next.add(s);
      } else {
        rest.add(s);
      }
    }
    int result = Integer.MAX_VALUE;
    String[] newBand = rest.toArray(new String[0]);

    for (String s : next) {
      int count = 1;
      if (s.equals(end)) {
        return count;
      } else {
        int second = minMutation(s, end, newBand);
        if (second >= 0 && second < Integer.MAX_VALUE) {
          result = Math.min(count+second, result);
        }
      }
    }

    if (result == Integer.MAX_VALUE) {
      return -1;
    } else {
      return result;
    }
  }

  public boolean isMutation(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        count++;
        if (count > 1) {
          return false;
        }
      }
    }
    if (count == 1) {
      return true;
    } else {
      return false;
    }
  }

}
