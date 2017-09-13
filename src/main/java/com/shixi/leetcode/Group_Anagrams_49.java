package com.shixi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Fei Hu on 8/21/17.
 */
public class Group_Anagrams_49 {

  int[] prime = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<List<String>>();

    HashMap<Long, List<String>> map = new HashMap<Long, List<String>>();
    List<List<String>> result = new ArrayList<List<String>>();
    for (int i = 0; i < strs.length; i++) {
      long hashcode = getHashCode(strs[i]);
      if (map.containsKey(hashcode)) {
        map.get(hashcode).add(strs[i]);
      } else {
        List<String> value = new ArrayList<String>();
        value.add(strs[i]);
        map.put(hashcode, value);
      }
    }

    result.addAll(map.values());
    return result;
  }

  public long getHashCode(String str) {
    char[] inputs = str.toCharArray();
    long hashcode = 1;

    for (int i = 0; i < inputs.length; i++) {
      hashcode = hashcode * prime[inputs[i] - 'a'];
    }

    return hashcode;
  }

  public static void main(String[] args) {
    Group_Anagrams_49 solution = new Group_Anagrams_49();
    System.out.println(solution.getHashCode("cid"));

    String[] inputs = new String[] {"axe", "all"};
    System.out.println(solution.groupAnagrams(inputs));
    int[] array = new int[0];
    System.out.println(array);

    
  }
}

