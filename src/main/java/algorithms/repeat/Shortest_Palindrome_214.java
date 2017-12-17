package algorithms.repeat;

public class Shortest_Palindrome_214 {
  public String shortestPalindrome(String s) {
    if ( s == null || s.length() == 0) return "";
    String comb = s + "#" + new StringBuilder(s).reverse();
    int[] table = new int[comb.length()];
    for (int i = 1; i < comb.length(); i++) {
      int index = i - 1;
      while (index >= 0 && comb.charAt(i) != comb.charAt(table[index])) {
        index = table[index] - 1;
      }

      if (index >= 0 && comb.charAt(i) == comb.charAt(table[index])) {
        table[i] = table[index] + 1;
      }
    }

    int end = table[comb.length() - 1];
    return new StringBuilder(s.substring(end)).reverse().toString() + s;
  }

  public static void main(String[] args) {
    Shortest_Palindrome_214 solution = new Shortest_Palindrome_214();
    String input = "aacecaaa";
    String[] strs = "abscd".split("\t");
    System.out.println(solution.shortestPalindrome(input));

  }

}
