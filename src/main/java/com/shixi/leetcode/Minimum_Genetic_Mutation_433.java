package com.shixi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Fei Hu on 9/2/17.
 */
public class Minimum_Genetic_Mutation_433 {
  public int minMutation(String start, String end, String[] bank) {
    Stack<String> stack = new Stack<String>();
    List<String> tmp = new ArrayList<String>();
    List<String> bankList = new ArrayList<String>();
    bankList.addAll(Arrays.asList(bank));
    stack.add(start);
    int count = 0;
    while(!stack.isEmpty()) {
      String cur = stack.pop();
      for (String s : bankList) {
        if (isMutation(s, cur)) {
          tmp.add(s);
          if (s.equals(end)) return ++count;
        }
      }
      if (stack.isEmpty()) {
        stack.addAll(tmp);
        bankList.removeAll(tmp);
        tmp.clear();
        count++;
      }
    }

    return -1;
  }

  public boolean isMutation(String first, String second) {
    int count = 0;
    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) count++;
      if (count > 1) return false;
    }

    if (count == 0) return false;
    return true;
  }

  public static void main(String[] args) {
    Minimum_Genetic_Mutation_433 solution = new Minimum_Genetic_Mutation_433();
    int num = solution.minMutation("AACCGGTT",
                                "AAACGGTA",
                                new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"});
    System.out.println(num);
  }
}
