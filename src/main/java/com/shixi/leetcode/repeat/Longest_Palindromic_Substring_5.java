package com.shixi.leetcode.repeat;

/**
 * Created by Fei Hu on 8/15/17.
 */
public class Longest_Palindromic_Substring_5 {

  public String longestPalindrome(String s) {
    if (s == null) return null;

    char[] input = s.toCharArray();
    String result = "";

    for (int i = 0; i < s.length(); i++) {
      String tmp = getPalindrome(input, i);
      result = result.length() > tmp.length()? result : tmp;
    }

    return result;

  }

  public String getPalindrome(char[] input, int center) {
    int left = center - 1, right = center + 1;

    while (left >= 0 && input[left] == input[center]) {
      left--;
    }

    while (right <= input.length - 1 && input[right] == input[center]) {
      right++;
    }

    while (left >= 0 && right <= (input.length -1)) {
      if (input[left] == input[right]) {
        left--;
        right++;
      } else {
        break;
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = left + 1; i <= right - 1; i++) {
      result.append(input[i]);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    Longest_Palindromic_Substring_5 test = new Longest_Palindromic_Substring_5();

    String input = "babad";

    String result = test.longestPalindrome(input);

    String t = "a@b".toLowerCase();
    System.out.println(t);
  }

}
