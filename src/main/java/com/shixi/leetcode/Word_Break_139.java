package com.shixi.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Fei Hu on 8/20/17.
 *
 * TODO: performance needs to be improved.
 */
public class Word_Break_139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.isEmpty() || s.equals("")) return true;

    Set<String> wordHash = new HashSet<String>(wordDict);
    if (wordHash.contains(s)) return true;

    for (int i = 1; i <= s.length(); i++) {
      boolean s1Break = wordHash.contains(s.substring(0, i));  //wordBreak(s.substring(0, i), wordDict); will trigger unlimited recursion
      boolean s2Break = wordBreak(s.substring(i), wordDict);

      if (s1Break && s2Break) return true;
    }

    return false;
  }

  public static void main(String[] args) {
    List<String> wordDict = new ArrayList<String>();
    wordDict.add("leet");
    wordDict.add("code");

    String s = "leetcode";

    Word_Break_139 solution = new Word_Break_139();

    System.out.println(solution.wordBreak(s, wordDict));
  }

}
