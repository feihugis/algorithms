package com.shixi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Fei Hu on 8/29/17.
 */
public class Word_Ladder_127 {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || wordList == null || wordList.isEmpty()) return 0;
    if (!wordList.contains(endWord)) return 0;
    if (isNeighbor(beginWord, endWord)) return 1;

    HashSet<String> visited = new HashSet<String>();
    int r = ladderLength(beginWord, endWord, wordList, visited);
    return r > 0? r+2 : 0;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList, HashSet<String> visited) {
    if (isNeighbor(beginWord, endWord)) return 0;

    if (visited.size() == wordList.size()) return 0;

    int result = Integer.MAX_VALUE;

    if (visited.size() < wordList.size()) {
      HashSet<String> candidates = findNext(beginWord, wordList, visited);

      if (candidates.isEmpty()) return 0;

      for (String s : candidates) {
        if (isNeighbor(s, endWord)) {
          return 1;
        }
      }

      for (String s : candidates) {
        visited.add(s);
        int rest = ladderLength(s, endWord, wordList, visited);
        if (rest > 0 && result > 0) {
          int r = rest > 0 ? 1 + rest : 0;
          result = Math.min(result, r);
        }
        visited.remove(s);
      }
    }

    return result;

  }

  public HashSet<String> findNext(String input, List<String> wordList, HashSet<String> visited) {
    HashSet<String> result = new HashSet<String>();
    for (int i = 0; i < wordList.size(); i++) {
      if (!visited.contains(wordList.get(i)) && isNeighbor(input, wordList.get(i))) {
        result.add(wordList.get(i));
      }
    }

    return result;
  }

  public boolean isNeighbor(String s1, String s2) {
    int count = 0;
    for (int j = 0; j < s1.length(); j++) {
      if (s1.charAt(j) != s2.charAt(j)) count++;
      if (count > 1) return false;
    }

    if (count == 1) return true;
    return false;
  }

  public static void main(String[] args) {
    Word_Ladder_127 solution = new Word_Ladder_127();
    String beginWord = "hit", endword = "cog";
    List<String> wordList = Arrays.asList(new String[]{"hot","cog","dot","dog","hit","lot","log"});

    System.out.println(solution.ladderLength(beginWord, endword, wordList));
  }

}
