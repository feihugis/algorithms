package com.shixi.leetcode.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Fei Hu on 9/1/17.
 */
public class Palindrome_Partitioning_131 {
  HashMap<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<List<String>>();
    if (s == null || s.isEmpty()) return result;

    if (s.length() == 1) {
      List<String> r = new ArrayList<String>();
      r.add(s);
      result.add(r);
      return result;
    }

    if (map.containsKey(s)) return map.get(s);

    for (int i = s.length() - 1; i >= 0; i--) {
      if (isPalindrome(s, i, s.length() - 1)) {
        String end = s.substring(i, s.length());
        String left = s.substring(0, i);
        if (left.isEmpty()) {
          List<String> tmp = new ArrayList<String>();
          tmp.add(end);
          result.add(tmp);
        } else {
          List<List<String>> rest = partition(s.substring(0,i));
          for (List<String> list : rest) {
            List<String> tmp = new ArrayList<String>(list);
            tmp.add(end);
            result.add(tmp);
          }
        }
      }
    }

    map.put(s, result);

    return result;
  }


  public boolean isPalindrome(String input, int start, int end) {
    while (input.charAt(start) == input.charAt(end)) {
      start++;
      end--;
      if (end < start) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String input = "aab";
    Palindrome_Partitioning_131 solution = new Palindrome_Partitioning_131();

    List<List<String>> result = solution.partition(input);
  }

}
